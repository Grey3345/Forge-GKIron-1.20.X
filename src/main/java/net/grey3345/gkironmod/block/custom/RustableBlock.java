package net.grey3345.gkironmod.block.custom;

import net.grey3345.gkironmod.block.ModBlocks;
import net.grey3345.gkironmod.item.ModItems;
import net.grey3345.gkironmod.util.HeatStateMap;
import net.grey3345.gkironmod.util.RustStateMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RustableBlock extends Block implements WeatheringCopper {

    private final WeatherState weatherState;

    public RustableBlock(Properties properties, WeatherState weatherState) {
        super(properties.randomTicks());
        this.weatherState = weatherState;
    }

    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getItem() == Items.HONEYCOMB) {
            setWaxed(state,world,pos,player,hand);
        } else
        if (stack.getItem() == Items.FLINT_AND_STEEL){
            setUnwaxed(state,world,pos,player,hand);
        } else
        if (stack.getItem() == ModItems.SAND_PAPER.get()){
            decreaseStage(state,world,pos,player,hand);
        }
        return InteractionResult.PASS;
    }

    public static void decreaseStage(BlockState state, Level world, BlockPos pos, @Nullable Player player, @Nullable InteractionHand hand) {
        Optional<Block> block = RustStateMap.getDecrease(state.getBlock());
        if (block.isPresent()) {
            world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 11);
            world.levelEvent(player, 3003, pos, 0);
            if (player != null) {
                world.levelEvent(player, 3003, pos, 0);
                player.getItemInHand(hand != null ? hand : InteractionHand.MAIN_HAND).shrink(1);
            }
        }
    }

    public static void decreaseStage(BlockState state, Level world, BlockPos pos) {
        decreaseStage(state,world,pos,null,null);
    }

    public static void setWaxed(BlockState state, Level world, BlockPos pos, @Nullable Player player, @Nullable InteractionHand hand) {
        Optional<Block> block = RustStateMap.getWaxed(state.getBlock());
        if (block.isPresent()) {
            world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 11);
            if (player != null) {
                world.levelEvent(player, 3003, pos, 0);
                player.getItemInHand(hand != null ? hand : InteractionHand.MAIN_HAND).shrink(1);
            }
        }
    }

    public static void setWaxed(BlockState state, Level world, BlockPos pos) {
        setWaxed(state,world,pos,null,null);
    }

    public static void setUnwaxed(BlockState state, Level world, BlockPos pos, @Nullable Player player, @Nullable InteractionHand hand) {
        Optional<Block> block = RustStateMap.getUnwaxed(state.getBlock());
        if (block.isPresent()) {
            world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 11);
            if (player != null) {
                world.levelEvent(player, 3003, pos, 0);
                ItemStack stack = player.getItemInHand(hand != null ? hand : InteractionHand.MAIN_HAND);
                stack.setDamageValue(stack.getDamageValue() + 1);
            }
        }
    }

    public static void setUnwaxed(BlockState state, Level world, BlockPos pos) {
        setUnwaxed(state,world,pos,null,null);
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return RustStateMap.getIncrease(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, level, pos, random);
    }

    public boolean lavaBelow(BlockState p_50986_, LevelReader levelreader, BlockPos p_50988_) {
        BlockState blockstate = levelreader.getBlockState(p_50988_.below());

        return blockstate.is(ModBlocks.CUSTOM_BUBBLES.get()) || blockstate.getBlock() instanceof HeatableBlock || blockstate.is(Blocks.SOUL_SAND);
    }


    @Override
    public void applyChangeOverTime(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = this.getAge().ordinal();
        int j = 0;
        int k = 0;

        if (!level.getBlockState(pos.below()).is(Blocks.LAVA)) {
        for(BlockPos blockpos : BlockPos.withinManhattan(pos, 4, 4, 4)) {
            int l = blockpos.distManhattan(pos);
            if (l > 4) {
                break;
            }

            if (!blockpos.equals(pos)) {
                BlockState blockstate = level.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof ChangeOverTimeBlock) {
                    Enum<?> oenum = ((ChangeOverTimeBlock)block).getAge();
                    if (this.getAge().getClass() == oenum.getClass()) {
                        int i1 = oenum.ordinal();
                        if (i1 < i) {
                            return;
                        }

                        if (i1 > i) {
                            ++k;
                        } else {
                            ++j;
                        }
                    }
                }
            }
        }
        }

        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        if (random.nextFloat() < f1) {
            if (level.getBlockState(pos.below()).is(Blocks.LAVA)) {
                // Keep heating
                if (HeatStateMap.getHeated(state.getBlock()).isPresent()) {
                    level.setBlock(pos, HeatStateMap.getHeated(state.getBlock()).get().defaultBlockState(), 3);
                }
            } else {
                // No heat, cool
                if (HeatStateMap.getCooled(state.getBlock()).isPresent()) {
                    level.setBlock(pos, HeatStateMap.getCooled(state.getBlock()).get().defaultBlockState(), 3);
                }
            }
        }
        /**
        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        if (random.nextFloat() < f1) {
            // Heat up
            if (HeatStateMap.getHeated(state.getBlock()).isPresent()) {
                level.setBlock(pos, HeatStateMap.getHeated(state.getBlock()).get().defaultBlockState(), 3);
            }
        }
        **/

        WeatheringCopper.super.applyChangeOverTime(state, level, pos, random);
    }

    /**
    public boolean isLava(BlockState state, LevelReader level, BlockPos pos){
        boolean fast;
        if (level.getBlockState(pos.below()).is(Blocks.LAVA)) {
            return fast = true;
            //return HeatStateMap.getHeated(state.getBlock()).isPresent();
        } else {
            return fast = false;
            //return RustStateMap.getIncrease(state.getBlock()).isPresent();
        }

        if (level.getBlockState(pos.below()).is(Blocks.LAVA)) {
            return HeatStateMap.getHeated(state.getBlock()).isPresent();
        }
    }
     **/




    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return RustStateMap.getIncrease(state.getBlock()).isPresent();
    }



    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
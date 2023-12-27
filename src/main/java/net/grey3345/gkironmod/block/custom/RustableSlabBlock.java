package net.grey3345.gkironmod.block.custom;

import net.grey3345.gkironmod.item.ModItems;
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
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Optional;

import static net.grey3345.gkironmod.block.custom.RustableBlock.*;

public class RustableSlabBlock extends SlabBlock implements WeatheringCopper {
    private final WeatherState weatherState;

    public RustableSlabBlock(Properties properties, WeatherState weatherState) {
        super(properties);
        this.weatherState = weatherState;
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

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return RustStateMap.getIncrease(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    public void randomTick(BlockState p_222675_, ServerLevel p_222676_, BlockPos p_222677_, RandomSource p_222678_) {
        this.onRandomTick(p_222675_, p_222676_, p_222677_, p_222678_);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return RustStateMap.getIncrease(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}

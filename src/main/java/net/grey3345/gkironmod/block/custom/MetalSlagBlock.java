package net.grey3345.gkironmod.block.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class MetalSlagBlock extends FallingBlock {
    public static BooleanProperty STICKY = BooleanProperty.create("sticky");


    public MetalSlagBlock(Properties p_53205_) {
        super(p_53205_);
        this.registerDefaultState(this.getStateDefinition().any().setValue(STICKY, false));
    }

    @Override
    public void tick(BlockState state, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (isSticky(state)) return;

        super.tick(state, serverLevel, blockPos, randomSource);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() == Items.SLIME_BALL) {
            if (isSticky(state)) return InteractionResult.PASS;
            setSticky(level,pos,state,true);
            stack.shrink(1);
            level.playSound(null,pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS,1f,1f);
            return InteractionResult.SUCCESS;
        }

        if (PotionUtils.getPotion(stack) == Potions.WATER) {
            if (!isSticky(state)) return InteractionResult.PASS;
            setSticky(level,pos,state,false);
            stack.shrink(1);
            player.setItemInHand(MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE, 1));
            level.playSound(null,pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS,1f,1f);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STICKY);
    }

    public static boolean isSticky(BlockState state) {
        if (state.hasProperty(STICKY)) {
            return state.getValue(STICKY);
        }
        LogUtils.getLogger().error(state + " did not have sticky property! Returning false.");
        return false;
    }


    public static void setSticky(Level level,BlockPos pos,BlockState state, boolean val) {
        if (state.hasProperty(STICKY)) {
            state = state.setValue(STICKY,val);
        }
        level.setBlock(pos,state,3);
    }

    public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return -8356741;
    }
}

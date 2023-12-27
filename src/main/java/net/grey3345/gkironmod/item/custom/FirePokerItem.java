package net.grey3345.gkironmod.item.custom;

import net.grey3345.gkironmod.block.custom.HeatableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class FirePokerItem extends Item {
    public FirePokerItem(Properties prop) {
        super(prop);
    }

    /**
     * Moves the heat block if the direction its moving in is air
     * @param level
     * @param pos
     * @param dir
     * @return success
     */
    public static boolean moveHeatBlock(Level level, BlockPos pos, Direction dir) {
        if (!(level.getBlockState(pos).getBlock() instanceof HeatableBlock)) return false;
        if (!level.getBlockState(pos.relative(dir)).isAir()) return false;

        BlockState state = level.getBlockState(pos);
        level.setBlock(pos.relative(dir),state,3);
        level.setBlock(pos, Blocks.AIR.defaultBlockState(),3);

        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return moveHeatBlock(context.getLevel(),context.getClickedPos(),context.getClickedFace().getOpposite()) ? InteractionResult.SUCCESS : InteractionResult.PASS;
    }
}

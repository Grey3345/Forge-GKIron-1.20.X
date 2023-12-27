package net.grey3345.gkironmod.block.custom;

import net.grey3345.gkironmod.block.entities.ModBlockEntities;
import net.grey3345.gkironmod.block.entities.WeightBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;

public class WeightBlock extends FallingBlock implements EntityBlock {


    private static final VoxelShape TOP = Block.box(4.0D, 5.0D, 4.0D, 12.0D, 11.0D, 12.0D);
    private static final VoxelShape MID = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D);
    private static final VoxelShape BASE = Block.box(1.0D, 11.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    private static final VoxelShape SHAPE = Shapes.or(BASE, MID, TOP);


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext selectionContext)
    {
        return SHAPE;
    }
    public WeightBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    //@Override
    //public RenderShape getRenderShape(BlockState pState) {
    //    return RenderShape.MODEL;
    //}

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (isFree(pLevel.getBlockState(pPos.below())) && pPos.getY() >= pLevel.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(pLevel, pPos, pState);
            this.falling(fallingblockentity);
        }
    }

    protected void falling(FallingBlockEntity pFallingEntity) {
        pFallingEntity.setHurtsEntities(2.0F, 40);
    }

    public static void attemptPush(Level level, BlockPos pos) {
        if (level.isClientSide) return;

        if (level.getBlockState(pos.below()).isAir()) {
            // Move self down
            //moveBlockDown(pos,level.getBlockState(pos),level);
            return;
        };
        // Definitely something below

        // Ignore other weighted blocks
        if (level.getBlockState(pos.below()).getBlock() instanceof WeightBlock) return;

        HashMap<BlockPos, BlockState> above = getAboveWeightedBlocks(level,pos);
        int count = above.size() + 1; // + 1 for this block itself

        HashMap<BlockPos, BlockState> below = getBlocksBelow(level,pos,count);
        moveAllBlocksOneDown(below,level);
    }

    public static void moveBlockDown(BlockPos pos, BlockState state, Level level) {
        if (level.getBlockState(pos).isAir() || !level.getBlockState(pos.below()).isAir()) return;
        level.setBlock(pos.below(),state,3);
        level.setBlock(pos, Blocks.AIR.defaultBlockState(),3);
    }

    public static void moveAllBlocksOneDown(HashMap<BlockPos, BlockState> coords, Level level) {
        for (BlockPos pos : coords.keySet()) {
            moveBlockDown(pos,coords.get(pos),level);
        }
    }

    public static HashMap<BlockPos, BlockState> getBlocksBelow(Level level, BlockPos pos, int count) {
        BlockPos check = pos;
        BlockState checkState;
        HashMap<BlockPos, BlockState> list = new HashMap<>();
        for (int i = 0; i < count; i++) {
            check = check.below();
            checkState = level.getBlockState(check);

            if (checkState.isAir()) return list; // Stop once we reach the first air.

            list.put(check,checkState);
        }
        return list;
    }

    public static HashMap<BlockPos, BlockState> getAboveWeightedBlocks(Level level, BlockPos pos) {
        BlockPos check = pos;
        BlockState checkState;
        HashMap<BlockPos, BlockState> list = new HashMap<>();
        for (int i = 0; i < 15; i++) { // 15 because only checking 15 above blocks
            check = check.above();
            checkState = level.getBlockState(check);

            if (checkState.isAir()) return list; // Stop once we reach the first air.

            if (checkState.getBlock() instanceof WeightBlock) {
                list.put(check,checkState);
            }
        }
        return list;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
            if(blockEntity instanceof WeightBlockEntity) {
                WeightBlockEntity weight = (WeightBlockEntity) blockEntity;
                weight.tick();
            }
        };
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState pState) {
        return ModBlockEntities.WEIGHT_BLOCK_ENTITY.get().create(blockPos, pState);
    }
}

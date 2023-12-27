package net.grey3345.gkironmod.util;


import net.grey3345.gkironmod.block.ModBlocks;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HeatStateMap {
    private static final Map<Block, Block> HEATED = new HashMap<>();

    private static final Map<Block, Block> COOLED = new HashMap<>();

    private static final Map<Block, Block> TREATED = new HashMap<>();

    private static final Map<Block, Block> UNTREATED = new HashMap<>();

    public static HeatState getStateFromBlockName(Block block) {
        String id = block.getDescriptionId().toLowerCase();
        int pos = -1;

        for (HeatState state : HeatState.values()) {
            pos = id.indexOf(state.toString().toLowerCase());
            if (pos == -1) continue;
            return state;
        }
        return null;
    }

    public static void put(Block block, @Nullable Block heated, Block waxed) {
        if (heated != null) {
            HEATED.put(block, heated);
            COOLED.put(heated, block);
        }
        TREATED.put(block, waxed);
        UNTREATED.put(waxed, block);
    }

    public static Optional<Block> getHeated(Block block) {
        return Optional.ofNullable(HEATED.get(block));
    }

    public static Optional<Block> getCooled(Block block) {
        return Optional.ofNullable(COOLED.get(block));
    }

    public static Optional<Block> getTreated(Block block) {
        return Optional.ofNullable(TREATED.get(block));
    }

    public static Optional<Block> getUntreated(Block block) { return Optional.ofNullable(UNTREATED.get(block)); }

    public static Block getOriginalStage(Block block) {
        var result = block;
        for (var b = getCooled(block); b.isPresent(); b = getCooled(b.get())) {
            result = b.get();
        }
        return result;
    }

    static {
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_WARM_TREATED.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_BURN.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_HOT_TREATED.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_BURN.get(), null, ModBlocks.RAW_WROUGHT_IRON_BLOCK_BURN_TREATED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK.get(), ModBlocks.WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.WROUGHT_IRON_BLOCK.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.WROUGHT_IRON_BLOCK_WARM_TREATED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.WROUGHT_IRON_BLOCK_BURN.get(), ModBlocks.WROUGHT_IRON_BLOCK_HOT_TREATED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_BURN.get(), null, ModBlocks.WROUGHT_IRON_BLOCK_BURN_TREATED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WARM.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WARM_TREATED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_HOT.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_BURN.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_HOT_TREATED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_BURN.get(), null, ModBlocks.REFINED_WROUGHT_IRON_BLOCK_BURN_TREATED.get());
    }
}
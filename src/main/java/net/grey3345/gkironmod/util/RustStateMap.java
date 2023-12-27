package net.grey3345.gkironmod.util;

import net.grey3345.gkironmod.block.ModBlocks;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RustStateMap {


    private static final Map<Block, Block> INCREASES = new HashMap<>();

    private static final Map<Block, Block> DECREASES = new HashMap<>();

    private static final Map<Block, Block> WAXED = new HashMap<>();

    private static final Map<Block, Block> UNWAXED = new HashMap<>();

    public static void put(Block block, @Nullable Block oxidized, Block waxed) {
        if (oxidized != null) {
            INCREASES.put(block, oxidized);
            DECREASES.put(oxidized, block);
        }
        WAXED.put(block, waxed);
        UNWAXED.put(waxed, block);
    }

    public static void put(Block block, Block waxed) {
        put(block,null,waxed);
    }

    public static Optional<Block> getIncrease(Block block) {
        return Optional.ofNullable(INCREASES.get(block));
    }

    public static Optional<Block> getDecrease(Block block) {
        return Optional.ofNullable(DECREASES.get(block));
    }

    public static Optional<Block> getWaxed(Block block) {
        return Optional.ofNullable(WAXED.get(block));
    }

    public static Optional<Block> getUnwaxed(Block block) { return Optional.ofNullable(UNWAXED.get(block)); }

    public static Block getOriginalStage(Block block) {
        var result = block;
        for (var b = getDecrease(block); b.isPresent(); b = getDecrease(b.get())) {
            result = b.get();
        }
        return result;
    }

    static {
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_WAXED.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_EXPOSED_WAXED.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_RUSTED.get(), ModBlocks.RAW_WROUGHT_IRON_BLOCK_WEATHERED_WAXED.get());
        put(ModBlocks.RAW_WROUGHT_IRON_BLOCK_RUSTED.get(), null, ModBlocks.RAW_WROUGHT_IRON_BLOCK_RUSTED_WAXED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK.get(), ModBlocks.WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.WROUGHT_IRON_BLOCK_WAXED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.WROUGHT_IRON_BLOCK_EXPOSED_WAXED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.WROUGHT_IRON_BLOCK_RUSTED.get(), ModBlocks.WROUGHT_IRON_BLOCK_WEATHERED_WAXED.get());
        put(ModBlocks.WROUGHT_IRON_BLOCK_RUSTED.get(), null, ModBlocks.WROUGHT_IRON_BLOCK_RUSTED_WAXED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WAXED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_EXPOSED.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_EXPOSED_WAXED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WEATHERED.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_RUSTED.get(), ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WEATHERED_WAXED.get());
        put(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_RUSTED.get(), null, ModBlocks.REFINED_WROUGHT_IRON_BLOCK_RUSTED_WAXED.get());

    }
}
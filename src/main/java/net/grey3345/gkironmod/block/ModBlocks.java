package net.grey3345.gkironmod.block;

import net.grey3345.gkironmod.GKIronMod;
import net.grey3345.gkironmod.block.custom.*;
import net.grey3345.gkironmod.fluid.ModFluids;
import net.grey3345.gkironmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.obj.ObjMaterialLibrary;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GKIronMod.MOD_ID);


    public static final RegistryObject<LiquidBlock> MOLTEN_WROUGHT_METAL_BLOCK = BLOCKS.register("molten_wrought_metal_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_WROUGHT_METAL, BlockBehaviour.Properties.copy(Blocks.LAVA)));


    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registryBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PAINTED_WROUGHT_IRON_BLOCK = registryBlock("painted_wrought_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PAINTED_WROUGHT_IRON_BLOCK_TRIMMED = registryBlock("painted_wrought_iron_block_trimmed",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //region Raw, Formed, Refined Wrought Iron
    // Raw wrought Iron
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK = registryBlock("raw_wrought_iron_block",
            () -> new RustableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_EXPOSED = registryBlock("raw_wrought_iron_block_exposed",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_WEATHERED = registryBlock("raw_wrought_iron_block_weathered",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_RUSTED = registryBlock("raw_wrought_iron_block_rusted",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));

    // Raw wrought Iron Waxed
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_WAXED = registryBlock("raw_wrought_iron_block_waxed",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_EXPOSED_WAXED = registryBlock("raw_wrought_iron_block_exposed_waxed",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_WEATHERED_WAXED = registryBlock("raw_wrought_iron_block_weathered_waxed",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_RUSTED_WAXED = registryBlock("raw_wrought_iron_block_rusted_waxed",
            () -> new RustableBlock(Block.Properties.copy(RAW_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));




    // Formed wrought
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK = registryBlock("wrought_iron_block",
            () -> new RustableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_EXPOSED = registryBlock("wrought_iron_block_exposed",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_WEATHERED = registryBlock("wrought_iron_block_weathered",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_RUSTED = registryBlock("wrought_iron_block_rusted",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));

    // Formed wrought Iron Waxed
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_WAXED = registryBlock("wrought_iron_block_waxed",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_EXPOSED_WAXED = registryBlock("wrought_iron_block_exposed_waxed",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_WEATHERED_WAXED = registryBlock("wrought_iron_block_weathered_waxed",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_RUSTED_WAXED = registryBlock("wrought_iron_block_rusted_waxed",
            () -> new RustableBlock(Block.Properties.copy(WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));


    // Refined wrought
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK = registryBlock("refined_wrought_iron_block",
            () -> new RustableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_EXPOSED = registryBlock("refined_wrought_iron_block_exposed",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_WEATHERED = registryBlock("refined_wrought_iron_block_weathered",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_RUSTED = registryBlock("refined_wrought_iron_block_rusted",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));

    // Refined wrought Iron Waxed
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_WAXED = registryBlock("refined_wrought_iron_block_waxed",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_EXPOSED_WAXED = registryBlock("refined_wrought_iron_block_exposed_waxed",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_WEATHERED_WAXED = registryBlock("refined_wrought_iron_block_weathered_waxed",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_RUSTED_WAXED = registryBlock("refined_wrought_iron_block_rusted_waxed",
            () -> new RustableBlock(Block.Properties.copy(REFINED_WROUGHT_IRON_BLOCK.get()), WeatheringCopper.WeatherState.OXIDIZED));

//endregion


    //region Heated Blocks
    // Heated Wrought Iron Raw, Formed, Refined

    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_WARM = registryBlock("raw_wrought_iron_block_warm",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_WARM_TREATED = registryBlock("raw_wrought_iron_block_warm_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_HOT = registryBlock("raw_wrought_iron_block_hot",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_HOT_TREATED = registryBlock("raw_wrought_iron_block_hot_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_BURN = registryBlock("raw_wrought_iron_block_burn",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> RAW_WROUGHT_IRON_BLOCK_BURN_TREATED = registryBlock("raw_wrought_iron_block_burn_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));


    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_WARM = registryBlock("wrought_iron_block_warm",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_WARM_TREATED = registryBlock("wrought_iron_block_warm_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_HOT = registryBlock("wrought_iron_block_hot",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_HOT_TREATED = registryBlock("wrought_iron_block_hot_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_BURN = registryBlock("wrought_iron_block_burn",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK_BURN_TREATED = registryBlock("wrought_iron_block_burn_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));


    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_WARM = registryBlock("refined_wrought_iron_block_warm",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_WARM_TREATED = registryBlock("refined_wrought_iron_block_warm_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_HOT = registryBlock("refined_wrought_iron_block_hot",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_HOT_TREATED = registryBlock("refined_wrought_iron_block_hot_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_BURN = registryBlock("refined_wrought_iron_block_burn",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> REFINED_WROUGHT_IRON_BLOCK_BURN_TREATED = registryBlock("refined_wrought_iron_block_burn_treated",
            () -> new HeatableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).randomTicks(), WeatheringCopper.WeatherState.UNAFFECTED));
//endregion


    public static final RegistryObject<Block> METAL_SLAG_BLOCK = registryBlock("metal_slag_block", () -> new MetalSlagBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.TUFF)));
    //public static final RegistryObject<Block> SLAG_BLOCK = registryBlock("slag_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> WEIGHT_BLOCK = registryBlock("weight_block", () -> new WeightBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CUSTOM_BUBBLES = BLOCKS.register("custom_bubbles", () -> new CustomBubbleColumnBlock(BlockBehaviour.Properties.copy(Blocks.BUBBLE_COLUMN)));


    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

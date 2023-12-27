package net.grey3345.gkironmod.item;

import net.grey3345.gkironmod.GKIronMod;
import net.grey3345.gkironmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GKIronMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GKIRON_TAB = CREATIVE_MODE_TABS.register("gkiron_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAND_PAPER.get()))
            .title(Component.translatable("creativetab.gkiron_tab"))
            .displayItems((pParamerters, pOutput) -> {
                //pOutput.accept(ModItems.SAPPHIRE.get());

                pOutput.accept(ModItems.TONGS.get());
                pOutput.accept(ModItems.SAND_PAPER.get());
                pOutput.accept(ModItems.FIRE_POKER.get());
                pOutput.accept(ModItems.MOLTEN_WROUGHT_METAL_BUCKET.get());

                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());

                pOutput.accept(ModBlocks.PAINTED_WROUGHT_IRON_BLOCK.get());
                pOutput.accept(ModBlocks.PAINTED_WROUGHT_IRON_BLOCK_TRIMMED.get());
                //pOutput.accept(ModBlocks.SLAG_BLOCK.get());

                pOutput.accept(ModBlocks.METAL_SLAG_BLOCK.get());

                pOutput.accept(ModItems.SLAG.get());
                pOutput.accept(ModBlocks.WEIGHT_BLOCK.get());

                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_EXPOSED.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_WEATHERED.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_RUSTED.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_WARM.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_HOT.get());
                pOutput.accept(ModBlocks.RAW_WROUGHT_IRON_BLOCK_BURN.get());
                pOutput.accept(ModItems.RAW_WROUGHT_IRON_CHUNK.get());
                pOutput.accept(ModItems.WROUGHT_IRON_HORSESHOE.get());

                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_EXPOSED.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_WEATHERED.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_RUSTED.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_WARM.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_HOT.get());
                pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK_BURN.get());
                pOutput.accept(ModItems.WROUGHT_IRON_INGOT.get());
                pOutput.accept(ModItems.WROUGHT_IRON_NUGGET.get());

                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_EXPOSED.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WEATHERED.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_RUSTED.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_WARM.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_HOT.get());
                pOutput.accept(ModBlocks.REFINED_WROUGHT_IRON_BLOCK_BURN.get());
                pOutput.accept(ModItems.REFINED_WROUGHT_IRON_INGOT.get());
                pOutput.accept(ModItems.REFINED_WROUGHT_IRON_NUGGET.get());


    })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

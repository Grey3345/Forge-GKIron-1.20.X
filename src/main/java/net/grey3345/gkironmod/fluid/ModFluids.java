package net.grey3345.gkironmod.fluid;

import net.grey3345.gkironmod.GKIronMod;
import net.grey3345.gkironmod.block.ModBlocks;
import net.grey3345.gkironmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, GKIronMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_WROUGHT_METAL = FLUIDS.register("molten_wrought_metal_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_WROUGHT_METAL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_WROUGHT_METAL = FLUIDS.register("flowing_molten_wrought_metal",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_WROUGHT_METAL_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MOLTEN_WROUGHT_METAL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_WROUGHT_METAL_FLUID_TYPE, SOURCE_MOLTEN_WROUGHT_METAL, FLOWING_MOLTEN_WROUGHT_METAL)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MOLTEN_WROUGHT_METAL_BLOCK)
            .bucket(ModItems.MOLTEN_WROUGHT_METAL_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}

package net.grey3345.gkironmod.fluid;

import net.grey3345.gkironmod.GKIronMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation MOLTEN_WROUGHT_METAL_STILL_RL = new ResourceLocation("gkironmod:block/molten_wrought_metal_still");
    public static final ResourceLocation MOLTEN_WROUGHT_METAL_FLOWING_RL = new ResourceLocation("gkironmod:block/molten_wrought_metal_flowing");
    public static final ResourceLocation MOLTEN_WROUGHT_METAL_OVERLAY_RL = new ResourceLocation(GKIronMod.MOD_ID, "misc/in_molten_wrought_metal");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GKIronMod.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_WROUGHT_METAL_FLUID_TYPE = register("molten_wrought_metal_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).temperature(6).canSwim(true).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));




    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(MOLTEN_WROUGHT_METAL_STILL_RL, MOLTEN_WROUGHT_METAL_FLOWING_RL, MOLTEN_WROUGHT_METAL_OVERLAY_RL,
                0xA1ffffff, new Vector3f(255f / 255f, 20f / 255f, 60f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}

package net.grey3345.gkironmod.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.grey3345.gkironmod.GKIronMod;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class MoltenWroughtFluid extends FluidType {
    public static final ResourceLocation FLUID_STILL = new ResourceLocation("gkironmod:block/molten_wrought_metal_still");
    public static final ResourceLocation FLUID_FLOWING = new ResourceLocation("gkironmod:block/molten_wrought_metal_flowing");
    public static final ResourceLocation OVERLAY = new ResourceLocation(GKIronMod.MOD_ID, "misc/in_molten_wrought_metal");

    public MoltenWroughtFluid(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return FLUID_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOWING;
            }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return OVERLAY;
            }
        });

    }

}

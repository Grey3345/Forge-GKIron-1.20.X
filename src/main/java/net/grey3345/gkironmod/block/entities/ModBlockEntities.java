package net.grey3345.gkironmod.block.entities;

import net.grey3345.gkironmod.GKIronMod;
import net.grey3345.gkironmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GKIronMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WeightBlockEntity>> WEIGHT_BLOCK_ENTITY = BLOCK_ENTITIES.register("weight_block_entity", () -> BlockEntityType.Builder.of(WeightBlockEntity::new, ModBlocks.WEIGHT_BLOCK.get()).build(null));
}

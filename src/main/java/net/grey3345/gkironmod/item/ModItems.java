package net.grey3345.gkironmod.item;

import net.grey3345.gkironmod.GKIronMod;
import net.grey3345.gkironmod.fluid.ModFluids;
import net.grey3345.gkironmod.item.custom.FirePokerItem;
import net.grey3345.gkironmod.item.custom.TongsItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GKIronMod.MOD_ID);

    public static final RegistryObject<Item> MOLTEN_WROUGHT_METAL_BUCKET = ITEMS.register("molten_wrought_metal_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_WROUGHT_METAL,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
    () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SLAG = ITEMS.register("slag",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_WROUGHT_IRON_CHUNK = ITEMS.register("raw_wrought_iron_chunk",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_INGOT = ITEMS.register("wrought_iron_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_NUGGET = ITEMS.register("wrought_iron_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_HORSESHOE = ITEMS.register("wrought_iron_horseshoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REFINED_WROUGHT_IRON_INGOT = ITEMS.register("refined_wrought_iron_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REFINED_WROUGHT_IRON_NUGGET = ITEMS.register("refined_wrought_iron_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAND_PAPER = ITEMS.register("sand_paper",
            () -> new Item(new Item.Properties()));

    // DUZO TEST ITEMS REPLACE WITH YOUR OWN IF NECESSARY
    public static final RegistryObject<Item> FIRE_POKER = ITEMS.register("fire_poker", () -> new FirePokerItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TONGS = ITEMS.register("tongs", () -> new TongsItem(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package ca.maximilian.cursed_craft.item;

import ca.maximilian.cursed_craft.CursedCraft;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

//? >=1.21.9 {
/*import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

import java.util.function.Function;

public class ModItem {
    public static Item TNT_WAND = register("tnt_wand", TNTWand::new, new Item.Properties().durability(10));

    public static void init() {
        CursedCraft.LOGGER.info("Registering items...");

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((entries) -> entries.accept(TNT_WAND));

        CursedCraft.LOGGER.info("Done registering items!");
    }

    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, CursedCraft.id(CursedCraft.MOD_ID, name));

        Item item = itemFactory.apply(properties.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
*///?} else {
public class ModItem {
    public static Item TNT_WAND = new TNTWand(new Item.Properties().durability(10));

    public static void init() {
        CursedCraft.LOGGER.info("Registering items...");

        Registry.register(BuiltInRegistries.ITEM, CursedCraft.id(CursedCraft.MOD_ID, "tnt_wand"), TNT_WAND);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(TNT_WAND));

        CursedCraft.LOGGER.info("Done registering items!");
    }
}
//?}
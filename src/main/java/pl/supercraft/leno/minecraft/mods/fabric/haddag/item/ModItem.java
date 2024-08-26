package pl.supercraft.leno.minecraft.mods.fabric.haddag.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.Haddag;

public class ModItem {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    public static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Haddag.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Haddag.LOGGER.info("Registering Mod Items For " + Haddag.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::addItemsToIngredientTabItemGroup);
    }
}

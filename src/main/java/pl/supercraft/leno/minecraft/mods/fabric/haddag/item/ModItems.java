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
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.custom.MetalDetectorItem;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.custom.SieveItem;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item POLISHED_RUBY = registerItem("polished_ruby", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item LOG = registerItem("log", new Item(new FabricItemSettings()));
    public static final Item POWDERED_RUBY = registerItem("powdered_ruby", new Item(new FabricItemSettings().fireproof()));
    public static final Item SIEVE = registerItem("sieve", new SieveItem(new FabricItemSettings().fireproof()));

    public static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(POLISHED_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Haddag.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Haddag.LOGGER.info("Registering Mod Items For " + Haddag.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}

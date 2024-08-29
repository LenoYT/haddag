package pl.supercraft.leno.minecraft.mods.fabric.haddag;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.block.ModBlocks;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItems;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItemGroups;

public class Haddag implements ModInitializer {
	public static final String MOD_ID = "haddag";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.LOG, 200); // Item LOG - jest fuel - 10s
	}
}
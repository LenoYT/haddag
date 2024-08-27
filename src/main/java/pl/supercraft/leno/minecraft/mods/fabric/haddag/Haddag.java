package pl.supercraft.leno.minecraft.mods.fabric.haddag;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItems;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItemGroups;

public class Haddag implements ModInitializer {
	public static final String MOD_ID = "haddag";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}
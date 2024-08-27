package pl.supercraft.leno.minecraft.mods.fabric.haddag.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.Haddag;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_RED)
            .instrument(Instrument.HARP)
            .strength(5.0F, 10.0F)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .collidable(true)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Haddag.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Haddag.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Haddag.LOGGER.info("Registering Mod Blocks For " + Haddag.MOD_ID);

    }
}

package pl.supercraft.leno.minecraft.mods.fabric.haddag.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.Haddag;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.block.custom.SoundBlock;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_RED)
            .instrument(Instrument.HARP)
            .strength(5.0F, 10.0F)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .collidable(true)
            .requiresTool()
    ));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_GRAY)
            .strength(5.0F, 10.0F)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .collidable(true)
            .requiresTool(),
            UniformIntProvider.create(2, 5)
    ));
    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool()));

    // Ruby Decoration

    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(),FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool()));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab", new SlabBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool()));
    public static final Block RUBY_BUTTON = registerBlock("ruby_button", new ButtonBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool(), BlockSetType.IRON, 10, true));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool(), BlockSetType.IRON));
    public static final Block RUBY_FENCE = registerBlock("ruby_fence", new FenceBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool()));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate", new FenceGateBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool(), WoodType.ACACIA));
    public static final Block RUBY_WALL = registerBlock("ruby_wall", new WallBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool()));
    public static final Block RUBY_DOOR = registerBlock("ruby_door", new DoorBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool(), BlockSetType.IRON));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor", new TrapdoorBlock(FabricBlockSettings.create().strength(1.5F, 3.5F).collidable(true).requiresTool(), BlockSetType.IRON));

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

package pl.supercraft.leno.minecraft.mods.fabric.haddag.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.Haddag;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Haddag.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.POLISHED_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                    }).build());

    public static void registerItemGroups() {
        Haddag.LOGGER.info("Registering Item Groups For " + Haddag.MOD_ID);
    }
}

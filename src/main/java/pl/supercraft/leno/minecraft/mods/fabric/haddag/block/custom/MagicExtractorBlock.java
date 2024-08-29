package pl.supercraft.leno.minecraft.mods.fabric.haddag.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItems;

public class MagicExtractorBlock extends Block {
    public MagicExtractorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack stackInHand = player.getStackInHand(hand);

        if (stackInHand.isOf(ModItems.POLISHED_RUBY)) {
            stackInHand.decrement(1);

            if (Math.random() >= 0.6) {
                player.giveItemStack(ModItems.POWDERED_RUBY.getDefaultStack());

                world.playSound(player, pos, SoundEvents.ENTITY_VILLAGER_CELEBRATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            } else {
                world.playSound(player, pos, SoundEvents.ENTITY_VILLAGER_NO, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
}

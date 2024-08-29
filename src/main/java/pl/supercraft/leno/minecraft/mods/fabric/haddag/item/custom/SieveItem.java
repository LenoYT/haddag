package pl.supercraft.leno.minecraft.mods.fabric.haddag.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import pl.supercraft.leno.minecraft.mods.fabric.haddag.item.ModItems;

public class SieveItem extends Item {
    public SieveItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Hand otherHand;

        if (hand == Hand.MAIN_HAND) { otherHand = Hand.OFF_HAND; } else { otherHand = Hand.MAIN_HAND; }

        if (user.getStackInHand(otherHand).isOf(ModItems.POWDERED_RUBY)) {
            user.getStackInHand(otherHand).decrement(1);

            if (Math.random() >= 0.2) {
                user.sendMessage(Text.literal("Good!"), true);
            } else {
                user.sendMessage(Text.literal("Bad!"), true);
            }

            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        }

        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }
}

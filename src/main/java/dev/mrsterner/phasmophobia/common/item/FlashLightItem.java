package dev.mrsterner.phasmophobia.common.item;

import dev.mrsterner.phasmophobia.Light;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class FlashLightItem extends Item implements Light {
    public FlashLightItem(Settings settings) {
    super(settings);
    }
    @Override
    public void inventoryTick(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (!(player.getStackInHand(Hand.MAIN_HAND) == itemStack) && !(player.getStackInHand(Hand.OFF_HAND) == itemStack))
            return;
        createLight(itemStack, world, player);
    }

    @Override
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return toggleLight(playerIn, handIn);
    }
}

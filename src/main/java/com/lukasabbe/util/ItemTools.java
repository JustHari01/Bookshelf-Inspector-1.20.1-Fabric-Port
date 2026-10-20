package com.lukasabbe.util;

import com.google.common.collect.Iterables;
import net.minecraft.world.item.ItemStack;
//? if >= 1.20.5 {
/*import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import java.util.Optional;
*///?} else {
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import java.util.List;
import java.util.Map;
//?}

public class ItemTools {
    //? if >= 1.20.5 {
    /*public static ItemEnchantments getItemEnchantments(ItemStack itemStack) {
        return Optional
                .ofNullable(itemStack.getComponents().get(DataComponents.STORED_ENCHANTMENTS))
                .orElse(itemStack.getComponents().get(DataComponents.ENCHANTMENTS));
    }

    public static PotionContents getPotionContents(ItemStack itemStack) {
        return itemStack.getComponents().get(DataComponents.POTION_CONTENTS);
    }

    public static boolean isNormalStack(ItemStack itemStack) {
        //?if >=1.21.3 {
        /^if (!itemStack.getHoverName().equals(itemStack.getItemName())) return false;
        ^///?}

        ItemEnchantments itemEnchantments = getItemEnchantments(itemStack);
        if (itemEnchantments != null && !itemEnchantments.isEmpty()) return false;

        PotionContents itemPotionContents = getPotionContents(itemStack);
        return itemPotionContents == null || Iterables.size(itemPotionContents.getAllEffects()) == 0;
    }
    *///?} else {
    public static Map<Enchantment, Integer> getItemEnchantments(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantments(itemStack);
    }

    public static List<MobEffectInstance> getPotionContents(ItemStack itemStack) {
        return PotionUtils.getMobEffects(itemStack);
    }

    public static boolean isNormalStack(ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) return false;

        Map<Enchantment, Integer> enchantments = getItemEnchantments(itemStack);
        if (enchantments != null && !enchantments.isEmpty()) return false;

        List<MobEffectInstance> effects = getPotionContents(itemStack);
        return effects == null || effects.isEmpty();
    }
    //?}
}

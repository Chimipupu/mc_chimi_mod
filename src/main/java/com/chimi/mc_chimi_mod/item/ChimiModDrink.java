package com.chimi.mc_chimi_mod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ChimiModDrink extends Item {

    public ChimiModDrink(Properties pProperties) {
        super(pProperties);
    }

    // アイテム使用時処理
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }
    // アイテム使用後処理
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        // エフェクト追加
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600 * 120));
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 600 * 120));

        // アイテムの消費
        if (pLivingEntity instanceof Player player
            && !player.isCreative()) {
            // クリエイティブタブでないときだけアイテム消費
            pStack.shrink(1);
        }
        return pStack;
    }

    // アイテムの使用にかかる時間
    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 32; // 32 = 牛乳の消費時間
    }

    // アニメーション
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}

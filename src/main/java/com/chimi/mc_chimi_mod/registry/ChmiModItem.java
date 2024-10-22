package com.chimi.mc_chimi_mod.registry;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.item.ChimiModDrink;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// アイテムの追加
public class ChmiModItem {
    // レジストリ作成
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChimiMod.MOD_ID);

    // 追加アイテムの作成＆レジストリ登録
    // 素材系
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () ->new Item(new Item.Properties()));

    // 食べ物系
    public static final RegistryObject<Item> HALTH_BOOST_POTATO = ITEMS.register("halth_boost_potato",
            () ->new Item(new Item.Properties().food(new FoodProperties.Builder()
                    // 満腹度
                    .nutrition(6) // 満腹度6 空腹ゲージ3つ分
                    // 隠し満腹度
                    .saturationModifier(0.8f) // 隠し満腹度 空腹ゲージ3つ分
                    // 食べる速度
                    .fast() // 早め（乾燥昆布と同じ速度）
                    // 満腹でも食べれるか
                    .alwaysEdible()
                    // ステータス付与(体力増強(HEALTH_BOOST),30秒間(=600/20),100%確率で付与(1.0f))
                    .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 1.0f)
                    .build())));

    public static final RegistryObject<Item> DAMAGE_BOOST_POTATO = ITEMS.register("damage_boost_potato",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)   // 栄養
                    .saturationModifier(0.8f)   // 隠し満腹度
                    .fast() // 食べるスピードを早くする
                    .alwaysEdible() // 満腹でも食べられる
                    // ステータス付与(ダメージ増強(HEALTH_BOOST),30秒間(=600/20),100%確率で付与(1.0f))
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600), 1.0f)
                    .build())));

    public static final RegistryObject<Item> ALL_BOOST_POTATO = ITEMS.register("all_boost_potato",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)   // 栄養
                    .saturationModifier(0.8f)   // 隠し満腹度
                    .fast() // 食べるスピードを早くする
                    .alwaysEdible() // 満腹でも食べられる
                    // ステータス付与(体力増強(HEALTH_BOOST),1時間(= 600 * 120 / 20),100%確率で付与(1.0f))
                    .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600 * 120), 1.0f)
                    // ステータス付与(ダメージ増強(HEALTH_BOOST),1時間(= 600 * 120 / 20),100%確率で付与(1.0f))
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.HEAL, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.LUCK, 600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.ABSORPTION, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.BAD_OMEN, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.DARKNESS, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.HARM, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.POISON, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.WEAVING, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.WIND_CHARGED, 600 * 120), 1.0f)
//                    .effect(new MobEffectInstance(MobEffects.WITHER, 600 * 120), 1.0f)
                    .build())));

    // 飲み物
    public static final RegistryObject<Item> PORTION = ITEMS.register("portion",
            () ->new ChimiModDrink(new Item.Properties()));

    // レジスタをイベントバスに登録
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

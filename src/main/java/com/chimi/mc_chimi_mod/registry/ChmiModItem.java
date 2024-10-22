package com.chimi.mc_chimi_mod.registry;

import com.chimi.mc_chimi_mod.ChimiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// アイテムの追加
public class ChmiModItem {
    // レジストリ作成
    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChimiMod.MOD_ID);

    // アイテム作成＆レジストリ登録
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () ->new Item(new Item.Properties()));

    // レジスタをイベントバスに登録
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

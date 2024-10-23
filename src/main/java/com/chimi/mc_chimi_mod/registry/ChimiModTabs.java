package com.chimi.mc_chimi_mod.registry;

import com.chimi.mc_chimi_mod.ChimiMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ChimiModTabs {
    // クリエイティブタブを追加
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChimiMod.MOD_ID);

    // クリエイティブタブにオブジェクト追加
    public static final RegistryObject<CreativeModeTab> CHIMIMOD_TAB =
            TABS.register("chimi_mod_tab", ()->CreativeModeTab.builder()
                    // タブ名
                    .title(Component.translatable("creativetabs.chimi_mod_tab"))
                    // アイコン
                    .icon(ChmiModItem.SALT.get()::getDefaultInstance)
                    // アイテム追加
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ChmiModItem.RAW_ORIHALCON.get());
                        pOutput.accept(ChmiModItem.ORIHALCON_INGOT.get());
                        pOutput.accept(ChimiModBlock.ORIHALCON_BLOCK.get());
                        pOutput.accept(ChmiModItem.SALT.get());
                        pOutput.accept(ChimiModBlock.SALT_BLOCK.get());
                        pOutput.accept(ChmiModItem.BUTTER.get());
                        pOutput.accept(ChmiModItem.HALTH_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.DAMAGE_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.ALL_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.PORTION.get());
                    })
                    // 検索バー
                    .withSearchBar()
                    // 背景画像
//                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(
//                            ChimiMod.MOD_ID, "textures/gui/chimimodtab_bg.png"))

                    // ラベルの色
                    .withLabelColor(Color.RED.getRGB())     // 赤

                    // カーソル選択時のハイライト
                    .withSlotColor(new Color(255,50,255,55).getRGB())    // 半透明な紫
                    .build());

    // 拡張タブ
    public static final RegistryObject<CreativeModeTab> CHIMIMOD_TAB_EXTRA =
            TABS.register("chimi_mod_tab_extra", ()->CreativeModeTab.builder()
                    // タブ名
                    .title(Component.translatable("creativetabs.chimi_mod_tab_extra"))
                    // アイコン
                    .icon(ChmiModItem.BUTTER.get()::getDefaultInstance)
                    // アイテム追加
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ChmiModItem.RAW_ORIHALCON.get());
                        pOutput.accept(ChmiModItem.ORIHALCON_INGOT.get());
                        pOutput.accept(ChimiModBlock.ORIHALCON_BLOCK.get());
                        pOutput.accept(ChmiModItem.SALT.get());
                        pOutput.accept(ChimiModBlock.SALT_BLOCK.get());
                        pOutput.accept(ChmiModItem.BUTTER.get());
                        pOutput.accept(ChmiModItem.HALTH_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.DAMAGE_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.ALL_BOOST_POTATO.get());
                        pOutput.accept(ChmiModItem.PORTION.get());
                    })
                    // 検索バー
                    .withSearchBar()
                    // ラベルの色
                    .withLabelColor(Color.MAGENTA.getRGB()) // 紫

                    // カーソル選択時のハイライト
                    .withSlotColor(new Color(255,50,255,55).getRGB())    // 半透明な紫
                    .build());

    public static final void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}

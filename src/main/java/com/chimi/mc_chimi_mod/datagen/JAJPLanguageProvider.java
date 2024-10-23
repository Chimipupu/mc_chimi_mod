package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import com.chimi.mc_chimi_mod.registry.ChmiModItem;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, ChimiMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        // 素材
        addItem(ChmiModItem.RAW_ORIHALCON, "オリハルコンの欠片");
        addItem(ChmiModItem.ORIHALCON_INGOT, "オリハルコンのインゴット");
        addItem(ChmiModItem.SALT, "塩");
        addItem(ChmiModItem.BUTTER, "バター");

        // 食べ物
        addItem(ChmiModItem.HALTH_BOOST_POTATO, "体力増強ポテト");
        addItem(ChmiModItem.DAMAGE_BOOST_POTATO, "ダメージ増強ポテト");
        addItem(ChmiModItem.ALL_BOOST_POTATO, "神話のポテト");

        // 飲み物
        addItem(ChmiModItem.PORTION, "神話のポーション");

        // ブロック
        addBlock(ChimiModBlock.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(ChimiModBlock.RAW_ORIHALCON_BLOCK, "オリハルコンの欠片ブロック");
        addBlock(ChimiModBlock.SALT_BLOCK, "塩ブロック");

        // クリエイティブタブ
        add("creativetabs.chimi_mod_tab", "ちみMOD");
        add("creativetabs.chimi_mod_tab_extra", "ちみMOD Extra");
    }
}

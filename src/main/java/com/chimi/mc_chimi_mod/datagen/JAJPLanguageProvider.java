package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import com.chimi.mc_chimi_mod.registry.ChimiModItem;
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
        addItem(ChimiModItem.RAW_ORIHALCON, "オリハルコンの欠片");
        addItem(ChimiModItem.ORIHALCON_INGOT, "オリハルコンのインゴット");
        addItem(ChimiModItem.SALT, "塩");
        addItem(ChimiModItem.BUTTER, "バター");

        // 食べ物
        addItem(ChimiModItem.HALTH_BOOST_POTATO, "体力増強ポテト");
        addItem(ChimiModItem.DAMAGE_BOOST_POTATO, "ダメージ増強ポテト");
        addItem(ChimiModItem.ALL_BOOST_POTATO, "神話のポテト");

        // 飲み物
        addItem(ChimiModItem.PORTION, "神話のポーション");

        // ブロック
        addBlock(ChimiModBlock.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(ChimiModBlock.RAW_ORIHALCON_BLOCK, "オリハルコンの欠片ブロック");
        addBlock(ChimiModBlock.SALT_BLOCK, "塩ブロック");

        // クリエイティブタブ
        add("creativetabs.chimi_mod_tab", "ちみMOD");
        add("creativetabs.chimi_mod_tab_extra", "ちみMOD Extra");
    }
}

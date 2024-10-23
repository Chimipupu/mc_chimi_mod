package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import com.chimi.mc_chimi_mod.registry.ChmiModItem;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {

    public ENUSLanguageProvider(PackOutput output) {
        super(output, ChimiMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        // 素材
        addItem(ChmiModItem.RAW_ORIHALCON, "raw orihalcon");
        addItem(ChmiModItem.ORIHALCON_INGOT, "orihalcon ingot");
        addItem(ChmiModItem.SALT, "Salt");
        addItem(ChmiModItem.BUTTER, "Butter");

        // 食べ物
        addItem(ChmiModItem.HALTH_BOOST_POTATO, "Health Boost Potato");
        addItem(ChmiModItem.DAMAGE_BOOST_POTATO, "Damage Boost Potato");
        addItem(ChmiModItem.ALL_BOOST_POTATO, "God Potato");

        // 飲み物
        addItem(ChmiModItem.PORTION, "God Portion");

        // ブロック
        addBlock(ChimiModBlock.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(ChimiModBlock.RAW_ORIHALCON_BLOCK, "Raw Orihalcon Block");
        addBlock(ChimiModBlock.SALT_BLOCK, "Salt Block");

        // クリエイティブタブ
        add("creativetabs.chimi_mod_tab", "Chimi MOD");
        add("creativetabs.chimi_mod_tab_extra", "Chimi MOD Extra");
    }
}

package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChimiModItem;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChimiModItemModelProvider extends ItemModelProvider {

    public ChimiModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChimiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ChimiModItem.RAW_ORIHALCON.get());
        basicItem(ChimiModItem.ORIHALCON_INGOT.get());
        basicItem(ChimiModItem.SALT.get());
        basicItem(ChimiModItem.BUTTER.get());
        basicItem(ChimiModItem.HALTH_BOOST_POTATO.get());
        basicItem(ChimiModItem.DAMAGE_BOOST_POTATO.get());
        basicItem(ChimiModItem.ALL_BOOST_POTATO.get());
        basicItem(ChimiModItem.PORTION.get());
    }
}
package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChmiModItem;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChimiModItemModelProvider extends ItemModelProvider {

    public ChimiModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChimiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ChmiModItem.RAW_ORIHALCON.get());
        basicItem(ChmiModItem.ORIHALCON_INGOT.get());
        basicItem(ChmiModItem.SALT.get());
        basicItem(ChmiModItem.BUTTER.get());
        basicItem(ChmiModItem.HALTH_BOOST_POTATO.get());
        basicItem(ChmiModItem.DAMAGE_BOOST_POTATO.get());
        basicItem(ChmiModItem.ALL_BOOST_POTATO.get());
        basicItem(ChmiModItem.PORTION.get());
    }
}
package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ChimiModBlockStateProvider extends BlockStateProvider {
    public ChimiModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChimiMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ChimiModBlock.SALT_BLOCK);
        simpleBlockWithItem(ChimiModBlock.ORIHALCON_BLOCK);
        simpleBlockWithItem(ChimiModBlock.RAW_ORIHALCON_BLOCK);
    }
    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}

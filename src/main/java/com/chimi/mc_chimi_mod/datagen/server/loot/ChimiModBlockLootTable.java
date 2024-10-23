package com.chimi.mc_chimi_mod.datagen.server.loot;

import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import com.chimi.mc_chimi_mod.registry.ChimiModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChimiModBlockLootTable extends BlockLootSubProvider {
    protected ChimiModBlockLootTable(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropOther(ChimiModBlock.ORIHALCON_BLOCK.get(),
                ChimiModItem.RAW_ORIHALCON.get());
        this.dropOther(ChimiModBlock.RAW_ORIHALCON_BLOCK.get(),
                ChimiModItem.RAW_ORIHALCON.get());
        this.dropOther(ChimiModBlock.SALT_BLOCK.get(),
                ChimiModItem.SALT.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChimiModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

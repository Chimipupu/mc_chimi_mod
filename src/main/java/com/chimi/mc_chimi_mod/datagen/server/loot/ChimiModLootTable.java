package com.chimi.mc_chimi_mod.datagen.server.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChimiModLootTable {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> lookUpProvider) {
        return new LootTableProvider(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                ChimiModBlockLootTable::new,
                                LootContextParamSets.BLOCK
                        )
                ),
                lookUpProvider
        );
    }
}
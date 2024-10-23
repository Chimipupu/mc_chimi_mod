package com.chimi.mc_chimi_mod.datagen;

import com.chimi.mc_chimi_mod.ChimiMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ChimiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChimiModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(),
                new ChimiModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(),
                new ChimiModBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(),
                new ENUSLanguageProvider(packOutput));

        generator.addProvider(event.includeClient(),
                new JAJPLanguageProvider(packOutput));

        generator.addProvider(event.includeServer(),
                new ChimiModRecipeProvider(packOutput, lookUpProvider));
    }
}

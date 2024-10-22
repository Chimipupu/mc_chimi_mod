package com.chimi.mc_chimi_mod;

import com.chimi.mc_chimi_mod.registry.ChimiModBlock;
import com.chimi.mc_chimi_mod.registry.ChimiModTabs;
import com.chimi.mc_chimi_mod.registry.ChmiModItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChimiMod.MOD_ID)
public class ChimiMod {
    public static final String MOD_ID = "mc_chimi_mod";

    public ChimiMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // 追加アイテムのレジストリをイベントバスに登録
        ChmiModItem.register(modEventBus);
        ChimiModTabs.register(modEventBus);
        ChimiModBlock.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // TODO
    }

    // クリエイティブへのアイテム追加
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // 材料タブへ追加
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ChmiModItem.SALT);
            event.accept(ChmiModItem.BUTTER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // TODO
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // TODO
        }
    }
}

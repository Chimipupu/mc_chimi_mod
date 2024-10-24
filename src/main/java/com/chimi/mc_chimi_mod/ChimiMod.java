package com.chimi.mc_chimi_mod;

import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ChimiMod.MODID)
public class ChimiMod
{
    public static final String MODID = "mc_chimi_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // レジスタ作成
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // [アイテム作成]
    // ブロック
    public static final DeferredBlock<Block> ORIHALCON_BLOCK =
            BLOCKS.registerSimpleBlock("orihalcon_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredItem<BlockItem> ORIHALCON_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("orihalcon_block", ORIHALCON_BLOCK);

    public static final DeferredBlock<Block> RAW_ORIHALCON_BLOCK =
            BLOCKS.registerSimpleBlock("raw_orihalcon_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredItem<BlockItem> RAW_ORIHALCON_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("raw_orihalcon_block", RAW_ORIHALCON_BLOCK);

    // 素材
    public static final DeferredItem<Item> RAW_ORIHALCON =
            ITEMS.registerSimpleItem("raw_orihalcon", new Item.Properties());

    // 食べ物
    public static final DeferredItem<Item> ORIHALCON_INGOT =
            ITEMS.registerSimpleItem("orihalcon_ingot", new Item.Properties());

    public static final DeferredItem<Item> HALTH_BOOST_POTATO =
            ITEMS.registerSimpleItem("halth_boost_potato", new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEdible() // いつでも食べれる
                            .fast() // 早く食べる
                            .nutrition(6) // 満腹度
                            .saturationModifier(2f) // 隠し満腹度
                            // 効果、効果時間(1時間= 600 * 120 / 20)、確率(1.0f=100%)
                            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST,600 * 120), 1.0f)
                            .build()));

    public static final DeferredItem<Item> DAMAGE_BOOST_POTATO =
            ITEMS.registerSimpleItem("damage_boost_potato", new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEdible() // いつでも食べれる
                            .fast() // 早く食べる
                            .nutrition(6) // 満腹度
                            .saturationModifier(2f) // 隠し満腹度
                            // 効果、効果時間(1時間= 600 * 120 / 20)、確率(1.0f=100%)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,600 * 120), 1.0f)
                            .build()));

    public static final DeferredItem<Item> ALL_BOOST_POTATO =
            ITEMS.registerSimpleItem("all_boost_potato", new Item.Properties()
                    .food(new FoodProperties.Builder()
                    .alwaysEdible() // いつでも食べれる
                    .fast() // 早く食べる
                    .nutrition(6) // 満腹度
                    .saturationModifier(2f) // 隠し満腹度
                    // 効果、効果時間(1時間= 600 * 120 / 20)、確率(1.0f=100%)
                    .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.CONDUIT_POWER,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.HEAL,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.INVISIBILITY,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.LUCK,600 * 120), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.WATER_BREATHING,600 * 120), 1.0f)
                    .build()));

    // クリエイティブタブ作成
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            // レジスタ
            CREATIVE_MODE_TABS.register("mc_chimi_mod", () -> CreativeModeTab.builder()
            // タイトル
//            .title(Component.translatable("CHIMI MOD TAB"))
            .title(Component.translatable("ちみMOD"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            // クリエイティブタブのアイコン
            .icon(() -> RAW_ORIHALCON.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                 // クリエイティブタブにアイテム追加
                output.accept(RAW_ORIHALCON.get());
                output.accept(ORIHALCON_INGOT.get());
                output.accept(RAW_ORIHALCON_BLOCK_ITEM.get());
                output.accept(ORIHALCON_BLOCK_ITEM.get());
                output.accept(HALTH_BOOST_POTATO.get());
                output.accept(DAMAGE_BOOST_POTATO.get());
                output.accept(ALL_BOOST_POTATO.get());
            }).build());

    public ChimiMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        // アイテムをレジスタに登録
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(ORIHALCON_BLOCK_ITEM);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // TODO
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

package com.chimi.mc_chimi_mod.registry;

import com.chimi.mc_chimi_mod.ChimiMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChimiModBlock {
    // レジストリ作成
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChimiMod.MOD_ID);

    // ブロック作成
    public static final RegistryObject<Block> SALT_BLOCK = registerBlockWithItem("salt_block",
            // ダイアブロックで音はアメジスト
            ()->new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    // ブロックのアイテム化＆レジストリ登録
    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> supplier) {
        // ブロックをレジストリに登録
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        // ブロックをアイテムとしてレジストリに登録
        ChmiModItem.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // イベントバスに登録
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

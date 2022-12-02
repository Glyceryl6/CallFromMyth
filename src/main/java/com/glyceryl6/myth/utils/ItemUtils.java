package com.glyceryl6.myth.utils;

import com.glyceryl6.myth.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class ItemUtils {

    public static RegistryObject<Item> normal(String name) {
        return ItemRegistry.ITEMS.register(name, () -> new Item(new Item.Properties().tab(MYTH_TAB)));
    }

    public static RegistryObject<Item> alias(String name, RegistryObject<Block> block) {
        return ItemRegistry.ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties().tab(MYTH_TAB)));
    }

    public static final CreativeModeTab MYTH_TAB = new CreativeModeTab("myth_tab") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BEECH_NUT.get());
        }
    };

}
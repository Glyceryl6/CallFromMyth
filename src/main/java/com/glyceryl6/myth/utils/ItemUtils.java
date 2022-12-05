package com.glyceryl6.myth.utils;

import com.glyceryl6.myth.registry.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ItemUtils {

    public static RegistryObject<Item> normal(String name) {
        return ItemRegistry.ITEMS.register(name, () -> new Item(defaultBuilder()));
    }

    public static RegistryObject<Item> alias(String name, RegistryObject<Block> block) {
        return ItemRegistry.ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), defaultBuilder()));
    }

    public static RegistryObject<Item> spawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return ItemRegistry.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor, defaultBuilder()));
    }

    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(MYTH_TAB);
    }

    public static final CreativeModeTab MYTH_TAB = new CreativeModeTab("myth_tab") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BEECH_NUT.get());
        }
    };

}
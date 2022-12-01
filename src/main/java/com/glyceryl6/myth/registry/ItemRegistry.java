package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CallFromMyth.MOD_ID);

    public static final RegistryObject<Item> DATURA = normal("datura");
    public static final RegistryObject<Item> HENBANE = normal("henbane");
    public static final RegistryObject<Item> BEECH_NUT = normal("beech_nut");
    public static final RegistryObject<Item> BELLADONNA = normal("belladonna");
    public static final RegistryObject<Item> FINE_SILVER = normal("fine_silver");
    public static final RegistryObject<Item> CHILI_PEPPER = normal("chili_pepper");

    public static final RegistryObject<Item> DATURA_SEEDS = seed("datura_seeds", BlockRegistry.DATURA);
    public static final RegistryObject<Item> HENBANE_SEEDS = seed("henbane_seeds", BlockRegistry.HENBANE);
    public static final RegistryObject<Item> BELLADONNA_SEEDS = seed("belladonna_seeds", BlockRegistry.BELLADONNA);
    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = seed("chili_pepper_seeds", BlockRegistry.CHILI_PEPPER);

    public static final RegistryObject<Item> DISTILLER = block("distiller", BlockRegistry.DISTILLER);
    public static final RegistryObject<Item> BEECH_LOG = block("beech_log", BlockRegistry.BEECH_LOG);
    public static final RegistryObject<Item> BEECH_LEAVE = block("beech_leaves", BlockRegistry.BEECH_LEAVE);
    public static final RegistryObject<Item> BEECH_SAPLING = block("beech_sapling", BlockRegistry.BEECH_SAPLING);
    public static final RegistryObject<Item> MALACHITE_ORE = block("malachite_ore", BlockRegistry.MALACHITE_ORE);
    public static final RegistryObject<Item> FINE_SILVER_ORE = block("fine_silver_ore", BlockRegistry.FINE_SILVER_ORE);
    public static final RegistryObject<Item> STONE_CRUCIBLE = block("stone_crucible", BlockRegistry.STONE_CRUCIBLE);
    public static final RegistryObject<Item> WIZARD_CRUCIBLE = block("wizard_crucible", BlockRegistry.WIZARD_CRUCIBLE);
    public static final RegistryObject<Item> FINE_SILVER_BLOCK = block("fine_silver_block", BlockRegistry.FINE_SILVER_BLOCK);

    private static RegistryObject<Item> normal(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(MYTH_TAB)));
    }

    private static RegistryObject<Item> seed(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties().tab(MYTH_TAB)));
    }

    private static RegistryObject<Item> block(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(MYTH_TAB)));
    }

    public static final CreativeModeTab MYTH_TAB = new CreativeModeTab("myth_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WIZARD_CRUCIBLE.get());
        }
    };

}
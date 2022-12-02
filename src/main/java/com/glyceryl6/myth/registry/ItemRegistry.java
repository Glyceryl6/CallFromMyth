package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.glyceryl6.myth.utils.ItemUtils.alias;
import static com.glyceryl6.myth.utils.ItemUtils.normal;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CallFromMyth.MOD_ID);

    public static final RegistryObject<Item> DATURA = normal("datura");
    public static final RegistryObject<Item> HENBANE = normal("henbane");
    public static final RegistryObject<Item> BEECH_NUT = normal("beech_nut");
    public static final RegistryObject<Item> BELLADONNA = normal("belladonna");
    public static final RegistryObject<Item> FINE_SILVER = normal("fine_silver");
    public static final RegistryObject<Item> CHILI_PEPPER = normal("chili_pepper");

    public static final RegistryObject<Item> DATURA_SEEDS = alias("datura_seeds", BlockRegistry.DATURA);
    public static final RegistryObject<Item> HENBANE_SEEDS = alias("henbane_seeds", BlockRegistry.HENBANE);
    public static final RegistryObject<Item> BELLADONNA_SEEDS = alias("belladonna_seeds", BlockRegistry.BELLADONNA);
    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = alias("chili_pepper_seeds", BlockRegistry.CHILI_PEPPER);

}
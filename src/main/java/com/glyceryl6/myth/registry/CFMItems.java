package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.items.GraftRodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.glyceryl6.myth.utils.CFMItemUtils.*;

public class CFMItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CallFromMyth.MOD_ID);

    public static final RegistryObject<Item> DATURA = normal("datura");
    public static final RegistryObject<Item> HENBANE = normal("henbane");
    public static final RegistryObject<Item> BEECH_NUT = normal("beech_nut");
    public static final RegistryObject<Item> BELLADONNA = normal("belladonna");
    public static final RegistryObject<Item> FINE_SILVER = normal("fine_silver");
    public static final RegistryObject<Item> CHILI_PEPPER = normal("chili_pepper");

    public static final RegistryObject<Item> DATURA_SEEDS = alias("datura_seeds", CFMBlocks.DATURA);
    public static final RegistryObject<Item> HENBANE_SEEDS = alias("henbane_seeds", CFMBlocks.HENBANE);
    public static final RegistryObject<Item> BELLADONNA_SEEDS = alias("belladonna_seeds", CFMBlocks.BELLADONNA);
    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = alias("chili_pepper_seeds", CFMBlocks.CHILI_PEPPER);

    public static final RegistryObject<Item> HUNTER_SPAWN_EGG = spawnEgg("hunter", CFMEntity.HUNTER, 0x3b3a3a, 0xe7ac9a);

    public static final RegistryObject<Item> GRAFT_ROD = ITEMS.register("graft_rod", () -> new GraftRodItem(new Item.Properties()));

}
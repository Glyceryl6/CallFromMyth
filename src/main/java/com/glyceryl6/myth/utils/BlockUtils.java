package com.glyceryl6.myth.utils;

import com.glyceryl6.myth.registry.BlockRegistry;
import com.glyceryl6.myth.registry.ItemRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class BlockUtils {

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> register = BlockRegistry.BLOCKS.register(name, block);
        Item.Properties properties = new Item.Properties().tab(ItemUtils.MYTH_TAB);
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(register.get(), properties));
        return register;
    }

    public static RegistryObject<Block> normal(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new Block(properties));
    }

    public static RegistryObject<Block> ore(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new OreBlock(properties));
    }

    public static RegistryObject<Block> flowerPot(String name, RegistryObject<Block> block) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion();
        return registerBlock(name, () -> new FlowerPotBlock(block.get(), properties));
    }

    public static RegistryObject<Block> pressurePlate(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties));
    }

    public static RegistryObject<Block> fenceGate(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceGateBlock(properties));
    }

    public static RegistryObject<Block> trapdoor(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new TrapDoorBlock(properties));
    }

    public static RegistryObject<Block> button(String name, boolean sensitive, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> sensitive ? new WoodButtonBlock(properties) : new StoneButtonBlock(properties));
    }

    public static <T extends Block> RegistryObject<Block> stair(String name, Supplier<T> block, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new StairBlock(() -> block.get().defaultBlockState(), properties));
    }

    public static RegistryObject<Block> fence(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceBlock(properties));
    }

    public static RegistryObject<Block> door(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new DoorBlock(properties));
    }

    public static RegistryObject<Block> slab(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new SlabBlock(properties));
    }

    public static RegistryObject<Block> wall(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new WallBlock(properties));
    }
    
}
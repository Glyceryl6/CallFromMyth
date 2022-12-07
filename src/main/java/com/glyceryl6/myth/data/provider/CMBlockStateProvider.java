package com.glyceryl6.myth.data.provider;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CMBlockStateProvider extends BlockStateProvider {

    public CMBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CallFromMyth.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(BlockRegistry.IRON_BIRCH_PLANKS.get());
        this.simpleBlock(BlockRegistry.IRON_BIRCH_LEAVES.get());
        this.simpleBlock(BlockRegistry.IRON_BIRCH_SAPLING.get(),
                this.models().cross(BlockRegistry.IRON_BIRCH_SAPLING.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_SAPLING.get())));
        this.pressurePlateBlock((PressurePlateBlock) BlockRegistry.IRON_BIRCH_PRESSURE_PLATE.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) BlockRegistry.IRON_BIRCH_FENCE_GATE.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) BlockRegistry.IRON_BIRCH_TRAPDOOR.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()), true);
        this.buttonBlock((ButtonBlock) BlockRegistry.IRON_BIRCH_BUTTON.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.stairsBlock((StairBlock) BlockRegistry.IRON_BIRCH_STAIR.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.fenceBlock((FenceBlock) BlockRegistry.IRON_BIRCH_FENCE.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.wallBlock((WallBlock) BlockRegistry.IRON_BIRCH_WALL.get(), this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.doorBlock((DoorBlock) BlockRegistry.IRON_BIRCH_DOOR.get(),
                CallFromMyth.prefix("block/iron_birch_door_bottom"),
                CallFromMyth.prefix("block/iron_birch_door_top"));
        this.slabBlock((SlabBlock) BlockRegistry.IRON_BIRCH_SLAB.get(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_PLANKS.get(), this.cubeAll(BlockRegistry.IRON_BIRCH_PLANKS.get()));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_LEAVES.get(), this.cubeAll(BlockRegistry.IRON_BIRCH_LEAVES.get()));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_SAPLING.get(),
                this.models().cross(BlockRegistry.IRON_BIRCH_SAPLING.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_SAPLING.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_PRESSURE_PLATE.get(), this.models().pressurePlate(
                BlockRegistry.IRON_BIRCH_PRESSURE_PLATE.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_FENCE_GATE.get(), this.models().fenceGate(
                BlockRegistry.IRON_BIRCH_FENCE_GATE.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_TRAPDOOR.get(), this.models().trapdoorBottom(
                BlockRegistry.IRON_BIRCH_TRAPDOOR.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_BUTTON.get(), this.models().buttonInventory(
                BlockRegistry.IRON_BIRCH_BUTTON.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_STAIR.get(), this.models().stairs(
                BlockRegistry.IRON_BIRCH_STAIR.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_FENCE.get(), this.models().fenceInventory(
                BlockRegistry.IRON_BIRCH_FENCE.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_WALL.get(), this.models().wallInventory(
                BlockRegistry.IRON_BIRCH_WALL.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_DOOR.get(), this.models().doorBottomLeft(
                BlockRegistry.IRON_BIRCH_DOOR.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(BlockRegistry.IRON_BIRCH_SLAB.get(), this.models().slab(
                BlockRegistry.IRON_BIRCH_SLAB.get().getRegistryName().getPath(),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(BlockRegistry.IRON_BIRCH_PLANKS.get())));
    }

}
package com.glyceryl6.myth.data.provider;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.registry.CFMBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CFMBlockStateProvider extends BlockStateProvider {

    public CFMBlockStateProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, CallFromMyth.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(CFMBlocks.IRON_BIRCH_PLANKS.get());
        this.simpleBlock(CFMBlocks.IRON_BIRCH_LEAVES.get());
        this.simpleBlock(CFMBlocks.IRON_BIRCH_SAPLING.get(),
                this.models().cross(CFMBlocks.IRON_BIRCH_SAPLING.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_SAPLING.get())));
        this.pressurePlateBlock((PressurePlateBlock) CFMBlocks.IRON_BIRCH_PRESSURE_PLATE.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) CFMBlocks.IRON_BIRCH_FENCE_GATE.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) CFMBlocks.IRON_BIRCH_TRAPDOOR.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()), true);
        this.buttonBlock((ButtonBlock) CFMBlocks.IRON_BIRCH_BUTTON.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.stairsBlock((StairBlock) CFMBlocks.IRON_BIRCH_STAIR.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.fenceBlock((FenceBlock) CFMBlocks.IRON_BIRCH_FENCE.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.wallBlock((WallBlock) CFMBlocks.IRON_BIRCH_WALL.get(), this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.doorBlock((DoorBlock) CFMBlocks.IRON_BIRCH_DOOR.get(),
                CallFromMyth.prefix("block/iron_birch_door_bottom"),
                CallFromMyth.prefix("block/iron_birch_door_top"));
        this.slabBlock((SlabBlock) CFMBlocks.IRON_BIRCH_SLAB.get(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_PLANKS.get(), this.cubeAll(CFMBlocks.IRON_BIRCH_PLANKS.get()));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_LEAVES.get(), this.cubeAll(CFMBlocks.IRON_BIRCH_LEAVES.get()));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_PRESSURE_PLATE.get(), this.models().pressurePlate(
                CFMBlocks.IRON_BIRCH_PRESSURE_PLATE.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_FENCE_GATE.get(), this.models().fenceGate(
                CFMBlocks.IRON_BIRCH_FENCE_GATE.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_TRAPDOOR.get(), this.models().trapdoorBottom(
                CFMBlocks.IRON_BIRCH_TRAPDOOR.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_BUTTON.get(), this.models().buttonInventory(
                CFMBlocks.IRON_BIRCH_BUTTON.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_STAIR.get(), this.models().stairs(
                CFMBlocks.IRON_BIRCH_STAIR.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_FENCE.get(), this.models().fenceInventory(
                CFMBlocks.IRON_BIRCH_FENCE.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_WALL.get(), this.models().wallInventory(
                CFMBlocks.IRON_BIRCH_WALL.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
        this.simpleBlockItem(CFMBlocks.IRON_BIRCH_SLAB.get(), this.models().slab(
                CFMBlocks.IRON_BIRCH_SLAB.get().getRegistryName().getPath(),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get()),
                this.blockTexture(CFMBlocks.IRON_BIRCH_PLANKS.get())));
    }

}
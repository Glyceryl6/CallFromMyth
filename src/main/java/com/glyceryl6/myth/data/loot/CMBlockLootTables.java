package com.glyceryl6.myth.data.loot;

import com.glyceryl6.myth.registry.BlockRegistry;
import net.minecraft.data.loot.BlockLoot;

public class CMBlockLootTables extends BlockLoot {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] {0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        this.dropSelf(BlockRegistry.IRON_BIRCH_LOG.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_PLANKS.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_SAPLING.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_PRESSURE_PLATE.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_FENCE_GATE.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_TRAPDOOR.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_BUTTON.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_STAIR.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_FENCE.get());
        this.dropSelf(BlockRegistry.IRON_BIRCH_WALL.get());
        this.add(BlockRegistry.IRON_BIRCH_LEAVES.get(), (block) -> createLeavesDrops(block,
                BlockRegistry.POTTED_IRON_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.POTTED_IRON_BIRCH_SAPLING.get(), BlockLoot::createPotFlowerItemTable);
        this.add(BlockRegistry.IRON_BIRCH_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(BlockRegistry.IRON_BIRCH_DOOR.get(), BlockLoot::createDoorTable);
    }

}
package com.glyceryl6.myth.data.loot;

import com.glyceryl6.myth.registry.CFMBlocks;
import net.minecraft.data.loot.BlockLoot;

public class CMBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(CFMBlocks.IRON_BIRCH_LOG.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_PLANKS.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_SAPLING.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_PRESSURE_PLATE.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_FENCE_GATE.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_TRAPDOOR.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_BUTTON.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_STAIR.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_FENCE.get());
        this.dropSelf(CFMBlocks.IRON_BIRCH_WALL.get());
        this.dropPottedContents(CFMBlocks.POTTED_IRON_BIRCH_SAPLING.get());
        this.add(CFMBlocks.IRON_BIRCH_LEAVES.get(), (block) -> createLeavesDrops(block,
                CFMBlocks.IRON_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(CFMBlocks.IRON_BIRCH_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(CFMBlocks.IRON_BIRCH_DOOR.get(), BlockLoot::createDoorTable);
    }

}
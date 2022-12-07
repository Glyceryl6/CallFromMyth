package com.glyceryl6.myth.data.loot;

import com.glyceryl6.myth.registry.CFMBlocks;
import com.google.common.collect.Sets;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;
import java.util.function.BiConsumer;

@ParametersAreNonnullByDefault
public class CFMBlockLoot extends BlockLoot {

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

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        this.addTables();
        Set<ResourceLocation> set = Sets.newHashSet();
        for(Block block : getKnownBlocks()) {
            ResourceLocation resourcelocation = block.getLootTable();
            if (resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {
                LootTable.Builder lootTable$builder = this.map.remove(resourcelocation);
                if (lootTable$builder != null) {
                    biConsumer.accept(resourcelocation, lootTable$builder);
                }
            }
        }

        if (!this.map.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CFMBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
package com.glyceryl6.myth.data.provider;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.registry.CFMBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CFMBlockTagsProvider extends BlockTagsProvider {

    public CFMBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, CallFromMyth.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CFMBlocks.DISTILLER.get(), CFMBlocks.FINE_SILVER_ORE.get(),
                CFMBlocks.FINE_SILVER_BLOCK.get(), CFMBlocks.STONE_CRUCIBLE.get(), CFMBlocks.WIZARD_CRUCIBLE.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(CFMBlocks.IRON_BIRCH_LEAVES.get(), CFMBlocks.BEECH_LEAVES.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(CFMBlocks.IRON_BIRCH_PRESSURE_PLATE.get(), CFMBlocks.BEECH_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(CFMBlocks.IRON_BIRCH_TRAPDOOR.get(), CFMBlocks.BEECH_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(CFMBlocks.IRON_BIRCH_BUTTON.get(), CFMBlocks.BEECH_BUTTON.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(CFMBlocks.IRON_BIRCH_STAIR.get(), CFMBlocks.BEECH_STAIR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(CFMBlocks.IRON_BIRCH_FENCE.get(), CFMBlocks.BEECH_FENCE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(CFMBlocks.IRON_BIRCH_DOOR.get(), CFMBlocks.BEECH_DOOR.get());
        this.tag(BlockTags.WOODEN_SLABS).add(CFMBlocks.IRON_BIRCH_SLAB.get(), CFMBlocks.BEECH_SLAB.get());
        this.tag(BlockTags.FLOWER_POTS).add(CFMBlocks.POTTED_IRON_BIRCH_SAPLING.get(), CFMBlocks.POTTED_BEECH_SAPLING.get());
        this.tag(BlockTags.FENCE_GATES).add(CFMBlocks.IRON_BIRCH_FENCE_GATE.get(), CFMBlocks.BEECH_FENCE_GATE.get());
        this.tag(BlockTags.SAPLINGS).add(CFMBlocks.IRON_BIRCH_SAPLING.get(), CFMBlocks.BEECH_SAPLING.get());
        this.tag(BlockTags.PLANKS).add(CFMBlocks.IRON_BIRCH_PLANKS.get(), CFMBlocks.BEECH_PLANKS.get());
        this.tag(BlockTags.LEAVES).add(CFMBlocks.IRON_BIRCH_LEAVES.get(), CFMBlocks.BEECH_LEAVES.get());
        this.tag(BlockTags.WALLS).add(CFMBlocks.IRON_BIRCH_WALL.get(), CFMBlocks.BEECH_WALL.get());
        this.tag(BlockTags.LOGS).add(CFMBlocks.IRON_BIRCH_LOG.get(), CFMBlocks.BEECH_LOG.get());
    }

}
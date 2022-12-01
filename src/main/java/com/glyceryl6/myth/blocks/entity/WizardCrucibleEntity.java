package com.glyceryl6.myth.blocks.entity;

import com.glyceryl6.myth.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WizardCrucibleEntity extends BlockEntity {

    public WizardCrucibleEntity(BlockPos worldPosition, BlockState state) {
        super(BlockEntityRegistry.STONE_CRUCIBLE_BLESS_ENTITY.get(), worldPosition, state);
    }

}
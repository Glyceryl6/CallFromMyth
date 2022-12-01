package com.glyceryl6.myth.blocks;

import com.glyceryl6.myth.blocks.abstracts.AbstractCrucibleBlock;
import com.glyceryl6.myth.blocks.entity.WizardCrucibleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WizardCrucibleBlock extends AbstractCrucibleBlock {

    public WizardCrucibleBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WizardCrucibleEntity(pos, state);
    }

}
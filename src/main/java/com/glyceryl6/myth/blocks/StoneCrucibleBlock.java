package com.glyceryl6.myth.blocks;

import com.glyceryl6.myth.blocks.abstracts.AbstractCrucibleBlock;
import com.glyceryl6.myth.blocks.entity.StoneCrucibleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class StoneCrucibleBlock extends AbstractCrucibleBlock {

    public StoneCrucibleBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneCrucibleEntity(pos, state);
    }

}
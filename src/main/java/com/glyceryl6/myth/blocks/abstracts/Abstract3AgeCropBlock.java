package com.glyceryl6.myth.blocks.abstracts;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class Abstract3AgeCropBlock extends CropBlock {

    public static final IntegerProperty AGE_3 = BlockStateProperties.AGE_3;

    public Abstract3AgeCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(this.getAgeProperty(), 0));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE_3;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE_3);
    }

}
package com.glyceryl6.myth.blocks.abstracts;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class Abstract5AgeCropBlock extends CropBlock {

    public static final IntegerProperty AGE_5 = BlockStateProperties.AGE_5;

    public Abstract5AgeCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(this.getAgeProperty(), 0));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE_5;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE_5);
    }

}
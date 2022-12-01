package com.glyceryl6.myth.blocks.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.*;

@SuppressWarnings("deprecation")
public abstract class AbstractCrucibleBlock extends BaseEntityBlock {

    protected static final BooleanProperty FILLED = BooleanProperty.create("filled");
    protected static final VoxelShape SHAPE = Shapes.or(
            box(2.0D, 0.1D, 0.0D, 14.0D, 12.0D, 2.0D),
            box(0.0D, 10.0D, 0.0D, 2.0D, 12.0D, 2.0D),
            box(0.0D, 10.0D, 14.0D, 2.0D, 12.0D, 16.0D),
            box(14.0D, 10.0D, 14.0D, 16.0D, 12.0D, 16.0D),
            box(14.0D, 10.0D, 0.0D, 16.0D, 12.0D, 2.0D),
            box(2.0D, 0.1D, 14.0D, 14.0D, 12.0D, 16.0D),
            box(14.0D, 0.1D, 2.0D, 16.0D, 12.0D, 14.0D),
            box(2.0D, 0.1D, 2.0D, 14.0D, 2.0D, 14.0D),
            box(0.0D, 0.1D, 2.0D, 2.0D, 12.0D, 14.0D),
            box(2.0D, 10.0D, 2.0D, 14.0D, 10.0D, 14.0D));

    protected AbstractCrucibleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FILLED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return box(2.0D, 4.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FILLED);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

}

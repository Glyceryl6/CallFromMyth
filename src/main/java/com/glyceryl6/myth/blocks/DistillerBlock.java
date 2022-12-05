package com.glyceryl6.myth.blocks;

import com.glyceryl6.myth.blocks.entity.DistillerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class DistillerBlock extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(0.0D, 0.0D, 2.0D, 16.0D, 1.0D, 14.0D),
            Block.box(7.0D, 1.0D, 4.0D, 15.0D, 2.0D, 12.0D),
            Block.box(1.0D, 1.0D, 6.0D, 5.0D, 7.0D, 10.0D),
            Block.box(7.0D, 8.0D, 4.0D, 15.0D, 10.0D, 12.0D),
            Block.box(9.0D, 10.0D, 6.0D, 13.0D, 14.0D, 10.0D),
            Block.box(10.0D, 14.0D, 7.0D, 12.0D, 16.0D, 9.0D),
            Block.box(6.0D, 7.0D, 7.0D, 14.0D, 9.0D, 9.0D),
            Block.box(6.0D, 2.0D, 3.0D, 16.0D, 8.0D, 13.0D),
            Block.box(2.09913D, 6.61102D, 7.1D, 3.89913D, 10.61102D, 8.9D));

    public DistillerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DistillerEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

}

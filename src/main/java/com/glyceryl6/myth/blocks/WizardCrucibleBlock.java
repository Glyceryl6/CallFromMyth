package com.glyceryl6.myth.blocks;

import com.glyceryl6.myth.blocks.abstracts.AbstractCrucibleBlock;
import com.glyceryl6.myth.blocks.entity.StoneCrucibleEntity;
import com.glyceryl6.myth.blocks.entity.WizardCrucibleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WizardCrucibleBlock extends AbstractCrucibleBlock {

    public WizardCrucibleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack waterBucket = new ItemStack(Items.WATER_BUCKET);
        ItemStack handHeld = player.getItemInHand(hand);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof WizardCrucibleEntity)) {
            return InteractionResult.CONSUME;
        }
        if (handHeld.is(waterBucket.getItem()) && !state.getValue(FILLED)) {
            return this.emptyBucket(level, pos, player, hand, handHeld, state.setValue(FILLED, true));
        }
        if (state.getValue(FILLED) && handHeld.is(Items.BUCKET)) {
            return this.fillBucket(state, level, pos, player, hand, handHeld, waterBucket, (predicate) -> true);
        }
        return InteractionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WizardCrucibleEntity(pos, state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

}
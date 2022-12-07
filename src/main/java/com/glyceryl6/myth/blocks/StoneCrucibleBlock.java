package com.glyceryl6.myth.blocks;

import com.glyceryl6.myth.blocks.abstracts.AbstractCrucibleBlock;
import com.glyceryl6.myth.blocks.entity.StoneCrucibleEntity;
import com.glyceryl6.myth.data.tags.item.CFMItemTags;
import com.glyceryl6.myth.registry.CFMBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class StoneCrucibleBlock extends AbstractCrucibleBlock {

    public StoneCrucibleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack waterBucket = new ItemStack(Items.WATER_BUCKET);
        ItemStack handHeld = player.getItemInHand(hand);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof StoneCrucibleEntity entity)) {
            return InteractionResult.CONSUME;
        }
        if (handHeld.is(waterBucket.getItem()) && !state.getValue(FILLED)) {
            return this.emptyBucket(level, pos, player, hand, handHeld, state.setValue(FILLED, true));
        }
        if (state.getValue(FILLED)) {
            if (handHeld.is(Items.BUCKET)) {
                Containers.dropContents(level, pos, entity.getSeeds());
                entity.getSeeds().clear();
                return this.fillBucket(state, level, pos, player, hand, handHeld, waterBucket, (predicate) -> true);
            } else if (handHeld.is(CFMItemTags.CAN_INTERACT_CRUCIBLE) && !entity.hasSeed(handHeld.getItem())) {
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                boolean flag = entity.canPutSeed(player.getAbilities().instabuild ? handHeld.copy() : handHeld);
                return flag ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof StoneCrucibleEntity entity) {
                Containers.dropContents(level, pos, entity.getSeeds());
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneCrucibleEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, CFMBlockEntity.STONE_CRUCIBLE_ENTITY.get(), StoneCrucibleEntity::serverTick);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

}
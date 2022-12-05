package com.glyceryl6.myth.blocks.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Predicate;

@SuppressWarnings("deprecation")
public abstract class AbstractCrucibleBlock extends BaseEntityBlock {

    public static final BooleanProperty FILLED = BooleanProperty.create("filled");
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
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        boolean flag = level.getBlockState(pos.below()).getBlock() instanceof BaseFireBlock;
        if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity) && flag) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.stepOn(level, pos, state, entity);
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

    protected InteractionResult fillBucket(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack emptyStack, ItemStack filledStack, Predicate<BlockState> statePredicate) {
        if (!statePredicate.test(state)) {
            return InteractionResult.PASS;
        } else {
            if (!level.isClientSide) {
                player.setItemInHand(hand, ItemUtils.createFilledResult(emptyStack, player, filledStack));
                player.awardStat(Stats.ITEM_USED.get(emptyStack.getItem()));
                level.setBlockAndUpdate(pos, this.defaultBlockState());
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    protected InteractionResult emptyBucket(Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack, BlockState state) {
        if (!level.isClientSide) {
            Item item = filledStack.getItem();
            player.setItemInHand(hand, ItemUtils.createFilledResult(filledStack, player, new ItemStack(Items.BUCKET)));
            player.awardStat(Stats.ITEM_USED.get(item));
            level.setBlockAndUpdate(pos, state);
            level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

}
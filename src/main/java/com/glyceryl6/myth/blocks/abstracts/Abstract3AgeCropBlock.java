package com.glyceryl6.myth.blocks.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("deprecation")
public abstract class Abstract3AgeCropBlock extends CropBlock {

    public static final IntegerProperty AGE_3 = BlockStateProperties.AGE_3;

    public Abstract3AgeCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(this.getAgeProperty(), 0));
    }

    public abstract Item getGrains();

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

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int i = state.getValue(AGE_3);
        boolean flag = i == this.getMaxAge();
        if (i > 3) {
            int j = 1 + level.random.nextInt(2);
            boolean flag1 = level.random.nextBoolean();
            float pitch = 0.8F + level.random.nextFloat() * 0.4F;
            popResource(level, pos, new ItemStack(this.getGrains(), flag ? (flag1 ? 2 : 1) : 0));
            popResource(level, pos, new ItemStack(this.getBaseSeedId(), j + (flag ? 2 : 1)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, pitch);
            level.setBlock(pos, state.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, hitResult);
        }
    }

}
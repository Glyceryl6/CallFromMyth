package com.glyceryl6.myth.blocks.entity;

import com.glyceryl6.myth.blocks.StoneCrucibleBlock;
import com.glyceryl6.myth.registry.BlockEntityRegistry;
import com.glyceryl6.myth.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class StoneCrucibleEntity extends BlockEntity {

    private final NonNullList<ItemStack> seeds = NonNullList.withSize(4, ItemStack.EMPTY);
    public int transformTicks;

    public StoneCrucibleEntity(BlockPos worldPosition, BlockState state) {
        super(BlockEntityRegistry.STONE_CRUCIBLE_ENTITY.get(), worldPosition, state);
    }

    public NonNullList<ItemStack> getSeeds() {
        return this.seeds;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, StoneCrucibleEntity entity) {
        Random random = level.random;
        if (!entity.seeds.isEmpty()) {
            double d0 = pos.getX() + (double)random.nextFloat();
            double d1 = pos.getY() + (double)random.nextFloat();
            double d2 = pos.getZ() + (double)random.nextFloat();
            if (level.getBlockState(pos.below()).is(Blocks.FIRE)) {
                if (level.isClientSide && state.getValue(StoneCrucibleBlock.FILLED)) {
                    level.addParticle(ParticleTypes.BUBBLE_POP, d0, d1, d2, 0.0D, 0.01D, 0.0D);
                    level.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, 0.0D, 0.01D, 0.0D);
                    if (random.nextInt(10) == 0) {
                        SoundEvent sound = SoundEvents.BUBBLE_COLUMN_UPWARDS_AMBIENT;
                        float volume = 0.2F + random.nextFloat() * 0.2F;
                        float pitch = 0.9F + random.nextFloat() * 0.15F;
                        level.playLocalSound(d0, d1, d2, sound, SoundSource.BLOCKS, volume, pitch, false);
                    }
                }
                if (entity.getSeedCount() == entity.seeds.size()) {
                    if (++entity.transformTicks >= 60) {
                        if (level.isClientSide) {
                            SoundEvent sound = SoundEvents.GENERIC_EXPLODE;
                            float pitch = (1.0F + (random.nextFloat() - random.nextFloat()) * 0.2F) * 0.7F;
                            level.addParticle(ParticleTypes.EXPLOSION_EMITTER, pos.getX(), pos.getY(), pos.getZ(), 1.0D, 0.0D, 0.0D);
                            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), sound, SoundSource.BLOCKS, 4.0F, pitch, false);
                            for(int i = 0; i < 1000; ++i) {
                                double c0 = random.nextGaussian() * 0.05D;
                                double c1 = random.nextGaussian() * 0.05D;
                                double c2 = random.nextGaussian() * 0.05D;
                                double randomX = Vec3.atCenterOf(pos).x + (2.0D * random.nextDouble() - 1.0D);
                                double randomY = Vec3.atCenterOf(pos).y + (2.0D * random.nextDouble() - 1.0D);
                                double randomZ = Vec3.atCenterOf(pos).z + (2.0D * random.nextDouble() - 1.0D);
                                level.addParticle(ParticleTypes.WITCH, randomX, randomY, randomZ, c0, c1, c2);
                                level.addParticle(ParticleTypes.DRAGON_BREATH, randomX, randomY, randomZ, c0, c1, c2);
                            }
                        } else {
                            entity.seeds.clear();
                            Block block = BlockRegistry.WIZARD_CRUCIBLE.get();
                            level.setBlockAndUpdate(pos, block.defaultBlockState());
                        }
                    } else {
                        for (int i = 0; i < 10; i++) {
                            double radian = (2 * Math.PI / 360) * 15 * entity.transformTicks;
                            double x1 = Vec3.atCenterOf(pos).x + Math.sin(radian);
                            double z1 = Vec3.atCenterOf(pos).z - Math.cos(radian);
                            double x2 = Vec3.atCenterOf(pos).x + Math.sin(radian) * 0.5D;
                            double z2 = Vec3.atCenterOf(pos).z - Math.cos(radian) * 0.5D;
                            level.addParticle(ParticleTypes.WITCH, x1, pos.getY(), z1, 0.0D, 0.0D, 0.0D);
                            level.addParticle(ParticleTypes.ELECTRIC_SPARK, x2, pos.getY(), z2, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.seeds.clear();
        ContainerHelper.loadAllItems(tag, this.seeds);
        this.transformTicks = tag.getInt("TransformTicks");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.seeds, true);
        tag.putInt("TransformTicks", this.transformTicks);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Nonnull
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.seeds, true);
        return compoundtag;
    }

    public int getSeedCount() {
        int count = 0;
        for (ItemStack stack : this.seeds) {
            if (!stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public boolean hasSeed(Item item) {
        for (ItemStack stack : this.seeds) {
            if (stack.is(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean canPutSeed(ItemStack stack) {
        for (int i = 0; i < this.seeds.size(); ++i) {
            ItemStack itemStack = this.seeds.get(i);
            if (itemStack.isEmpty()) {
                this.seeds.set(i, stack.split(1));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    private void markUpdated() {
        this.setChanged();
        if (this.getLevel() != null) {
            BlockState state = this.getBlockState();
            this.getLevel().sendBlockUpdated(this.getBlockPos(), state, state, 3);
        }
    }

}
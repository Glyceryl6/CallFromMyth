package com.glyceryl6.myth.blocks.grower;

import com.glyceryl6.myth.data.level.feature.CMTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BeechGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
        return random.nextInt(10) == 0 ? CMTreeFeatures.FANCY_BEECH : CMTreeFeatures.BEECH;
    }

}
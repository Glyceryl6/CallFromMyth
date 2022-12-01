package com.glyceryl6.myth.level.feature;

import com.glyceryl6.myth.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.OptionalInt;

public class CMTreeFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BEECH = FeatureUtils.register("beech", Feature.TREE, createBeech().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_BEECH = FeatureUtils.register("fancy_beech", Feature.TREE, createFancyBeech().build());

    private static TreeConfiguration.TreeConfigurationBuilder createBeech() {
        return TreeFeatures.createStraightBlobTree(BlockRegistry.BEECH_LOG.get(), BlockRegistry.BEECH_LEAVE.get(), 4, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyBeech() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockRegistry.BEECH_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(BlockRegistry.BEECH_LEAVE.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

}
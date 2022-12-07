package com.glyceryl6.myth.data.level.feature;

import com.glyceryl6.myth.registry.CFMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.OptionalInt;

public class CFMTreeFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SUPER_IRON_BIRCH = FeatureUtils.register("super_iron_birch", Feature.TREE, createSuperIronBirch().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_BEECH = FeatureUtils.register("fancy_beech", Feature.TREE, createFancyBeech().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> IRON_BIRCH = FeatureUtils.register("iron_birch", Feature.TREE, createIronBirch().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BEECH = FeatureUtils.register("beech", Feature.TREE, createBeech().build());

    private static TreeConfiguration.TreeConfigurationBuilder createIronBirch() {
        return TreeFeatures.createStraightBlobTree(CFMBlocks.IRON_BIRCH_LOG.get(), CFMBlocks.IRON_BIRCH_LEAVES.get(), 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBeech() {
        return TreeFeatures.createStraightBlobTree(CFMBlocks.BEECH_LOG.get(), CFMBlocks.BEECH_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSuperIronBirch() {
        return TreeFeatures.createStraightBlobTree(CFMBlocks.IRON_BIRCH_LOG.get(), CFMBlocks.IRON_BIRCH_LEAVES.get(), 5, 2, 6, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyBeech() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CFMBlocks.BEECH_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(CFMBlocks.BEECH_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

}
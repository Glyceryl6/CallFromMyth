package com.glyceryl6.myth.data.level.feature;

import com.glyceryl6.myth.registry.CFMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class CFMOreFeatures {

    public static final List<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = List.of(OreConfiguration.target(
            OreFeatures.STONE_ORE_REPLACEABLES, CFMBlocks.FINE_SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CFMBlocks.FINE_SILVER_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SILVER = FeatureUtils.register(
            "ore_silver", Feature.ORE, new OreConfiguration(ORE_SILVER_TARGET_LIST, 9));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SILVER_BURIED = FeatureUtils.register(
            "ore_silver_buried", Feature.ORE, new OreConfiguration(ORE_SILVER_TARGET_LIST, 9, 0.5F));

}
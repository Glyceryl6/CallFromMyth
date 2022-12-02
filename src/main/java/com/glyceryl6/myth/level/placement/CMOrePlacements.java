package com.glyceryl6.myth.level.placement;

import com.glyceryl6.myth.level.feature.CMOreFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CMOrePlacements {

    public static final Holder<PlacedFeature> ORE_SILVER_EXTRA = PlacementUtils.register("ore_silver_extra", CMOreFeatures.ORE_SILVER,
            OrePlacements.commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256))));
    public static final Holder<PlacedFeature> ORE_SILVER = PlacementUtils.register("ore_silver", CMOreFeatures.ORE_SILVER_BURIED,
            OrePlacements.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
    public static final Holder<PlacedFeature> ORE_SILVER_LOWER = PlacementUtils.register("ore_silver_lower", CMOreFeatures.ORE_SILVER_BURIED,
            OrePlacements.orePlacement(CountPlacement.of(UniformInt.of(0, 1)),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))));

}
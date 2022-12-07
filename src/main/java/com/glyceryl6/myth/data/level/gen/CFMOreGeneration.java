package com.glyceryl6.myth.data.level.gen;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.data.level.placement.CFMOrePlacements;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CallFromMyth.MOD_ID)
public class CFMOreGeneration {

    @SubscribeEvent
    public static void onBiomesLoading(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        GenerationStep.Decoration stage = GenerationStep.Decoration.UNDERGROUND_ORES;
        List<Holder<PlacedFeature>> holders = builder.getFeatures(stage);
        holders.add(CFMOrePlacements.ORE_SILVER_EXTRA);
        holders.add(CFMOrePlacements.ORE_SILVER_LOWER);
        holders.add(CFMOrePlacements.ORE_SILVER);
    }

}
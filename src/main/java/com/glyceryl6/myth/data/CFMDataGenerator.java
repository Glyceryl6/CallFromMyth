package com.glyceryl6.myth.data;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.data.provider.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CallFromMyth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CFMDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        generator.addProvider(new CFMBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new CFMBlockTagsProvider(generator, existingFileHelper));
        //generator.addProvider(new CFMItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new CFMLootTableProvider(generator));
    }

}
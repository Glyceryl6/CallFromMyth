package com.glyceryl6.myth.data;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.data.provider.CMBlockStateProvider;
import com.glyceryl6.myth.data.provider.CMLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CallFromMyth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CMDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();
        generator.addProvider(new CMBlockStateProvider(generator, exFileHelper));
        generator.addProvider(new CMLootTableProvider(generator));
    }

}
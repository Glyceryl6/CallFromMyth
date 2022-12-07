package com.glyceryl6.myth.data.provider;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CFMItemTagsProvider extends ItemTagsProvider {

    public CFMItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, CallFromMyth.MOD_ID, existingFileHelper);
    }

}
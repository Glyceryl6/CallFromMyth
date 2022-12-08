package com.glyceryl6.myth.data.provider;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.data.tags.item.CFMItemTags;
import com.glyceryl6.myth.registry.CFMItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CFMItemTagsProvider extends ItemTagsProvider {

    public CFMItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, CallFromMyth.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(CFMItemTags.CAN_INTERACT_CRUCIBLE).add(CFMItems.DATURA_SEEDS.get(), CFMItems.HENBANE_SEEDS.get(),
                CFMItems.BELLADONNA_SEEDS.get(), CFMItems.CHILI_PEPPER_SEEDS.get());
    }
}
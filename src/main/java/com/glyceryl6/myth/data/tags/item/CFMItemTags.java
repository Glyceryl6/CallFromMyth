package com.glyceryl6.myth.data.tags.item;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CFMItemTags {

    public static final TagKey<Item> CAN_INTERACT_CRUCIBLE = create("can_interact_crucible");

    public static TagKey<Item> create(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CallFromMyth.MOD_ID, name));
    }

}
package com.glyceryl6.myth.data.tags.block;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CFMBlockTags {

    public static TagKey<Block> create(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CallFromMyth.MOD_ID, name));
    }

}
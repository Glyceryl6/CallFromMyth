package com.glyceryl6.myth.client.model.geom;

import com.glyceryl6.myth.CallFromMyth;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CMModelLayers {

    public static final ModelLayerLocation HUNTER = register("hunter");
    public static final ModelLayerLocation HUNTER_HAT = register("hunter_hat");
    public static final ModelLayerLocation HUNTER_ARMOR = register("hunter_armor");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(CallFromMyth.prefix(path), "main");
    }

}
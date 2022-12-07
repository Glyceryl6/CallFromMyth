package com.glyceryl6.myth.client.renderer.entity;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.client.model.HunterHatModel;
import com.glyceryl6.myth.client.model.geom.CMModelLayers;
import com.glyceryl6.myth.client.renderer.entity.layers.HunterArmorLayer;
import com.glyceryl6.myth.client.renderer.entity.layers.HunterHatLayer;
import com.glyceryl6.myth.entity.monster.Hunter;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@OnlyIn(Dist.CLIENT)
public class HunterRenderer extends LivingEntityRenderer<Hunter, PlayerModel<Hunter>> {

    public HunterRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this));
        this.addLayer(new HunterHatLayer<>(this,
                new HunterHatModel<>(context.bakeLayer(CMModelLayers.HUNTER_HAT))));
        this.addLayer(new HunterArmorLayer<>(this,
                new HumanoidModel<>(context.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)),
                new HumanoidModel<>(context.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR))));
    }

    @Override
    protected boolean shouldShowName(Hunter hunter) {
        boolean flag = hunter == this.entityRenderDispatcher.crosshairPickEntity;
        return super.shouldShowName(hunter) && (hunter.shouldShowName() || hunter.hasCustomName() && flag);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(Hunter hunter) {
        return CallFromMyth.prefix("textures/entity/hunter/hunter.png");
    }

}
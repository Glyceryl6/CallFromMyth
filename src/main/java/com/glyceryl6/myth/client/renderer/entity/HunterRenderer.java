package com.glyceryl6.myth.client.renderer.entity;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.client.renderer.entity.layers.HunterHatLayer;
import com.glyceryl6.myth.entity.monster.Hunter;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
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
        this.addLayer(new HunterHatLayer<>(this, context.getModelSet()));
    }

    @Override
    public void render(Hunter hunter, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(hunter, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected void scale(Hunter hunter, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    protected boolean shouldShowName(Hunter hunter) {
        boolean flag = hunter == this.entityRenderDispatcher.crosshairPickEntity;
        return super.shouldShowName(hunter) && (hunter.shouldShowName() || hunter.hasCustomName() && flag);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(Hunter hunter) {
        return CallFromMyth.prefix("textures/entity/hunter.png");
    }

}
package com.glyceryl6.myth.client.renderer.entity.layers;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.client.model.HunterHatModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HunterHatLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation LAYER_LOCATION = CallFromMyth.prefix("textures/entity/hunter/hunter_hat.png");
    private final HunterHatModel<T> hunterHatModel;

    public HunterHatLayer(RenderLayerParent<T, M> renderer, HunterHatModel<T> hunterHatModel) {
        super(renderer);
        this.hunterHatModel = hunterHatModel;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        poseStack.pushPose();
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(LAYER_LOCATION));
        this.hunterHatModel.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.hunterHatModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }

}
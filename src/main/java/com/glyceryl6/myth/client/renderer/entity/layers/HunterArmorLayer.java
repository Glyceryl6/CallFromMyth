package com.glyceryl6.myth.client.renderer.entity.layers;

import com.glyceryl6.myth.CallFromMyth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
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
public class HunterArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation HUNTER_LEGGING_LAYER = CallFromMyth.prefix("textures/entity/hunter/hunter_layer_2.png");
    private static final ResourceLocation HUNTER_BODY_LAYER = CallFromMyth.prefix("textures/entity/hunter/hunter_layer_1.png");
    private final A leggingsModel;
    private final A bodyModel;

    public HunterArmorLayer(RenderLayerParent<T, M> renderer, A leggingsModel, A bodyModel) {
        super(renderer);
        this.leggingsModel = leggingsModel;
        this.bodyModel = bodyModel;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.renderModel(poseStack, buffer, packedLight, this.leggingsModel, HUNTER_LEGGING_LAYER);
        this.renderModel(poseStack, buffer, packedLight, this.bodyModel, HUNTER_BODY_LAYER);
        this.getParentModel().copyPropertiesTo(this.leggingsModel);
        this.getParentModel().copyPropertiesTo(this.bodyModel);
        this.leggingsModel.setAllVisible(true);
        this.bodyModel.setAllVisible(true);
    }

    private void renderModel(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Model model, ResourceLocation armorResource) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(armorResource));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

}
package com.glyceryl6.myth.handler.client;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.blocks.entity.StoneCrucibleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CallFromMyth.MOD_ID)
public class ClientRenderHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onDrawScreenPost(RenderGameOverlayEvent.Post event) {
        float angle = -90;
        Minecraft mc = Minecraft.getInstance();
        Entity entity = mc.getCameraEntity();
        PoseStack poseStack = event.getMatrixStack();
        if (entity != null && mc.level != null) {
            int xc = mc.getWindow().getGuiScaledWidth() / 2;
            int yc = mc.getWindow().getGuiScaledHeight() / 2;
            HitResult hitResult = entity.pick(5.0D, 0.0F, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = ((BlockHitResult)hitResult).getBlockPos();
                BlockEntity blockEntity = mc.level.getBlockEntity(pos);
                if (blockEntity instanceof StoneCrucibleEntity stoneCrucible) {
                    ItemRenderer itemRenderer = mc.getItemRenderer();
                    int count = stoneCrucible.getSeedCount();
                    float anglePer = 360F / count;
                    for (int i = 0; i < count; ++i) {
                        ItemStack stack = stoneCrucible.getSeeds().get(i);
                        double xPos = xc + Math.cos(angle * Math.PI / 180D) * 24 - 8;
                        double yPos = yc + Math.sin(angle * Math.PI / 180D) * 24 - 8;
                        if (!stack.isEmpty()) {
                            String name = stack.getHoverName().getString();
                            int x = (int)xPos - mc.font.width(name) / 2 + 8;
                            itemRenderer.renderGuiItem(stack, (int)xPos, (int)yPos - 16);
                            mc.font.draw(poseStack, name, x, (int)yPos, 0xffffff);
                            angle += anglePer;
                        }
                    }
                }
            }
        }
    }

}
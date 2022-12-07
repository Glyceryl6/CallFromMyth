package com.glyceryl6.myth;

import com.glyceryl6.myth.blocks.entity.StoneCrucibleEntity;
import com.glyceryl6.myth.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Locale;

@Mod(CallFromMyth.MOD_ID)
public class CallFromMyth {

    public static final String MOD_ID = "call_from_myth";
    public IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public CallFromMyth() {
        CFMItems.ITEMS.register(this.eventBus);
        CFMBlocks.BLOCKS.register(this.eventBus);
        CFMEntity.ENTITY.register(this.eventBus);
        CFMBlockEntity.BLOCK_ENTITY.register(this.eventBus);
        this.eventBus.addListener(this::registerRenderLayer);
        this.eventBus.addListener(this::registerColors);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.DATURA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.HENBANE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.BELLADONNA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.CHILI_PEPPER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.BEECH_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.BEECH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.STONE_CRUCIBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.WIZARD_CRUCIBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.IRON_BIRCH_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(CFMBlocks.IRON_BIRCH_SAPLING.get(), RenderType.cutout());
    }

    private void registerColors(FMLClientSetupEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        BlockColors blockColors = minecraft.getBlockColors();
        blockColors.register((state, level, pos, tintIndex) ->
                0x74979f, CFMBlocks.WIZARD_CRUCIBLE.get());
        blockColors.register((state, level, pos, tintIndex) -> {
            int liquidColor = 0xffffff;
            if (level != null && pos != null && tintIndex == 0) {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof StoneCrucibleEntity entity) {
                    liquidColor = switch (entity.getSeedCount()) {
                        case 1 -> 0xb5ebf7;
                        case 2 -> 0x9eced9;
                        case 3 -> 0x88b1ba;
                        case 4 -> 0x74979f;
                        default -> 0xffffff;
                    };
                }
            }
            return liquidColor;
        }, CFMBlocks.STONE_CRUCIBLE.get());
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

}
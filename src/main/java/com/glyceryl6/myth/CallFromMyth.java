package com.glyceryl6.myth;

import com.glyceryl6.myth.registry.BlockEntityRegistry;
import com.glyceryl6.myth.registry.BlockRegistry;
import com.glyceryl6.myth.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CallFromMyth.MOD_ID)
public class CallFromMyth {

    public static final String MOD_ID = "call_from_myth";
    public IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public CallFromMyth() {
        ItemRegistry.ITEMS.register(this.eventBus);
        BlockRegistry.BLOCKS.register(this.eventBus);
        BlockEntityRegistry.BLOCK_ENTITY.register(this.eventBus);
        this.eventBus.addListener(this::registerRenderLayer);
        this.eventBus.addListener(this::registerColors);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.DATURA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.HENBANE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BELLADONNA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CHILI_PEPPER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BEECH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STONE_CRUCIBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WIZARD_CRUCIBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BEECH_LEAVE.get(), RenderType.cutoutMipped());
    }

    private void registerColors(FMLClientSetupEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        BlockColors blockColors = minecraft.getBlockColors();
        blockColors.register((state, level, pos, tintIndex) ->
                0x74979f, BlockRegistry.WIZARD_CRUCIBLE.get());
    }

}
package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.blocks.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CFMBlockEntity {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CallFromMyth.MOD_ID);

    public static final RegistryObject<BlockEntityType<DistillerEntity>> DISTILLER_ENTITY = BLOCK_ENTITY.register("distiller_entity",
            () -> BlockEntityType.Builder.of(DistillerEntity::new, CFMBlocks.DISTILLER.get()).build(null));

    public static final RegistryObject<BlockEntityType<StoneCrucibleEntity>> STONE_CRUCIBLE_ENTITY = BLOCK_ENTITY.register("stone_crucible_entity",
            () -> BlockEntityType.Builder.of(StoneCrucibleEntity::new, CFMBlocks.STONE_CRUCIBLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<WizardCrucibleEntity>> STONE_CRUCIBLE_BLESS_ENTITY = BLOCK_ENTITY.register("stone_crucible_bless_entity",
            () -> BlockEntityType.Builder.of(WizardCrucibleEntity::new, CFMBlocks.WIZARD_CRUCIBLE.get()).build(null));

}

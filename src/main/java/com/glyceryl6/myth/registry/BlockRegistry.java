package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.blocks.DistillerBlock;
import com.glyceryl6.myth.blocks.WizardCrucibleBlock;
import com.glyceryl6.myth.blocks.StoneCrucibleBlock;
import com.glyceryl6.myth.blocks.crops.BelladonnaBlock;
import com.glyceryl6.myth.blocks.crops.ChiliPepperBlock;
import com.glyceryl6.myth.blocks.crops.DaturaBlock;
import com.glyceryl6.myth.blocks.crops.HenbaneBlock;
import com.glyceryl6.myth.blocks.grower.BeechGrower;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CallFromMyth.MOD_ID);

    public static final RegistryObject<Block> BEECH_LOG = BLOCKS.register("beech_log",
            () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> BEECH_LEAVE = BLOCKS.register("beech_leaves",
            () -> Blocks.leaves(SoundType.GRASS));

    public static final RegistryObject<Block> MALACHITE_ORE = BLOCKS.register("malachite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> FINE_SILVER_ORE = BLOCKS.register("fine_silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> FINE_SILVER_BLOCK = BLOCKS.register("fine_silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> DATURA = BLOCKS.register("datura",
            () -> new DaturaBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> HENBANE = BLOCKS.register("henbane",
            () -> new HenbaneBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> BELLADONNA = BLOCKS.register("belladonna",
            () -> new BelladonnaBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> CHILI_PEPPER = BLOCKS.register("chili_pepper",
            () -> new ChiliPepperBlock(defaultPlants(SoundType.CROP)));

    public static final RegistryObject<Block> BEECH_SAPLING = BLOCKS.register("beech_sapling",
            () -> new SaplingBlock(new BeechGrower(), defaultPlants(SoundType.GRASS)));
    public static final RegistryObject<Block> STONE_CRUCIBLE = BLOCKS.register("stone_crucible",
            () -> new StoneCrucibleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WIZARD_CRUCIBLE = BLOCKS.register("wizard_crucible",
            () -> new WizardCrucibleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> DISTILLER = BLOCKS.register("distiller",
            () -> new DistillerBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    private static BlockBehaviour.Properties defaultPlants(SoundType soundType) {
        return BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(soundType);
    }

}
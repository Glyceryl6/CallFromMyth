package com.glyceryl6.myth.registry;

import com.glyceryl6.myth.CallFromMyth;
import com.glyceryl6.myth.blocks.*;
import com.glyceryl6.myth.blocks.crops.*;
import com.glyceryl6.myth.blocks.grower.BeechGrower;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.*;

import static com.glyceryl6.myth.utils.BlockUtils.*;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CallFromMyth.MOD_ID);

    public static final RegistryObject<Block> BEECH_LOG = registerBlock("beech_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> BEECH_LEAVE = registerBlock("beech_leaves", () -> Blocks.leaves(SoundType.GRASS));

    public static final RegistryObject<Block> BEECH_PLANKS = normal("beech_planks", copy(Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> FINE_SILVER_BLOCK = normal("fine_silver_block", copy(Blocks.IRON_BLOCK));

    public static final RegistryObject<Block> MALACHITE_ORE = ore("malachite_ore", copy(Blocks.STONE));
    public static final RegistryObject<Block> FINE_SILVER_ORE = ore("fine_silver_ore", copy(Blocks.STONE));

    public static final RegistryObject<Block> BEECH_PRESSURE_PLATE = pressurePlate("beech_pressure_plate", copy(Blocks.OAK_PRESSURE_PLATE));
    public static final RegistryObject<Block> BEECH_FENCE_GATE = fenceGate("beech_fence_gate", copy(Blocks.OAK_FENCE_GATE));
    public static final RegistryObject<Block> BEECH_TRAPDOOR = trapdoor("beech_trapdoor", copy(Blocks.OAK_TRAPDOOR));
    public static final RegistryObject<Block> BEECH_BUTTON = button("beech_button", true, copy(Blocks.OAK_BUTTON));
    public static final RegistryObject<Block> BEECH_STAIR = stair("beech_stairs", BEECH_PLANKS, copy(Blocks.OAK_STAIRS));
    public static final RegistryObject<Block> BEECH_FENCE = fence("beech_fence", copy(Blocks.OAK_FENCE));
    public static final RegistryObject<Block> BEECH_DOOR = door("beech_door", copy(Blocks.OAK_DOOR));
    public static final RegistryObject<Block> BEECH_SLAB = slab("beech_slab", copy(Blocks.OAK_SLAB));
    public static final RegistryObject<Block> BEECH_WALL = wall("beech_wall", copy(Blocks.OAK_PLANKS));

    public static final RegistryObject<Block> DATURA = BLOCKS.register("datura", () -> new DaturaBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> HENBANE = BLOCKS.register("henbane", () -> new HenbaneBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> BELLADONNA = BLOCKS.register("belladonna", () -> new BelladonnaBlock(defaultPlants(SoundType.CROP)));
    public static final RegistryObject<Block> CHILI_PEPPER = BLOCKS.register("chili_pepper", () -> new ChiliPepperBlock(defaultPlants(SoundType.CROP)));

    public static final RegistryObject<Block> BEECH_SAPLING = registerBlock("beech_sapling",
            () -> new SaplingBlock(new BeechGrower(), defaultPlants(SoundType.GRASS)));
    public static final RegistryObject<Block> STONE_CRUCIBLE = registerBlock("stone_crucible",
            () -> new StoneCrucibleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> WIZARD_CRUCIBLE = registerBlock("wizard_crucible",
            () -> new WizardCrucibleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> DISTILLER = registerBlock("distiller",
            () -> new DistillerBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> POTTED_BEECH_SAPLING = flowerPot("potted_beech_sapling", BEECH_SAPLING);

    private static BlockBehaviour.Properties copy(BlockBehaviour blockBehaviour) {
        return BlockBehaviour.Properties.copy(blockBehaviour);
    }

    private static BlockBehaviour.Properties defaultPlants(SoundType soundType) {
        return BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(soundType);
    }

}
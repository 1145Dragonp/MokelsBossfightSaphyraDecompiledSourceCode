package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.block.AzureBricksAnimatedBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureLanternBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureSlabBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureStairsBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureTilesBlock;
import mrmd.mokelsbossfightsaphyraup.block.AzureWallBlock;
import mrmd.mokelsbossfightsaphyraup.block.BloodBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.BloodBricksSlabBlock;
import mrmd.mokelsbossfightsaphyraup.block.BloodBricksStairsBlock;
import mrmd.mokelsbossfightsaphyraup.block.BloodDoor1Block;
import mrmd.mokelsbossfightsaphyraup.block.BloodLanternBlock;
import mrmd.mokelsbossfightsaphyraup.block.BloodWallBlock;
import mrmd.mokelsbossfightsaphyraup.block.BossDoor1Block;
import mrmd.mokelsbossfightsaphyraup.block.BossDoor3Block;
import mrmd.mokelsbossfightsaphyraup.block.BossDoorBlock;
import mrmd.mokelsbossfightsaphyraup.block.BossFogBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedAzureBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedAzureSlabBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedAzureStairsBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedAzureWallBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedBloodBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedBloodSlabBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedBloodStairsBlock;
import mrmd.mokelsbossfightsaphyraup.block.DarkPolishedBloodWallBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogChainBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogHateredBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogKnifeBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogLoversBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogShatteredBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogStepsBlock;
import mrmd.mokelsbossfightsaphyraup.block.LockedFogWorshipBlock;
import mrmd.mokelsbossfightsaphyraup.block.LyiorStatueAktivatedBlock;
import mrmd.mokelsbossfightsaphyraup.block.LyiorStatueBlock;
import mrmd.mokelsbossfightsaphyraup.block.OddmentHallowedTowerBlock;
import mrmd.mokelsbossfightsaphyraup.block.OddmentStage2Block;
import mrmd.mokelsbossfightsaphyraup.block.PolishedAzureBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.PolishedBloodBricksBlock;
import mrmd.mokelsbossfightsaphyraup.block.RedGlassBlock;
import mrmd.mokelsbossfightsaphyraup.block.SaphyraDoor1Block;
import mrmd.mokelsbossfightsaphyraup.block.SaphyraDoor2Block;
import mrmd.mokelsbossfightsaphyraup.block.SaphyraDoor3Block;
import mrmd.mokelsbossfightsaphyraup.block.SpaceBlockBlock;
import mrmd.mokelsbossfightsaphyraup.block.WhiteFlameBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MokelsBossfightSaphyraModBlocks {
   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "mokels_bossfight_saphyra");
   public static final RegistryObject<Block> BOSS_DOOR2 = REGISTRY.register("boss_door2", () -> new BossDoorBlock());
   public static final RegistryObject<Block> LYIOR_STATUE = REGISTRY.register("lyior_statue", () -> new LyiorStatueBlock());
   public static final RegistryObject<Block> LYIOR_STATUE_AKTIVATED = REGISTRY.register("lyior_statue_aktivated", () -> new LyiorStatueAktivatedBlock());
   public static final RegistryObject<Block> AZURE_BRICKS = REGISTRY.register("azure_bricks", () -> new AzureBricksBlock());
   public static final RegistryObject<Block> AZURE_SLAB = REGISTRY.register("azure_slab", () -> new AzureSlabBlock());
   public static final RegistryObject<Block> AZURE_STAIRS = REGISTRY.register("azure_stairs", () -> new AzureStairsBlock());
   public static final RegistryObject<Block> AZURE_WALL = REGISTRY.register("azure_wall", () -> new AzureWallBlock());
   public static final RegistryObject<Block> AZURE_BRICKS_ANIMATED = REGISTRY.register("azure_bricks_animated", () -> new AzureBricksAnimatedBlock());
   public static final RegistryObject<Block> BOSS_DOOR_1 = REGISTRY.register("boss_door_1", () -> new BossDoor1Block());
   public static final RegistryObject<Block> BOSS_DOOR_3 = REGISTRY.register("boss_door_3", () -> new BossDoor3Block());
   public static final RegistryObject<Block> SPACE_BLOCK = REGISTRY.register("space_block", () -> new SpaceBlockBlock());
   public static final RegistryObject<Block> ODDMENT_STAGE_2 = REGISTRY.register("oddment_stage_2", () -> new OddmentStage2Block());
   public static final RegistryObject<Block> BLOOD_WALL = REGISTRY.register("blood_wall", () -> new BloodWallBlock());
   public static final RegistryObject<Block> BLOOD_BRICKS = REGISTRY.register("blood_bricks", () -> new BloodBricksBlock());
   public static final RegistryObject<Block> POLISHED_BLOOD_BRICKS = REGISTRY.register("polished_blood_bricks", () -> new PolishedBloodBricksBlock());
   public static final RegistryObject<Block> DARK_POLISHED_BLOOD_BRICKS = REGISTRY.register(
      "dark_polished_blood_bricks", () -> new DarkPolishedBloodBricksBlock()
   );
   public static final RegistryObject<Block> DARK_POLISHED_BLOOD_WALL = REGISTRY.register("dark_polished_blood_wall", () -> new DarkPolishedBloodWallBlock());
   public static final RegistryObject<Block> DARK_POLISHED_BLOOD_STAIRS = REGISTRY.register(
      "dark_polished_blood_stairs", () -> new DarkPolishedBloodStairsBlock()
   );
   public static final RegistryObject<Block> DARK_POLISHED_BLOOD_SLAB = REGISTRY.register("dark_polished_blood_slab", () -> new DarkPolishedBloodSlabBlock());
   public static final RegistryObject<Block> BLOOD_BRICKS_SLAB = REGISTRY.register("blood_bricks_slab", () -> new BloodBricksSlabBlock());
   public static final RegistryObject<Block> BLOOD_BRICKS_STAIRS = REGISTRY.register("blood_bricks_stairs", () -> new BloodBricksStairsBlock());
   public static final RegistryObject<Block> BLOOD_LANTERN = REGISTRY.register("blood_lantern", () -> new BloodLanternBlock());
   public static final RegistryObject<Block> WHITE_FLAME = REGISTRY.register("white_flame", () -> new WhiteFlameBlock());
   public static final RegistryObject<Block> BLOOD_DOOR_1 = REGISTRY.register("blood_door_1", () -> new BloodDoor1Block());
   public static final RegistryObject<Block> POLISHED_AZURE_BRICKS = REGISTRY.register("polished_azure_bricks", () -> new PolishedAzureBricksBlock());
   public static final RegistryObject<Block> AZURE_LANTERN = REGISTRY.register("azure_lantern", () -> new AzureLanternBlock());
   public static final RegistryObject<Block> DARK_POLISHED_AZURE_BRICKS = REGISTRY.register(
      "dark_polished_azure_bricks", () -> new DarkPolishedAzureBricksBlock()
   );
   public static final RegistryObject<Block> DARK_POLISHED_AZURE_SLAB = REGISTRY.register("dark_polished_azure_slab", () -> new DarkPolishedAzureSlabBlock());
   public static final RegistryObject<Block> DARK_POLISHED_AZURE_STAIRS = REGISTRY.register(
      "dark_polished_azure_stairs", () -> new DarkPolishedAzureStairsBlock()
   );
   public static final RegistryObject<Block> DARK_POLISHED_AZURE_WALL = REGISTRY.register("dark_polished_azure_wall", () -> new DarkPolishedAzureWallBlock());
   public static final RegistryObject<Block> LOCKED_FOG_CHAIN = REGISTRY.register("locked_fog_chain", () -> new LockedFogChainBlock());
   public static final RegistryObject<Block> LOCKED_FOG_SHATTERED = REGISTRY.register("locked_fog_shattered", () -> new LockedFogShatteredBlock());
   public static final RegistryObject<Block> LOCKED_FOG_WORSHIP = REGISTRY.register("locked_fog_worship", () -> new LockedFogWorshipBlock());
   public static final RegistryObject<Block> LOCKED_FOG_KNIFE = REGISTRY.register("locked_fog_knife", () -> new LockedFogKnifeBlock());
   public static final RegistryObject<Block> LOCKED_FOG_STEPS = REGISTRY.register("locked_fog_steps", () -> new LockedFogStepsBlock());
   public static final RegistryObject<Block> LOCKED_FOG_LOVERS = REGISTRY.register("locked_fog_lovers", () -> new LockedFogLoversBlock());
   public static final RegistryObject<Block> LOCKED_FOG_HATERED = REGISTRY.register("locked_fog_hatered", () -> new LockedFogHateredBlock());
   public static final RegistryObject<Block> ODDMENT_HALLOWED_TOWER = REGISTRY.register("oddment_hallowed_tower", () -> new OddmentHallowedTowerBlock());
   public static final RegistryObject<Block> RED_GLASS = REGISTRY.register("red_glass", () -> new RedGlassBlock());
   public static final RegistryObject<Block> BOSS_FOG = REGISTRY.register("boss_fog", () -> new BossFogBlock());
   public static final RegistryObject<Block> AZURE_TILES = REGISTRY.register("azure_tiles", () -> new AzureTilesBlock());
   public static final RegistryObject<Block> SAPHYRA_DOOR_1 = REGISTRY.register("saphyra_door_1", () -> new SaphyraDoor1Block());
   public static final RegistryObject<Block> SAPHYRA_DOOR_2 = REGISTRY.register("saphyra_door_2", () -> new SaphyraDoor2Block());
   public static final RegistryObject<Block> SAPHYRA_DOOR_3 = REGISTRY.register("saphyra_door_3", () -> new SaphyraDoor3Block());
}

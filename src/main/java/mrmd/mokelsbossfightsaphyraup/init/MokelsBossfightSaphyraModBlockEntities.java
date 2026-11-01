package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor1TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor3TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoorTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueAktivatedTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentHallowedTowerTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentStage2TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor1TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor2TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor3TileEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MokelsBossfightSaphyraModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "mokels_bossfight_saphyra");
   public static final RegistryObject<BlockEntityType<BossDoorTileEntity>> BOSS_DOOR2 = REGISTRY.register(
      "boss_door2", () -> Builder.of(BossDoorTileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR2.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<LyiorStatueTileEntity>> LYIOR_STATUE = REGISTRY.register(
      "lyior_statue",
      () -> Builder.of(LyiorStatueTileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.LYIOR_STATUE.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<LyiorStatueAktivatedTileEntity>> LYIOR_STATUE_AKTIVATED = REGISTRY.register(
      "lyior_statue_aktivated",
      () -> Builder.of(LyiorStatueAktivatedTileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.LYIOR_STATUE_AKTIVATED.get()})
            .build(null)
   );
   public static final RegistryObject<BlockEntityType<BossDoor1TileEntity>> BOSS_DOOR_1 = REGISTRY.register(
      "boss_door_1", () -> Builder.of(BossDoor1TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR_1.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<BossDoor3TileEntity>> BOSS_DOOR_3 = REGISTRY.register(
      "boss_door_3", () -> Builder.of(BossDoor3TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR_3.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<OddmentStage2TileEntity>> ODDMENT_STAGE_2 = REGISTRY.register(
      "oddment_stage_2",
      () -> Builder.of(OddmentStage2TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.ODDMENT_STAGE_2.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<OddmentHallowedTowerTileEntity>> ODDMENT_HALLOWED_TOWER = REGISTRY.register(
      "oddment_hallowed_tower",
      () -> Builder.of(OddmentHallowedTowerTileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.ODDMENT_HALLOWED_TOWER.get()})
            .build(null)
   );
   public static final RegistryObject<BlockEntityType<SaphyraDoor1TileEntity>> SAPHYRA_DOOR_1 = REGISTRY.register(
      "saphyra_door_1",
      () -> Builder.of(SaphyraDoor1TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_1.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<SaphyraDoor2TileEntity>> SAPHYRA_DOOR_2 = REGISTRY.register(
      "saphyra_door_2",
      () -> Builder.of(SaphyraDoor2TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_2.get()}).build(null)
   );
   public static final RegistryObject<BlockEntityType<SaphyraDoor3TileEntity>> SAPHYRA_DOOR_3 = REGISTRY.register(
      "saphyra_door_3",
      () -> Builder.of(SaphyraDoor3TileEntity::new, new Block[]{(Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_3.get()}).build(null)
   );

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.of(supplier, new Block[]{(Block)block.get()}).build(null));
   }
}

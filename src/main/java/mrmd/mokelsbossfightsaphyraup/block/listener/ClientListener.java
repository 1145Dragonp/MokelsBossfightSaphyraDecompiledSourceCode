package mrmd.mokelsbossfightsaphyraup.block.listener;

import mrmd.mokelsbossfightsaphyraup.block.renderer.BossDoor1TileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.BossDoor3TileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.BossDoorTileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.LyiorStatueAktivatedTileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.LyiorStatueTileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.OddmentHallowedTowerTileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.OddmentStage2TileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.SaphyraDoor1TileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.SaphyraDoor2TileRenderer;
import mrmd.mokelsbossfightsaphyraup.block.renderer.SaphyraDoor3TileRenderer;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "mokels_bossfight_saphyra",
   bus = Bus.MOD
)
public class ClientListener {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerRenderers(RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.BOSS_DOOR2.get(), context -> new BossDoorTileRenderer());
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.LYIOR_STATUE.get(), context -> new LyiorStatueTileRenderer());
      event.registerBlockEntityRenderer(
         (BlockEntityType)MokelsBossfightSaphyraModBlockEntities.LYIOR_STATUE_AKTIVATED.get(), context -> new LyiorStatueAktivatedTileRenderer()
      );
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.BOSS_DOOR_1.get(), context -> new BossDoor1TileRenderer());
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.BOSS_DOOR_3.get(), context -> new BossDoor3TileRenderer());
      event.registerBlockEntityRenderer(
         (BlockEntityType)MokelsBossfightSaphyraModBlockEntities.ODDMENT_STAGE_2.get(), context -> new OddmentStage2TileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)MokelsBossfightSaphyraModBlockEntities.ODDMENT_HALLOWED_TOWER.get(), context -> new OddmentHallowedTowerTileRenderer()
      );
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.SAPHYRA_DOOR_1.get(), context -> new SaphyraDoor1TileRenderer());
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.SAPHYRA_DOOR_2.get(), context -> new SaphyraDoor2TileRenderer());
      event.registerBlockEntityRenderer((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.SAPHYRA_DOOR_3.get(), context -> new SaphyraDoor3TileRenderer());
   }
}

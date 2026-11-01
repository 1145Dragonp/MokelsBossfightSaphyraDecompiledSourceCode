package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.client.renderer.GhostSpiritRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.GhostZombieRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.InfestedWitchRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.LinaraHallowedTower2Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.LinaraHallowedTowerRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.LinaraRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.MarleneHumanFormDialog2Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.MarleneHumanFormRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.MoonbeamRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.MothbossRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.NamelessRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.NamelessSpawnRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.PuppetOfYivaNemorRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.PutridRoseRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.SaphyraDialog1Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.SaphyraDialog2Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.SaphyraDialog3Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.SaphyraDialog4Renderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.SaphyraSpawnRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.ScorchedRenderer;
import mrmd.mokelsbossfightsaphyraup.client.renderer.WitchbossRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class MokelsBossfightSaphyraModEntityRenderers {
   @SubscribeEvent
   public static void registerEntityRenderers(RegisterRenderers event) {
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.WITCHBOSS.get(), WitchbossRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.MOONBEAM.get(), MoonbeamRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILE.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.GHOST_SPIRIT.get(), GhostSpiritRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.MOTHBOSS.get(), MothbossRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.PUTRID_ROSE.get(), PutridRoseRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.GHOST_ZOMBIE.get(), GhostZombieRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.NAMELESS.get(), NamelessRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.NAMELESS_PROJECTILE_FALL.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.NAMELESS_INVISIBLE_PROJECTILE.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.LINARA.get(), LinaraRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.PUPPET_OF_YIVA_NEMOR.get(), PuppetOfYivaNemorRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_1.get(), SaphyraDialog1Renderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_2.get(), SaphyraDialog2Renderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.MIRROR_BLADE_PROJECTILE.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.ROT_PROJECTILE.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.NAMELESS_SPAWN.get(), NamelessSpawnRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.MARLENE_HUMAN_FORM.get(), MarleneHumanFormRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_3.get(), SaphyraDialog3Renderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.MARLENE_HUMAN_FORM_DIALOG_2.get(), MarleneHumanFormDialog2Renderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.LINARA_HALLOWED_TOWER.get(), LinaraHallowedTowerRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.LINARA_HALLOWED_TOWER_2.get(), LinaraHallowedTower2Renderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SCORCHED.get(), ScorchedRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.INFESTED_WITCH.get(), InfestedWitchRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_SPAWN.get(), SaphyraSpawnRenderer::new);
      event.registerEntityRenderer((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_4.get(), SaphyraDialog4Renderer::new);
   }
}

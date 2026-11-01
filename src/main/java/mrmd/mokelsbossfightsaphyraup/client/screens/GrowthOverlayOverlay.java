package mrmd.mokelsbossfightsaphyraup.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc0Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc1Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc2Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc3Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc4Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc5Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.DevotionBarProc6Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.EnduranceOverlayProcedure2Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.EnduranceOverlayProcedure3Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.EnduranceOverlayProcedureProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.EnduranceOverlayUltimativeProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc0Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc2Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc3Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc4Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc5Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProc6Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefBarProcProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc0Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc1Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc2Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc3Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc4Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc5Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.ManicBarProc6Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc0Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc2Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc3Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc4Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc5Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProc6Procedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RottingBarProcProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent.Pre;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class GrowthOverlayOverlay {
   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public static void eventHandler(Pre event) {
      int w = event.getWindow().getGuiScaledWidth();
      int h = event.getWindow().getGuiScaledHeight();
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.getInstance().player;
      if (entity != null) {
         world = entity.level();
         x = entity.getX();
         y = entity.getY();
         z = entity.getZ();
      }

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (DevotionBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_bar.png"), w / 2 + -60, h / 2 + 10, 0.0F, 0.0F, 109, 12, 109, 12);
      }

      if (DevotionBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_bar.png"), w / 2 + -60, h / 2 + 19, 0.0F, 0.0F, 109, 12, 109, 12
            );
      }

      if (DevotionBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_bar.png"), w / 2 + -60, h / 2 + 28, 0.0F, 0.0F, 109, 12, 109, 12);
      }

      if (DevotionBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_bar.png"), w / 2 + -60, h / 2 + 37, 0.0F, 0.0F, 109, 12, 109, 12
            );
      }

      if (ManicBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_bar.png"), w / 2 + -60, h / 2 + 46, 0.0F, 0.0F, 109, 12, 109, 12);
      }

      if (RottingBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_bar.png"), w / 2 + -60, h / 2 + 55, 0.0F, 0.0F, 109, 12, 109, 12);
      }

      if (RottingBarProcProcedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part.png"), w / 2 + -47, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (RottingBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part.png"), w / 2 + -31, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (RottingBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part.png"), w / 2 + -15, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (RottingBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part.png"), w / 2 + 1, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (RottingBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part.png"), w / 2 + 17, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (RottingBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rotting_part_end.png"), w / 2 + 33, h / 2 + 53, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (GriefBarProc0Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_bar.png"), w / 2 + -60, h / 2 + 64, 0.0F, 0.0F, 109, 12, 109, 12);
      }

      if (GriefBarProcProcedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part.png"), w / 2 + -47, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (GriefBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part.png"), w / 2 + -31, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (GriefBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part.png"), w / 2 + -15, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (GriefBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part.png"), w / 2 + 1, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (GriefBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part.png"), w / 2 + 17, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (GriefBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/grief_part_end.png"), w / 2 + 33, h / 2 + 62, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc1Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part.png"), w / 2 + -47, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part.png"), w / 2 + -31, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part.png"), w / 2 + -15, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part.png"), w / 2 + 1, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part.png"), w / 2 + 17, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (ManicBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/manic_part_end.png"), w / 2 + 33, h / 2 + 44, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc1Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part.png"), w / 2 + -47, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part.png"), w / 2 + -31, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part.png"), w / 2 + -15, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part.png"), w / 2 + 1, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part.png"), w / 2 + 17, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/disgust_part_end.png"), w / 2 + 33, h / 2 + 26, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc1Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part.png"), w / 2 + -47, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part.png"), w / 2 + -31, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part.png"), w / 2 + -15, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part.png"), w / 2 + 1, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part.png"), w / 2 + 17, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/affection_part_end.png"), w / 2 + 33, h / 2 + 35, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc1Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part.png"), w / 2 + -47, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part.png"), w / 2 + -31, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part.png"), w / 2 + -15, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part.png"), w / 2 + 1, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part.png"), w / 2 + 17, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/devotion_part_end.png"), w / 2 + 33, h / 2 + 17, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc6Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(
               new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part_end.png"), w / 2 + 33, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16
            );
      }

      if (DevotionBarProc1Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part.png"), w / 2 + -47, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part.png"), w / 2 + -31, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part.png"), w / 2 + -15, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc4Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part.png"), w / 2 + 1, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (DevotionBarProc5Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/rooting_part.png"), w / 2 + 17, h / 2 + 8, 0.0F, 0.0F, 16, 16, 16, 16);
      }

      if (EnduranceOverlayUltimativeProcedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/guidashbar.png"), w / 2 + 93, h / 2 + 104, 0.0F, 0.0F, 7, 22, 7, 22);
      }

      if (EnduranceOverlayProcedure3Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/dashpart.png"), w / 2 + 94, h / 2 + 105, 0.0F, 0.0F, 5, 7, 5, 7);
      }

      if (EnduranceOverlayProcedureProcedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/dashpart3.png"), w / 2 + 94, h / 2 + 119, 0.0F, 0.0F, 5, 7, 5, 7);
      }

      if (EnduranceOverlayProcedure2Procedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(new ResourceLocation("mokels_bossfight_saphyra:textures/screens/dashpart2.png"), w / 2 + 94, h / 2 + 112, 0.0F, 0.0F, 5, 7, 5, 7);
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}

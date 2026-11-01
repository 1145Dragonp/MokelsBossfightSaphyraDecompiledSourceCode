package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.GhostZombieEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.GhostZombieLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.GhostZombieModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GhostZombieRenderer extends GeoEntityRenderer<GhostZombieEntity> {
   public GhostZombieRenderer(Context renderManager) {
      super(renderManager, new GhostZombieModel());
      this.shadowRadius = 0.7F;
      this.addRenderLayer(new GhostZombieLayer(this));
   }

   public RenderType getRenderType(GhostZombieEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<GhostZombieEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      GhostZombieEntity entity,
      BakedGeoModel model,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      boolean isReRender,
      float partialTick,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      float scale = 1.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }
}

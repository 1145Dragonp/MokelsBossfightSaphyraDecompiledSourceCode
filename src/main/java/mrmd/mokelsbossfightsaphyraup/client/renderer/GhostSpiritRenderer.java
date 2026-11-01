package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.GhostSpiritEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.GhostSpiritLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.GhostSpiritModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GhostSpiritRenderer extends GeoEntityRenderer<GhostSpiritEntity> {
   public GhostSpiritRenderer(Context renderManager) {
      super(renderManager, new GhostSpiritModel());
      this.shadowRadius = 0.5F;
      this.addRenderLayer(new GhostSpiritLayer(this));
   }

   public RenderType getRenderType(GhostSpiritEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<GhostSpiritEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      GhostSpiritEntity entity,
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

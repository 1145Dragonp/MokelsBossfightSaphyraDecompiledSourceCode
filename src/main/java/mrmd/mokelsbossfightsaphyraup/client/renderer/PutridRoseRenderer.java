package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.PutridRoseEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.PutridRoseLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.PutridRoseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PutridRoseRenderer extends GeoEntityRenderer<PutridRoseEntity> {
   public PutridRoseRenderer(Context renderManager) {
      super(renderManager, new PutridRoseModel());
      this.shadowRadius = 2.2F;
      this.addRenderLayer(new PutridRoseLayer(this));
   }

   public RenderType getRenderType(PutridRoseEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<PutridRoseEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      PutridRoseEntity entity,
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

   protected float getDeathMaxRotation(PutridRoseEntity entityLivingBaseIn) {
      return 0.0F;
   }
}

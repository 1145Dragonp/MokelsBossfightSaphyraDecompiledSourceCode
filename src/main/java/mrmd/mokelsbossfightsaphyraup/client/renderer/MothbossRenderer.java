package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.MothbossLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.MothbossModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MothbossRenderer extends GeoEntityRenderer<MothbossEntity> {
   public MothbossRenderer(Context renderManager) {
      super(renderManager, new MothbossModel());
      this.shadowRadius = 0.9F;
      this.addRenderLayer(new MothbossLayer(this));
   }

   public RenderType getRenderType(MothbossEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<MothbossEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      MothbossEntity entity,
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

   protected float getDeathMaxRotation(MothbossEntity entityLivingBaseIn) {
      return 0.0F;
   }
}

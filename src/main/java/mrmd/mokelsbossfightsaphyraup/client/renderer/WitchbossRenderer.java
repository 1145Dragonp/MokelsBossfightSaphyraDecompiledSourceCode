package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.WitchbossLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.WitchbossModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WitchbossRenderer extends GeoEntityRenderer<WitchbossEntity> {
   public WitchbossRenderer(Context renderManager) {
      super(renderManager, new WitchbossModel());
      this.shadowRadius = 0.7F;
      this.addRenderLayer(new WitchbossLayer(this));
   }

   public RenderType getRenderType(WitchbossEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<WitchbossEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      WitchbossEntity entity,
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
      float scale = 1.1F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(WitchbossEntity entityLivingBaseIn) {
      return 0.0F;
   }
}

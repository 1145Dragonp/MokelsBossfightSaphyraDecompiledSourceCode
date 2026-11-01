package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.PuppetOfYivaNemorEntity;
import mrmd.mokelsbossfightsaphyraup.entity.model.PuppetOfYivaNemorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PuppetOfYivaNemorRenderer extends GeoEntityRenderer<PuppetOfYivaNemorEntity> {
   public PuppetOfYivaNemorRenderer(Context renderManager) {
      super(renderManager, new PuppetOfYivaNemorModel());
      this.shadowRadius = 0.5F;
   }

   public RenderType getRenderType(PuppetOfYivaNemorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<PuppetOfYivaNemorEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      PuppetOfYivaNemorEntity entity,
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

   protected float getDeathMaxRotation(PuppetOfYivaNemorEntity entityLivingBaseIn) {
      return 0.0F;
   }
}

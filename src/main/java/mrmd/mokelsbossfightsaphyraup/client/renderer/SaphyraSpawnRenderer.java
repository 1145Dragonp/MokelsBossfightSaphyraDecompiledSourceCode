package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraSpawnEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.SaphyraSpawnLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.SaphyraSpawnModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SaphyraSpawnRenderer extends GeoEntityRenderer<SaphyraSpawnEntity> {
   public SaphyraSpawnRenderer(Context renderManager) {
      super(renderManager, new SaphyraSpawnModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new SaphyraSpawnLayer(this));
   }

   public RenderType getRenderType(SaphyraSpawnEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<SaphyraSpawnEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SaphyraSpawnEntity entity,
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

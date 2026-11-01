package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraHallowedTowerEntity;
import mrmd.mokelsbossfightsaphyraup.entity.model.LinaraHallowedTowerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LinaraHallowedTowerRenderer extends GeoEntityRenderer<LinaraHallowedTowerEntity> {
   public LinaraHallowedTowerRenderer(Context renderManager) {
      super(renderManager, new LinaraHallowedTowerModel());
      this.shadowRadius = 0.7F;
   }

   public RenderType getRenderType(LinaraHallowedTowerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<LinaraHallowedTowerEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      LinaraHallowedTowerEntity entity,
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

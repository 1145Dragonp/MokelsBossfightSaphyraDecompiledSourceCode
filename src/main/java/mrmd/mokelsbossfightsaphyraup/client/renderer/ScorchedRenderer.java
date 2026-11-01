package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.ScorchedEntity;
import mrmd.mokelsbossfightsaphyraup.entity.model.ScorchedModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ScorchedRenderer extends GeoEntityRenderer<ScorchedEntity> {
   public ScorchedRenderer(Context renderManager) {
      super(renderManager, new ScorchedModel());
      this.shadowRadius = 0.4F;
   }

   public RenderType getRenderType(ScorchedEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<ScorchedEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ScorchedEntity entity,
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

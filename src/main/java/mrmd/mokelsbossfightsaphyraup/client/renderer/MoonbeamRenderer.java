package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.MoonbeamEntity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.MoonbeamLayer;
import mrmd.mokelsbossfightsaphyraup.entity.model.MoonbeamModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MoonbeamRenderer extends GeoEntityRenderer<MoonbeamEntity> {
   public MoonbeamRenderer(Context renderManager) {
      super(renderManager, new MoonbeamModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new MoonbeamLayer(this));
   }

   public RenderType getRenderType(MoonbeamEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<MoonbeamEntity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      MoonbeamEntity entity,
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

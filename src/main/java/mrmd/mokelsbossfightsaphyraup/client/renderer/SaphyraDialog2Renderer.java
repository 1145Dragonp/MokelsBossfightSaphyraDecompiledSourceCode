package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.model.SaphyraDialog2Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SaphyraDialog2Renderer extends GeoEntityRenderer<SaphyraDialog2Entity> {
   public SaphyraDialog2Renderer(Context renderManager) {
      super(renderManager, new SaphyraDialog2Model());
      this.shadowRadius = 0.7F;
   }

   public RenderType getRenderType(SaphyraDialog2Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<SaphyraDialog2Entity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SaphyraDialog2Entity entity,
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

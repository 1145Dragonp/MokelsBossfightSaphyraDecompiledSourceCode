package mrmd.mokelsbossfightsaphyraup.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mrmd.mokelsbossfightsaphyraup.entity.MarleneHumanFormDialog2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.layer.MarleneHumanFormDialog2Layer;
import mrmd.mokelsbossfightsaphyraup.entity.model.MarleneHumanFormDialog2Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MarleneHumanFormDialog2Renderer extends GeoEntityRenderer<MarleneHumanFormDialog2Entity> {
   public MarleneHumanFormDialog2Renderer(Context renderManager) {
      super(renderManager, new MarleneHumanFormDialog2Model());
      this.shadowRadius = 0.8F;
      this.addRenderLayer(new MarleneHumanFormDialog2Layer(this));
   }

   public RenderType getRenderType(MarleneHumanFormDialog2Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(((software.bernie.geckolib.renderer.GeoRenderer<MarleneHumanFormDialog2Entity>) this).getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      MarleneHumanFormDialog2Entity entity,
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

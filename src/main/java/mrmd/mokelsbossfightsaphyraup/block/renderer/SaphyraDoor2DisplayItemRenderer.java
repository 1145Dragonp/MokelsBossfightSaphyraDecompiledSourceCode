package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor2DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor2DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SaphyraDoor2DisplayItemRenderer extends GeoItemRenderer<SaphyraDoor2DisplayItem> {
   public SaphyraDoor2DisplayItemRenderer() {
      super(new SaphyraDoor2DisplayModel());
   }

   public RenderType getRenderType(SaphyraDoor2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

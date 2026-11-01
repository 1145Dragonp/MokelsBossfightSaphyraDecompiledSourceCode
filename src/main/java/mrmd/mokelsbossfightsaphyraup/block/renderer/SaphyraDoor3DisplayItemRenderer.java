package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor3DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor3DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SaphyraDoor3DisplayItemRenderer extends GeoItemRenderer<SaphyraDoor3DisplayItem> {
   public SaphyraDoor3DisplayItemRenderer() {
      super(new SaphyraDoor3DisplayModel());
   }

   public RenderType getRenderType(SaphyraDoor3DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

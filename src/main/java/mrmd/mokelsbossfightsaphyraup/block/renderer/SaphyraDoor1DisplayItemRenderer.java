package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor1DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor1DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SaphyraDoor1DisplayItemRenderer extends GeoItemRenderer<SaphyraDoor1DisplayItem> {
   public SaphyraDoor1DisplayItemRenderer() {
      super(new SaphyraDoor1DisplayModel());
   }

   public RenderType getRenderType(SaphyraDoor1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

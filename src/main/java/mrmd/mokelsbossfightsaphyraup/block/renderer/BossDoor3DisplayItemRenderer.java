package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.BossDoor3DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoor3DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BossDoor3DisplayItemRenderer extends GeoItemRenderer<BossDoor3DisplayItem> {
   public BossDoor3DisplayItemRenderer() {
      super(new BossDoor3DisplayModel());
   }

   public RenderType getRenderType(BossDoor3DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

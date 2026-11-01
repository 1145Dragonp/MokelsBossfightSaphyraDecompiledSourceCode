package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.BossDoor1DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoor1DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BossDoor1DisplayItemRenderer extends GeoItemRenderer<BossDoor1DisplayItem> {
   public BossDoor1DisplayItemRenderer() {
      super(new BossDoor1DisplayModel());
   }

   public RenderType getRenderType(BossDoor1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

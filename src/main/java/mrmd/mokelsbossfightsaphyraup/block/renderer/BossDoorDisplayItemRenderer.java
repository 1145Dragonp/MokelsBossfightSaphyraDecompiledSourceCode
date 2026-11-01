package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.BossDoorDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoorDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BossDoorDisplayItemRenderer extends GeoItemRenderer<BossDoorDisplayItem> {
   public BossDoorDisplayItemRenderer() {
      super(new BossDoorDisplayModel());
   }

   public RenderType getRenderType(BossDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

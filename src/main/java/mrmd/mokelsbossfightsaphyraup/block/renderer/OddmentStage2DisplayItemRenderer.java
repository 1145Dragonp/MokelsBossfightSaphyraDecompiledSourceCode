package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.OddmentStage2DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.OddmentStage2DisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OddmentStage2DisplayItemRenderer extends GeoItemRenderer<OddmentStage2DisplayItem> {
   public OddmentStage2DisplayItemRenderer() {
      super(new OddmentStage2DisplayModel());
   }

   public RenderType getRenderType(OddmentStage2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.OddmentHallowedTowerDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.OddmentHallowedTowerDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OddmentHallowedTowerDisplayItemRenderer extends GeoItemRenderer<OddmentHallowedTowerDisplayItem> {
   public OddmentHallowedTowerDisplayItemRenderer() {
      super(new OddmentHallowedTowerDisplayModel());
   }

   public RenderType getRenderType(OddmentHallowedTowerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.LyiorStatueDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LyiorStatueDisplayItemRenderer extends GeoItemRenderer<LyiorStatueDisplayItem> {
   public LyiorStatueDisplayItemRenderer() {
      super(new LyiorStatueDisplayModel());
   }

   public RenderType getRenderType(LyiorStatueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueAktivatedDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.model.LyiorStatueAktivatedDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LyiorStatueAktivatedDisplayItemRenderer extends GeoItemRenderer<LyiorStatueAktivatedDisplayItem> {
   public LyiorStatueAktivatedDisplayItemRenderer() {
      super(new LyiorStatueAktivatedDisplayModel());
   }

   public RenderType getRenderType(LyiorStatueAktivatedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

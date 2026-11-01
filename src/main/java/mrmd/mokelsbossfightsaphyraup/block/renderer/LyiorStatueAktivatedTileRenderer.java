package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueAktivatedTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.LyiorStatueAktivatedBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LyiorStatueAktivatedTileRenderer extends GeoBlockRenderer<LyiorStatueAktivatedTileEntity> {
   public LyiorStatueAktivatedTileRenderer() {
      super(new LyiorStatueAktivatedBlockModel());
   }

   public RenderType getRenderType(LyiorStatueAktivatedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

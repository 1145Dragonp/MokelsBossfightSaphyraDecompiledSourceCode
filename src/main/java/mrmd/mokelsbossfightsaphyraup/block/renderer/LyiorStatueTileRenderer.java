package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.LyiorStatueBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LyiorStatueTileRenderer extends GeoBlockRenderer<LyiorStatueTileEntity> {
   public LyiorStatueTileRenderer() {
      super(new LyiorStatueBlockModel());
   }

   public RenderType getRenderType(LyiorStatueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

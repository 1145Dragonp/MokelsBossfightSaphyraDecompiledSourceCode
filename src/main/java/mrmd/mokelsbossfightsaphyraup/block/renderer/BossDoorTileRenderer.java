package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoorTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoorBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BossDoorTileRenderer extends GeoBlockRenderer<BossDoorTileEntity> {
   public BossDoorTileRenderer() {
      super(new BossDoorBlockModel());
   }

   public RenderType getRenderType(BossDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

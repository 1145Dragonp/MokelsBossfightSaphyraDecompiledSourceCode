package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor3TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoor3BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BossDoor3TileRenderer extends GeoBlockRenderer<BossDoor3TileEntity> {
   public BossDoor3TileRenderer() {
      super(new BossDoor3BlockModel());
   }

   public RenderType getRenderType(BossDoor3TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

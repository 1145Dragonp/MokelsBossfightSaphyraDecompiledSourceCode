package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor1TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.BossDoor1BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BossDoor1TileRenderer extends GeoBlockRenderer<BossDoor1TileEntity> {
   public BossDoor1TileRenderer() {
      super(new BossDoor1BlockModel());
   }

   public RenderType getRenderType(BossDoor1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentStage2TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.OddmentStage2BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OddmentStage2TileRenderer extends GeoBlockRenderer<OddmentStage2TileEntity> {
   public OddmentStage2TileRenderer() {
      super(new OddmentStage2BlockModel());
   }

   public RenderType getRenderType(OddmentStage2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

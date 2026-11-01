package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor2TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor2BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SaphyraDoor2TileRenderer extends GeoBlockRenderer<SaphyraDoor2TileEntity> {
   public SaphyraDoor2TileRenderer() {
      super(new SaphyraDoor2BlockModel());
   }

   public RenderType getRenderType(SaphyraDoor2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor1TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor1BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SaphyraDoor1TileRenderer extends GeoBlockRenderer<SaphyraDoor1TileEntity> {
   public SaphyraDoor1TileRenderer() {
      super(new SaphyraDoor1BlockModel());
   }

   public RenderType getRenderType(SaphyraDoor1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

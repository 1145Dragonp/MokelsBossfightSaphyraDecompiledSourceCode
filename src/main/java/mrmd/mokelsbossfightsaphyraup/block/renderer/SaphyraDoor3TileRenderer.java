package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor3TileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.SaphyraDoor3BlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SaphyraDoor3TileRenderer extends GeoBlockRenderer<SaphyraDoor3TileEntity> {
   public SaphyraDoor3TileRenderer() {
      super(new SaphyraDoor3BlockModel());
   }

   public RenderType getRenderType(SaphyraDoor3TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

package mrmd.mokelsbossfightsaphyraup.block.renderer;

import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentHallowedTowerTileEntity;
import mrmd.mokelsbossfightsaphyraup.block.model.OddmentHallowedTowerBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OddmentHallowedTowerTileRenderer extends GeoBlockRenderer<OddmentHallowedTowerTileEntity> {
   public OddmentHallowedTowerTileRenderer() {
      super(new OddmentHallowedTowerBlockModel());
   }

   public RenderType getRenderType(OddmentHallowedTowerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }
}

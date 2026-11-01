package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentHallowedTowerTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OddmentHallowedTowerBlockModel extends GeoModel<OddmentHallowedTowerTileEntity> {
   public ResourceLocation getAnimationResource(OddmentHallowedTowerTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/losthopestage2.animation.json");
   }

   public ResourceLocation getModelResource(OddmentHallowedTowerTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/losthopestage2.geo.json");
   }

   public ResourceLocation getTextureResource(OddmentHallowedTowerTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/losthopetexture.png");
   }
}

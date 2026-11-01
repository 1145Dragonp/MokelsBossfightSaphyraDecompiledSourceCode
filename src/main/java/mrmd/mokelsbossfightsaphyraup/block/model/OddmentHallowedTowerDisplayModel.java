package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.OddmentHallowedTowerDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OddmentHallowedTowerDisplayModel extends GeoModel<OddmentHallowedTowerDisplayItem> {
   public ResourceLocation getAnimationResource(OddmentHallowedTowerDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/losthopestage2.animation.json");
   }

   public ResourceLocation getModelResource(OddmentHallowedTowerDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/losthopestage2.geo.json");
   }

   public ResourceLocation getTextureResource(OddmentHallowedTowerDisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/losthopetexture.png");
   }
}

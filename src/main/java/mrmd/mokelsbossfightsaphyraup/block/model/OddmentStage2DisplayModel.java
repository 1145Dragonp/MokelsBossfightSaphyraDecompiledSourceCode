package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.OddmentStage2DisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OddmentStage2DisplayModel extends GeoModel<OddmentStage2DisplayItem> {
   public ResourceLocation getAnimationResource(OddmentStage2DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/losthopestage2.animation.json");
   }

   public ResourceLocation getModelResource(OddmentStage2DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/losthopestage2.geo.json");
   }

   public ResourceLocation getTextureResource(OddmentStage2DisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/losthopetexture.png");
   }
}

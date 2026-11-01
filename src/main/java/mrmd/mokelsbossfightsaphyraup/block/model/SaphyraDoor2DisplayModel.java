package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor2DisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraDoor2DisplayModel extends GeoModel<SaphyraDoor2DisplayItem> {
   public ResourceLocation getAnimationResource(SaphyraDoor2DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraDoor2DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraDoor2DisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexturesaphyra.png");
   }
}

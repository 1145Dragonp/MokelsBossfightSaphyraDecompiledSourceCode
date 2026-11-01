package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor1DisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraDoor1DisplayModel extends GeoModel<SaphyraDoor1DisplayItem> {
   public ResourceLocation getAnimationResource(SaphyraDoor1DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraDoor1DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraDoor1DisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexturesaphyra.png");
   }
}

package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor3DisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraDoor3DisplayModel extends GeoModel<SaphyraDoor3DisplayItem> {
   public ResourceLocation getAnimationResource(SaphyraDoor3DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgateopen.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraDoor3DisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgateopen.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraDoor3DisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexturesaphyra.png");
   }
}

package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.BossDoorDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BossDoorDisplayModel extends GeoModel<BossDoorDisplayItem> {
   public ResourceLocation getAnimationResource(BossDoorDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(BossDoorDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(BossDoorDisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexture.png");
   }
}

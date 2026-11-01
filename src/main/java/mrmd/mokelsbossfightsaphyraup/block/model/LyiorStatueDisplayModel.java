package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LyiorStatueDisplayModel extends GeoModel<LyiorStatueDisplayItem> {
   public ResourceLocation getAnimationResource(LyiorStatueDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/lyiorstatue.animation.json");
   }

   public ResourceLocation getModelResource(LyiorStatueDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/lyiorstatue.geo.json");
   }

   public ResourceLocation getTextureResource(LyiorStatueDisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/lyiorstatuetexture.png");
   }
}

package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueAktivatedDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LyiorStatueAktivatedDisplayModel extends GeoModel<LyiorStatueAktivatedDisplayItem> {
   public ResourceLocation getAnimationResource(LyiorStatueAktivatedDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/lyiorstatue.animation.json");
   }

   public ResourceLocation getModelResource(LyiorStatueAktivatedDisplayItem animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/lyiorstatue.geo.json");
   }

   public ResourceLocation getTextureResource(LyiorStatueAktivatedDisplayItem entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/lyiorstatueanimatedtexture.png");
   }
}

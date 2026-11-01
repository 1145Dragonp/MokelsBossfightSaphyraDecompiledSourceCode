package mrmd.mokelsbossfightsaphyraup.item.model;

import mrmd.mokelsbossfightsaphyraup.item.SaphyrasCapeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyrasCapeModel extends GeoModel<SaphyrasCapeItem> {
   public ResourceLocation getAnimationResource(SaphyrasCapeItem object) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/capesaphyraanimated.animation.json");
   }

   public ResourceLocation getModelResource(SaphyrasCapeItem object) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/capesaphyraanimated.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyrasCapeItem object) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/item/capesaphyratexture.png");
   }
}

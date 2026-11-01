package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.MoonbeamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MoonbeamModel extends GeoModel<MoonbeamEntity> {
   public ResourceLocation getAnimationResource(MoonbeamEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/moonbeam.animation.json");
   }

   public ResourceLocation getModelResource(MoonbeamEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/moonbeam.geo.json");
   }

   public ResourceLocation getTextureResource(MoonbeamEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }
}

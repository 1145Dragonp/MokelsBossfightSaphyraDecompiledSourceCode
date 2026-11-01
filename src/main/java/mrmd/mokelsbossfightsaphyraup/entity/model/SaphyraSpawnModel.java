package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.SaphyraSpawnEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraSpawnModel extends GeoModel<SaphyraSpawnEntity> {
   public ResourceLocation getAnimationResource(SaphyraSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/moonbeam.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/moonbeam.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }
}

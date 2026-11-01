package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.NamelessSpawnEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NamelessSpawnModel extends GeoModel<NamelessSpawnEntity> {
   public ResourceLocation getAnimationResource(NamelessSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/knightboss.animation.json");
   }

   public ResourceLocation getModelResource(NamelessSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/knightboss.geo.json");
   }

   public ResourceLocation getTextureResource(NamelessSpawnEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }
}

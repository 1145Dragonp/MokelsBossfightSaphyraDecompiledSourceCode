package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.InfestedWitchEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InfestedWitchModel extends GeoModel<InfestedWitchEntity> {
   public ResourceLocation getAnimationResource(InfestedWitchEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/scream.animation.json");
   }

   public ResourceLocation getModelResource(InfestedWitchEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/scream.geo.json");
   }

   public ResourceLocation getTextureResource(InfestedWitchEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }
}

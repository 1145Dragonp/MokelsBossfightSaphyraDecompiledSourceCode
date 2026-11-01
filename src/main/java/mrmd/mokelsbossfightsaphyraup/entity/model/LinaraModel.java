package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.LinaraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LinaraModel extends GeoModel<LinaraEntity> {
   public ResourceLocation getAnimationResource(LinaraEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/marne.animation.json");
   }

   public ResourceLocation getModelResource(LinaraEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/marne.geo.json");
   }

   public ResourceLocation getTextureResource(LinaraEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(LinaraEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

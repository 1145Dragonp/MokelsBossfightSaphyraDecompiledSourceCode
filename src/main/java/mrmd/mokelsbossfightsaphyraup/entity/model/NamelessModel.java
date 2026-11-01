package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class NamelessModel extends GeoModel<NamelessEntity> {
   public ResourceLocation getAnimationResource(NamelessEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/knightboss.animation.json");
   }

   public ResourceLocation getModelResource(NamelessEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/knightboss.geo.json");
   }

   public ResourceLocation getTextureResource(NamelessEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(NamelessEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

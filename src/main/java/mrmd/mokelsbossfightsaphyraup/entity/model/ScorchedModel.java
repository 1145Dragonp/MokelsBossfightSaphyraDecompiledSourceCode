package mrmd.mokelsbossfightsaphyraup.entity.model;

import mrmd.mokelsbossfightsaphyraup.entity.ScorchedEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ScorchedModel extends GeoModel<ScorchedEntity> {
   public ResourceLocation getAnimationResource(ScorchedEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/scorched.animation.json");
   }

   public ResourceLocation getModelResource(ScorchedEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/scorched.geo.json");
   }

   public ResourceLocation getTextureResource(ScorchedEntity entity) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ScorchedEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

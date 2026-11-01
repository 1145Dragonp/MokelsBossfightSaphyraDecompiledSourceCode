package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LyiorStatueBlockModel extends GeoModel<LyiorStatueTileEntity> {
   public ResourceLocation getAnimationResource(LyiorStatueTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/lyiorstatue.animation.json");
   }

   public ResourceLocation getModelResource(LyiorStatueTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/lyiorstatue.geo.json");
   }

   public ResourceLocation getTextureResource(LyiorStatueTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/lyiorstatuetexture.png");
   }
}

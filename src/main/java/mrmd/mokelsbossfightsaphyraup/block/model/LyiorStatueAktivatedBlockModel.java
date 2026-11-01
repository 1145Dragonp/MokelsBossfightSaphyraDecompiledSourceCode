package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.LyiorStatueAktivatedTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LyiorStatueAktivatedBlockModel extends GeoModel<LyiorStatueAktivatedTileEntity> {
   public ResourceLocation getAnimationResource(LyiorStatueAktivatedTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/lyiorstatue.animation.json");
   }

   public ResourceLocation getModelResource(LyiorStatueAktivatedTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/lyiorstatue.geo.json");
   }

   public ResourceLocation getTextureResource(LyiorStatueAktivatedTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/lyiorstatueanimatedtexture.png");
   }
}

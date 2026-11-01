package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.OddmentStage2TileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OddmentStage2BlockModel extends GeoModel<OddmentStage2TileEntity> {
   public ResourceLocation getAnimationResource(OddmentStage2TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/losthopestage2.animation.json");
   }

   public ResourceLocation getModelResource(OddmentStage2TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/losthopestage2.geo.json");
   }

   public ResourceLocation getTextureResource(OddmentStage2TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/losthopetexture.png");
   }
}

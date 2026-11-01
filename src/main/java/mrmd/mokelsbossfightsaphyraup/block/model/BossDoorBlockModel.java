package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoorTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BossDoorBlockModel extends GeoModel<BossDoorTileEntity> {
   public ResourceLocation getAnimationResource(BossDoorTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(BossDoorTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(BossDoorTileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexture.png");
   }
}

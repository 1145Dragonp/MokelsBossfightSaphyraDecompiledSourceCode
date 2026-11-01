package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor1TileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BossDoor1BlockModel extends GeoModel<BossDoor1TileEntity> {
   public ResourceLocation getAnimationResource(BossDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(BossDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(BossDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexture.png");
   }
}

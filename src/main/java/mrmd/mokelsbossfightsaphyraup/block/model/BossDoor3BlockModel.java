package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.BossDoor3TileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BossDoor3BlockModel extends GeoModel<BossDoor3TileEntity> {
   public ResourceLocation getAnimationResource(BossDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgateopen.animation.json");
   }

   public ResourceLocation getModelResource(BossDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgateopen.geo.json");
   }

   public ResourceLocation getTextureResource(BossDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexture.png");
   }
}

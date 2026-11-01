package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor1TileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraDoor1BlockModel extends GeoModel<SaphyraDoor1TileEntity> {
   public ResourceLocation getAnimationResource(SaphyraDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgate.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgate.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraDoor1TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexturesaphyra.png");
   }
}

package mrmd.mokelsbossfightsaphyraup.block.model;

import mrmd.mokelsbossfightsaphyraup.block.entity.SaphyraDoor3TileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SaphyraDoor3BlockModel extends GeoModel<SaphyraDoor3TileEntity> {
   public ResourceLocation getAnimationResource(SaphyraDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "animations/bossgateopen.animation.json");
   }

   public ResourceLocation getModelResource(SaphyraDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "geo/bossgateopen.geo.json");
   }

   public ResourceLocation getTextureResource(SaphyraDoor3TileEntity animatable) {
      return new ResourceLocation("mokels_bossfight_saphyra", "textures/block/bossgatetexturesaphyra.png");
   }
}

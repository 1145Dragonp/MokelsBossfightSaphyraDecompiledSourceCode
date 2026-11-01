package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.item.SaphyrasCapeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoItem;

public class SaphyrasCapeChestplateTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 2, false, false));
            }

            if (itemstack.getItem() instanceof SaphyrasCapeItem armor && armor instanceof GeoItem) {
               itemstack.getOrCreateTag().putString("geckoAnim", "idle");
            }
         }
      }
   }
}

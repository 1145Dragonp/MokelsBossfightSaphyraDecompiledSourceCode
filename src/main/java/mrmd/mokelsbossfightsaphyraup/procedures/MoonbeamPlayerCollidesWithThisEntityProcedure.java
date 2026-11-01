package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MoonbeamPlayerCollidesWithThisEntityProcedure {
   public static void execute(LevelAccessor world, Entity sourceentity) {
      if (sourceentity != null) {
         sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 1.0F);
      }
   }
}

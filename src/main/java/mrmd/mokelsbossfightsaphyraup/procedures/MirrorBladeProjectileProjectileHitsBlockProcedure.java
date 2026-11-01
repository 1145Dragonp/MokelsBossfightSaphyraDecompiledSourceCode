package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.world.entity.Entity;

public class MirrorBladeProjectileProjectileHitsBlockProcedure {
   public static void execute(Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}

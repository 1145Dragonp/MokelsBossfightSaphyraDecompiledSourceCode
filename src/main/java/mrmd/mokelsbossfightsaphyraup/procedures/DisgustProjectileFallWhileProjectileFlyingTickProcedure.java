package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class DisgustProjectileFallWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         MokelsBossfightSaphyraMod.queueServerWork(
            1,
            () -> {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.PUKE_PARTICLE.get(),
                     immediatesourceentity.getX(),
                     immediatesourceentity.getY(),
                     immediatesourceentity.getZ(),
                     3,
                     0.1,
                     0.1,
                     0.1,
                     0.01
                  );
               }
            }
         );
         MokelsBossfightSaphyraMod.queueServerWork(10, () -> immediatesourceentity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0)));
      }
   }
}

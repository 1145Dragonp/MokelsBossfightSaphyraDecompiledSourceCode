package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class MoonbeamOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
               entity.getX(),
               entity.getY(),
               entity.getZ(),
               2,
               0.1,
               0.1,
               0.1,
               0.01
            );
         }

         MokelsBossfightSaphyraMod.queueServerWork(60, () -> {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && entity.isAlive()) {
               entity.setDeltaMovement(new Vec3(0.5 * entity.getLookAngle().x, 0.5 * entity.getLookAngle().y, 0.5 * entity.getLookAngle().z));
            }
         });
      }
   }
}

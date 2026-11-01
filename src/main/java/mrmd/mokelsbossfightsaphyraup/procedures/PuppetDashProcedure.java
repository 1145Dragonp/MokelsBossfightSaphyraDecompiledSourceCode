package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class PuppetDashProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            entity.setDeltaMovement(new Vec3(-1.0 * entity.getLookAngle().x, 0.01, -1.0 * entity.getLookAngle().z));
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.POOF, entity.getX(), entity.getY(), entity.getZ(), 20, 0.1, 0.1, 0.1, 0.1);
            }
         }
      }
   }
}

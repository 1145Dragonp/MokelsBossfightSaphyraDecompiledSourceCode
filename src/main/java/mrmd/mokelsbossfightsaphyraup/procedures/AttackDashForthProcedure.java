package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AttackDashForthProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.POOF, entity.getX(), entity.getY(), entity.getZ(), 20, 0.2, 0.2, 0.2, 0.05);
         }

         entity.setDeltaMovement(new Vec3(0.0, 1.0, 0.0));
         MokelsBossfightSaphyraMod.queueServerWork(
            2,
            () -> entity.setDeltaMovement(
                  new Vec3(
                     ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - entity.getX()) * 0.25
                        - ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX() - entity.getX()) * 0.15,
                     ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY() - entity.getY()) * 0.25
                        - ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() - entity.getY()) * 0.15
                        + 0.15,
                     ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() - entity.getZ()) * 0.25
                        - ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.15
                  )
               )
         );
      }
   }
}

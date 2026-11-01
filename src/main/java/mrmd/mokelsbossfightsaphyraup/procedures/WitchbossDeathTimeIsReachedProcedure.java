package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class WitchbossDeathTimeIsReachedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.MOTHBOSS.get())
               .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(entity.getYRot());
               entityToSpawn.setYBodyRot(entity.getYRot());
               entityToSpawn.setYHeadRot(entity.getYRot());
               entityToSpawn.setXRot(entity.getXRot());
               entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(
               (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
               entity.getX(),
               entity.getY(),
               entity.getZ(),
               800,
               1.0,
               2.0,
               1.0,
               0.05
            );
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SwordTearAndDropletEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (world.getLevelData().isThundering()) {
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), sourceentity), 15.0F);
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                  entity.getX(),
                  1.0 + entity.getY(),
                  entity.getZ(),
                  30,
                  0.2,
                  0.2,
                  0.2,
                  0.03
               );
            }
         } else if (world.getLevelData().isRaining()) {
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), sourceentity), 7.5F);
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                  entity.getX(),
                  1.0 + entity.getY(),
                  entity.getZ(),
                  30,
                  0.2,
                  0.2,
                  0.2,
                  0.03
               );
            }
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MirrorBladeProjectileWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.setNoGravity(true);
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.GOLDEN_PARTICLE.get(), x, y, z, 3, 0.1, 0.1, 0.1, 0.05);
         }

         MokelsBossfightSaphyraMod.queueServerWork(
            20,
            () -> {
               if (immediatesourceentity.isAlive()) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }

                     if (!(entityiterator instanceof Player) && entityiterator instanceof LivingEntity) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), immediatesourceentity), 10.0F
                        );
                     }

                     for (int index0 = 0; index0 < 2; index0++) {
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(
                              (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.GOLDEN_PARTICLE.get(),
                              immediatesourceentity.getX(),
                              immediatesourceentity.getY(),
                              immediatesourceentity.getZ(),
                              100,
                              1.5,
                              1.5,
                              1.5,
                              0.05
                           );
                        }
                     }
                  }
               }
            }
         );
      }
   }
}

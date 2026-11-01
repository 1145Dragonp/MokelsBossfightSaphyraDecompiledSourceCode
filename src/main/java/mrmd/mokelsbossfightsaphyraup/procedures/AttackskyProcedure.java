package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectilefallEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackskyProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof MothbossEntity) {
               ((MothbossEntity)entity).setAnimation("attacksky");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 90, 100, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               25,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt3) || !_livEnt3.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                     && entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiterator instanceof MothbossEntity) && entityiterator instanceof LivingEntity) {
                           if (world instanceof ServerLevel _level) {
                              _level.sendParticles(
                                 (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                 entity.getX(),
                                 1.0 + entity.getY(),
                                 entity.getZ(),
                                 70,
                                 0.1,
                                 0.2,
                                 0.1,
                                 0.04
                              );
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt14 = (LivingEntity)entityiterator;
                              if (_livEnt14.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                 continue;
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entityx = (LivingEntity)entityiterator;
                              if (!_entityx.level().isClientSide()) {
                                 _entityx.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 25, 10, false, false));
                              }
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(
                              25,
                              () -> {
                                 if (entity.isAlive()) {
                                    for (int index0 = 0; index0 < 8; index0++) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                         .get(),
                                                      level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   entityToSpawn.setPierceLevel(piercing);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 14.0F, 0, (byte)1);
                                          _entityToSpawn.setPos(entityiterator.getX(), -4.0 + entityiterator.getY(), entityiterator.getZ());
                                          _entityToSpawn.shoot(0.0, 90.0, 0.0, 1.0F, 7.5F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }
                                    }
                                 }
                              }
                           );
                        }
                     }
                  }
               }
            );
         }
      }
   }
}

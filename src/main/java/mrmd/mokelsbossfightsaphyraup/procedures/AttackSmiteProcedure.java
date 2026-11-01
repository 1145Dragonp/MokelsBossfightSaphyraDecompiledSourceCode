package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectilefallEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
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

public class AttackSmiteProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof MothbossEntity) {
               ((MothbossEntity)entity).setAnimation("attacksmite");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 100, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               27,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt3) || !_livEnt3.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                     && entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiterator instanceof MothbossEntity) && entityiterator instanceof LivingEntity) {
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
                                 _entityToSpawn.setPos(entityiterator.getX(), 6.0 + entityiterator.getY(), entityiterator.getZ());
                                 _entityToSpawn.shoot(0.0, -90.0, 0.0, 1.0F, 20.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           }
                        }
                     }
                  }
               }
            );
         }
      }
   }
}

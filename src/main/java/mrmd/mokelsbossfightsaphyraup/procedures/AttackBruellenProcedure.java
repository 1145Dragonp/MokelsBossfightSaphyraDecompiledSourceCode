package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessInvisibleProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraftforge.registries.ForgeRegistries;

public class AttackBruellenProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof NamelessEntity) {
               ((NamelessEntity)entity).setAnimation("attackbrüllen");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 110, 100, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               26,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt3) || !_livEnt3.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                     && entity.isAlive()) {
                     if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                           _level.playSound(
                              null,
                              BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelessscream")),
                              SoundSource.HOSTILE,
                              2.0F,
                              1.0F
                           );
                        } else {
                           _level.playLocalSound(
                              entity.getX(),
                              entity.getY(),
                              entity.getZ(),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelessscream")),
                              SoundSource.HOSTILE,
                              2.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           600,
                           8.0,
                           0.5,
                           8.0,
                           0.01
                        );
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           300,
                           8.0,
                           0.5,
                           8.0,
                           0.01
                        );
                     }

                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiterator instanceof NamelessEntity) && entityiterator instanceof LivingEntity) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt22 = (LivingEntity)entityiterator;
                              if (_livEnt22.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                 continue;
                              }
                           }

                           entityiterator.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 14.0F
                           );
                           double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                                       MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                 .Rotting
                              + 40.0;
                           entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.Rotting = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        }
                     }

                     for (int index0 = 0; index0 < 8; index0++) {
                        if ((!(entity instanceof LivingEntity _livEnt26) || !_livEnt26.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                           && world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new NamelessInvisibleProjectileEntity(
                                       (EntityType<? extends NamelessInvisibleProjectileEntity>)MokelsBossfightSaphyraModEntities.NAMELESS_INVISIBLE_PROJECTILE
                                          .get(),
                                       level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 0.0F, 0);
                           _entityToSpawn.setPos(entity.getX(), 2.2 + entity.getY(), entity.getZ());
                           _entityToSpawn.shoot(0.0, 90.0, 0.0, 1.0F, 30.0F);
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

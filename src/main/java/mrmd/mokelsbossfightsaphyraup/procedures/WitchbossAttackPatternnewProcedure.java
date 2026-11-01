package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectilefallEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WitchbossAttackPatternnewProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0 && entity.isAlive()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.HARM, 6, 1, false, false));
            }

            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.MOONBEAM.get())
                  .spawn(_level, BlockPos.containing(x, 1.0 + y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:witchbossfighttheme")),
                     SoundSource.MUSIC,
                     3.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:witchbossfighttheme")),
                     SoundSource.MUSIC,
                     3.0F,
                     1.0F,
                     false
                  );
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 100.0) {
            if (Math.random() <= 0.4) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("slashattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     26,
                     () -> {
                        if (entity.isAlive()) {
                           Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F
                                 );
                              }
                           }

                           if (world instanceof Level _levelxx) {
                              if (!_levelxx.isClientSide()) {
                                 _levelxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    2.0F,
                                    1.0F
                                 );
                              } else {
                                 _levelxx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    2.0F,
                                    1.0F,
                                    false
                                 );
                              }
                           }

                           if (world instanceof ServerLevel _levelx) {
                              _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 40, 1.0, 0.2, 1.0, 0.01);
                           }
                        }
                     }
                  );
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("clawattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  32,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 16.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof Level _levelx) {
                           if (!_levelx.isClientSide()) {
                              _levelx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F
                              );
                           } else {
                              _levelx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelxx) {
                           _levelxx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                        }
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 180.0) {
            if (Math.random() <= 0.4) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("rainattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 55, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     10,
                     () -> {
                        for (int index0 = 0; index0 < 2; index0++) {
                           MokelsBossfightSaphyraMod.queueServerWork(
                              1,
                              () -> {
                                 if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                   .get(),
                                                level
                                             );
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, 6.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                    _entityToSpawn.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                   .get(),
                                                level
                                             );
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, 6.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                    _entityToSpawn.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    1,
                                    () -> {
                                       if (world instanceof ServerLevel projectileLevelxx) {
                                          Projectile _entityToSpawnxx = (new Object() {
                                                public Projectile getArrow(Level level, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                         .get(),
                                                      level
                                                   );
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevelxx, 6.0F, 1);
                                          _entityToSpawnxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                          _entityToSpawnxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                          projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                       }

                                       if (world instanceof ServerLevel projectileLevelx) {
                                          Projectile _entityToSpawnx = (new Object() {
                                                public Projectile getArrow(Level level, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                         .get(),
                                                      level
                                                   );
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevelx, 6.0F, 1);
                                          _entityToSpawnx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                          _entityToSpawnx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                          projectileLevelx.addFreshEntity(_entityToSpawnx);
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          1,
                                          () -> {
                                             if (world instanceof ServerLevel projectileLevelxxxx) {
                                                Projectile _entityToSpawnxxxx = (new Object() {
                                                      public Projectile getArrow(Level level, float damage, int knockback) {
                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                               .get(),
                                                            level
                                                         );
                                                         entityToSpawn.setBaseDamage((double)damage);
                                                         entityToSpawn.setKnockback(knockback);
                                                         entityToSpawn.setSilent(true);
                                                         return entityToSpawn;
                                                      }
                                                   })
                                                   .getArrow(projectileLevelxxxx, 6.0F, 1);
                                                _entityToSpawnxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                _entityToSpawnxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxx);
                                             }

                                             if (world instanceof ServerLevel projectileLevelxxx) {
                                                Projectile _entityToSpawnxxx = (new Object() {
                                                      public Projectile getArrow(Level level, float damage, int knockback) {
                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                               .get(),
                                                            level
                                                         );
                                                         entityToSpawn.setBaseDamage((double)damage);
                                                         entityToSpawn.setKnockback(knockback);
                                                         entityToSpawn.setSilent(true);
                                                         return entityToSpawn;
                                                      }
                                                   })
                                                   .getArrow(projectileLevelxxx, 6.0F, 1);
                                                _entityToSpawnxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                _entityToSpawnxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                projectileLevelxxx.addFreshEntity(_entityToSpawnxxx);
                                             }

                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                1,
                                                () -> {
                                                   if (world instanceof ServerLevel projectileLevelxxxxxx) {
                                                      Projectile _entityToSpawnxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                     .get(),
                                                                  level
                                                               );
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxxxxx, 6.0F, 1);
                                                      _entityToSpawnxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                      _entityToSpawnxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                      projectileLevelxxxxxx.addFreshEntity(_entityToSpawnxxxxxx);
                                                   }

                                                   if (world instanceof ServerLevel projectileLevelxxxxx) {
                                                      Projectile _entityToSpawnxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                     .get(),
                                                                  level
                                                               );
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxxxx, 6.0F, 1);
                                                      _entityToSpawnxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                      _entityToSpawnxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                      projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxx);
                                                   }

                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                      1,
                                                      () -> {
                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxx) {
                                                            Projectile _entityToSpawnxxxxxxxx = (new Object() {
                                                                  public Projectile getArrow(Level level, float damage, int knockback) {
                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                           .get(),
                                                                        level
                                                                     );
                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                     entityToSpawn.setKnockback(knockback);
                                                                     entityToSpawn.setSilent(true);
                                                                     return entityToSpawn;
                                                                  }
                                                               })
                                                               .getArrow(projectileLevelxxxxxxxx, 6.0F, 1);
                                                            _entityToSpawnxxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                            _entityToSpawnxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                            projectileLevelxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxx);
                                                         }

                                                         if (world instanceof ServerLevel projectileLevelxxxxxxx) {
                                                            Projectile _entityToSpawnxxxxxxx = (new Object() {
                                                                  public Projectile getArrow(Level level, float damage, int knockback) {
                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                           .get(),
                                                                        level
                                                                     );
                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                     entityToSpawn.setKnockback(knockback);
                                                                     entityToSpawn.setSilent(true);
                                                                     return entityToSpawn;
                                                                  }
                                                               })
                                                               .getArrow(projectileLevelxxxxxxx, 6.0F, 1);
                                                            _entityToSpawnxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                            _entityToSpawnxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                            projectileLevelxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxx);
                                                         }

                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                            1,
                                                            () -> {
                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxx) {
                                                                  Projectile _entityToSpawnxxxxxxxxxx = (new Object() {
                                                                        public Projectile getArrow(Level level, float damage, int knockback) {
                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                 .get(),
                                                                              level
                                                                           );
                                                                           entityToSpawn.setBaseDamage((double)damage);
                                                                           entityToSpawn.setKnockback(knockback);
                                                                           entityToSpawn.setSilent(true);
                                                                           return entityToSpawn;
                                                                        }
                                                                     })
                                                                     .getArrow(projectileLevelxxxxxxxxxx, 6.0F, 1);
                                                                  _entityToSpawnxxxxxxxxxx.setPos(
                                                                     entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                  );
                                                                  _entityToSpawnxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                  projectileLevelxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxx);
                                                               }

                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxx) {
                                                                  Projectile _entityToSpawnxxxxxxxxx = (new Object() {
                                                                        public Projectile getArrow(Level level, float damage, int knockback) {
                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                 .get(),
                                                                              level
                                                                           );
                                                                           entityToSpawn.setBaseDamage((double)damage);
                                                                           entityToSpawn.setKnockback(knockback);
                                                                           entityToSpawn.setSilent(true);
                                                                           return entityToSpawn;
                                                                        }
                                                                     })
                                                                     .getArrow(projectileLevelxxxxxxxxx, 6.0F, 1);
                                                                  _entityToSpawnxxxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                                  _entityToSpawnxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                  projectileLevelxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxx);
                                                               }

                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                  1,
                                                                  () -> {
                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxx) {
                                                                        Projectile _entityToSpawnxxxxxxxxxxxx = (new Object() {
                                                                              public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                       .get(),
                                                                                    level
                                                                                 );
                                                                                 entityToSpawn.setBaseDamage((double)damage);
                                                                                 entityToSpawn.setKnockback(knockback);
                                                                                 entityToSpawn.setSilent(true);
                                                                                 return entityToSpawn;
                                                                              }
                                                                           })
                                                                           .getArrow(projectileLevelxxxxxxxxxxxx, 6.0F, 1);
                                                                        _entityToSpawnxxxxxxxxxxxx.setPos(
                                                                           entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                        );
                                                                        _entityToSpawnxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                        projectileLevelxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxx);
                                                                     }

                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxx) {
                                                                        Projectile _entityToSpawnxxxxxxxxxxx = (new Object() {
                                                                              public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                       .get(),
                                                                                    level
                                                                                 );
                                                                                 entityToSpawn.setBaseDamage((double)damage);
                                                                                 entityToSpawn.setKnockback(knockback);
                                                                                 entityToSpawn.setSilent(true);
                                                                                 return entityToSpawn;
                                                                              }
                                                                           })
                                                                           .getArrow(projectileLevelxxxxxxxxxxx, 6.0F, 1);
                                                                        _entityToSpawnxxxxxxxxxxx.setPos(
                                                                           entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                        );
                                                                        _entityToSpawnxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                        projectileLevelxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxx);
                                                                     }

                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                        1,
                                                                        () -> {
                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxx) {
                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxx = (new Object() {
                                                                                    public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                             .get(),
                                                                                          level
                                                                                       );
                                                                                       entityToSpawn.setBaseDamage((double)damage);
                                                                                       entityToSpawn.setKnockback(knockback);
                                                                                       entityToSpawn.setSilent(true);
                                                                                       return entityToSpawn;
                                                                                    }
                                                                                 })
                                                                                 .getArrow(projectileLevelxxxxxxxxxxxxxx, 6.0F, 1);
                                                                              _entityToSpawnxxxxxxxxxxxxxx.setPos(
                                                                                 entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                              );
                                                                              _entityToSpawnxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                              projectileLevelxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxx);
                                                                           }

                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxx) {
                                                                              Projectile _entityToSpawnxxxxxxxxxxxxx = (new Object() {
                                                                                    public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                             .get(),
                                                                                          level
                                                                                       );
                                                                                       entityToSpawn.setBaseDamage((double)damage);
                                                                                       entityToSpawn.setKnockback(knockback);
                                                                                       entityToSpawn.setSilent(true);
                                                                                       return entityToSpawn;
                                                                                    }
                                                                                 })
                                                                                 .getArrow(projectileLevelxxxxxxxxxxxxx, 6.0F, 1);
                                                                              _entityToSpawnxxxxxxxxxxxxx.setPos(
                                                                                 entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                              );
                                                                              _entityToSpawnxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                              projectileLevelxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxx);
                                                                           }

                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                              1,
                                                                              () -> {
                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxx) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                   .get(),
                                                                                                level
                                                                                             );
                                                                                             entityToSpawn.setBaseDamage((double)damage);
                                                                                             entityToSpawn.setKnockback(knockback);
                                                                                             entityToSpawn.setSilent(true);
                                                                                             return entityToSpawn;
                                                                                          }
                                                                                       })
                                                                                       .getArrow(projectileLevelxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                    projectileLevelxxxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxx);
                                                                                 }

                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxx) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                   .get(),
                                                                                                level
                                                                                             );
                                                                                             entityToSpawn.setBaseDamage((double)damage);
                                                                                             entityToSpawn.setKnockback(knockback);
                                                                                             entityToSpawn.setSilent(true);
                                                                                             return entityToSpawn;
                                                                                          }
                                                                                       })
                                                                                       .getArrow(projectileLevelxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                    _entityToSpawnxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                    projectileLevelxxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxx);
                                                                                 }

                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                    1,
                                                                                    () -> {
                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxx) {
                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                public Projectile getArrow(
                                                                                                   Level level, float damage, int knockback
                                                                                                ) {
                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                         .get(),
                                                                                                      level
                                                                                                   );
                                                                                                   entityToSpawn.setBaseDamage((double)damage);
                                                                                                   entityToSpawn.setKnockback(knockback);
                                                                                                   entityToSpawn.setSilent(true);
                                                                                                   return entityToSpawn;
                                                                                                }
                                                                                             })
                                                                                             .getArrow(projectileLevelxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxx.setPos(
                                                                                             entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                          );
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                          projectileLevelxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxx
                                                                                          );
                                                                                       }

                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxx) {
                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                public Projectile getArrow(
                                                                                                   Level level, float damage, int knockback
                                                                                                ) {
                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                         .get(),
                                                                                                      level
                                                                                                   );
                                                                                                   entityToSpawn.setBaseDamage((double)damage);
                                                                                                   entityToSpawn.setKnockback(knockback);
                                                                                                   entityToSpawn.setSilent(true);
                                                                                                   return entityToSpawn;
                                                                                                }
                                                                                             })
                                                                                             .getArrow(projectileLevelxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxx.setPos(
                                                                                             entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                          );
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                          projectileLevelxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxx
                                                                                          );
                                                                                       }

                                                                                       MokelsBossfightSaphyraMod.queueServerWork(
                                                                                          1,
                                                                                          () -> {
                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxx
                                                                                                )
                                                                                              {
                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                      public Projectile getArrow(
                                                                                                         Level level, float damage, int knockback
                                                                                                      ) {
                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                               .get(),
                                                                                                            level
                                                                                                         );
                                                                                                         entityToSpawn.setBaseDamage((double)damage);
                                                                                                         entityToSpawn.setKnockback(knockback);
                                                                                                         entityToSpawn.setSilent(true);
                                                                                                         return entityToSpawn;
                                                                                                      }
                                                                                                   })
                                                                                                   .getArrow(projectileLevelxxxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                   entity.getX(),
                                                                                                   6.0 + entity.getY(),
                                                                                                   entity.getZ()
                                                                                                );
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                   1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                );
                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxx
                                                                                                );
                                                                                             }

                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxx
                                                                                                )
                                                                                              {
                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                      public Projectile getArrow(
                                                                                                         Level level, float damage, int knockback
                                                                                                      ) {
                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                               .get(),
                                                                                                            level
                                                                                                         );
                                                                                                         entityToSpawn.setBaseDamage((double)damage);
                                                                                                         entityToSpawn.setKnockback(knockback);
                                                                                                         entityToSpawn.setSilent(true);
                                                                                                         return entityToSpawn;
                                                                                                      }
                                                                                                   })
                                                                                                   .getArrow(projectileLevelxxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                   entity.getX(),
                                                                                                   6.0 + entity.getY(),
                                                                                                   entity.getZ()
                                                                                                );
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                   1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                );
                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxx
                                                                                                );
                                                                                             }

                                                                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                1,
                                                                                                () -> {
                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxx
                                                                                                      )
                                                                                                    {
                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                            public Projectile getArrow(
                                                                                                               Level level, float damage, int knockback
                                                                                                            ) {
                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                     .get(),
                                                                                                                  level
                                                                                                               );
                                                                                                               entityToSpawn.setBaseDamage((double)damage);
                                                                                                               entityToSpawn.setKnockback(knockback);
                                                                                                               entityToSpawn.setSilent(true);
                                                                                                               return entityToSpawn;
                                                                                                            }
                                                                                                         })
                                                                                                         .getArrow(
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxx, 6.0F, 1
                                                                                                         );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                         entity.getX(),
                                                                                                         6.0 + entity.getY(),
                                                                                                         entity.getZ()
                                                                                                      );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                         1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                      );
                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx
                                                                                                      );
                                                                                                   }

                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxx
                                                                                                      )
                                                                                                    {
                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                            public Projectile getArrow(
                                                                                                               Level level, float damage, int knockback
                                                                                                            ) {
                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                     .get(),
                                                                                                                  level
                                                                                                               );
                                                                                                               entityToSpawn.setBaseDamage((double)damage);
                                                                                                               entityToSpawn.setKnockback(knockback);
                                                                                                               entityToSpawn.setSilent(true);
                                                                                                               return entityToSpawn;
                                                                                                            }
                                                                                                         })
                                                                                                         .getArrow(
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxx, 6.0F, 1
                                                                                                         );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                         entity.getX(),
                                                                                                         6.0 + entity.getY(),
                                                                                                         entity.getZ()
                                                                                                      );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                         1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                      );
                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxx
                                                                                                      );
                                                                                                   }

                                                                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                      1,
                                                                                                      () -> {
                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            )
                                                                                                          {
                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                  public Projectile getArrow(
                                                                                                                     Level level, float damage, int knockback
                                                                                                                  ) {
                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                           .get(),
                                                                                                                        level
                                                                                                                     );
                                                                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                                                                     entityToSpawn.setKnockback(knockback);
                                                                                                                     entityToSpawn.setSilent(true);
                                                                                                                     return entityToSpawn;
                                                                                                                  }
                                                                                                               })
                                                                                                               .getArrow(
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                  6.0F,
                                                                                                                  1
                                                                                                               );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                               entity.getX(),
                                                                                                               6.0 + entity.getY(),
                                                                                                               entity.getZ()
                                                                                                            );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                               1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                            );
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            );
                                                                                                         }

                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            )
                                                                                                          {
                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                  public Projectile getArrow(
                                                                                                                     Level level, float damage, int knockback
                                                                                                                  ) {
                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                           .get(),
                                                                                                                        level
                                                                                                                     );
                                                                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                                                                     entityToSpawn.setKnockback(knockback);
                                                                                                                     entityToSpawn.setSilent(true);
                                                                                                                     return entityToSpawn;
                                                                                                                  }
                                                                                                               })
                                                                                                               .getArrow(
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                  6.0F,
                                                                                                                  1
                                                                                                               );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                               entity.getX(),
                                                                                                               6.0 + entity.getY(),
                                                                                                               entity.getZ()
                                                                                                            );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                               1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                            );
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            );
                                                                                                         }

                                                                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                            1,
                                                                                                            () -> {
                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  )
                                                                                                                {
                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                        public Projectile getArrow(
                                                                                                                           Level level,
                                                                                                                           float damage,
                                                                                                                           int knockback
                                                                                                                        ) {
                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                 .get(),
                                                                                                                              level
                                                                                                                           );
                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                              (double)damage
                                                                                                                           );
                                                                                                                           entityToSpawn.setKnockback(knockback);
                                                                                                                           entityToSpawn.setSilent(true);
                                                                                                                           return entityToSpawn;
                                                                                                                        }
                                                                                                                     })
                                                                                                                     .getArrow(
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                        6.0F,
                                                                                                                        1
                                                                                                                     );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                     entity.getX(),
                                                                                                                     6.0 + entity.getY(),
                                                                                                                     entity.getZ()
                                                                                                                  );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                     1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                  );
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  );
                                                                                                               }

                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  )
                                                                                                                {
                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                        public Projectile getArrow(
                                                                                                                           Level level,
                                                                                                                           float damage,
                                                                                                                           int knockback
                                                                                                                        ) {
                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                 .get(),
                                                                                                                              level
                                                                                                                           );
                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                              (double)damage
                                                                                                                           );
                                                                                                                           entityToSpawn.setKnockback(knockback);
                                                                                                                           entityToSpawn.setSilent(true);
                                                                                                                           return entityToSpawn;
                                                                                                                        }
                                                                                                                     })
                                                                                                                     .getArrow(
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                        6.0F,
                                                                                                                        1
                                                                                                                     );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                     entity.getX(),
                                                                                                                     6.0 + entity.getY(),
                                                                                                                     entity.getZ()
                                                                                                                  );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                     1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                  );
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  );
                                                                                                               }

                                                                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                  1,
                                                                                                                  () -> {
                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                              public Projectile getArrow(
                                                                                                                                 Level level,
                                                                                                                                 float damage,
                                                                                                                                 int knockback
                                                                                                                              ) {
                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                       .get(),
                                                                                                                                    level
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                    (double)damage
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                    knockback
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setSilent(true);
                                                                                                                                 return entityToSpawn;
                                                                                                                              }
                                                                                                                           })
                                                                                                                           .getArrow(
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                              6.0F,
                                                                                                                              1
                                                                                                                           );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                           entity.getX(),
                                                                                                                           6.0 + entity.getY(),
                                                                                                                           entity.getZ()
                                                                                                                        );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                           1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                        );
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        );
                                                                                                                     }

                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                              public Projectile getArrow(
                                                                                                                                 Level level,
                                                                                                                                 float damage,
                                                                                                                                 int knockback
                                                                                                                              ) {
                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                       .get(),
                                                                                                                                    level
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                    (double)damage
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                    knockback
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setSilent(true);
                                                                                                                                 return entityToSpawn;
                                                                                                                              }
                                                                                                                           })
                                                                                                                           .getArrow(
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                              6.0F,
                                                                                                                              1
                                                                                                                           );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                           entity.getX(),
                                                                                                                           6.0 + entity.getY(),
                                                                                                                           entity.getZ()
                                                                                                                        );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                           1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                        );
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        );
                                                                                                                     }

                                                                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                        1,
                                                                                                                        () -> {
                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                    public Projectile getArrow(
                                                                                                                                       Level level,
                                                                                                                                       float damage,
                                                                                                                                       int knockback
                                                                                                                                    ) {
                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                             .get(),
                                                                                                                                          level
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                          (double)damage
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                          knockback
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                          true
                                                                                                                                       );
                                                                                                                                       return entityToSpawn;
                                                                                                                                    }
                                                                                                                                 })
                                                                                                                                 .getArrow(
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                    6.0F,
                                                                                                                                    1
                                                                                                                                 );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                 entity.getX(),
                                                                                                                                 6.0 + entity.getY(),
                                                                                                                                 entity.getZ()
                                                                                                                              );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                 1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                              );
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              );
                                                                                                                           }

                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                    public Projectile getArrow(
                                                                                                                                       Level level,
                                                                                                                                       float damage,
                                                                                                                                       int knockback
                                                                                                                                    ) {
                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                             .get(),
                                                                                                                                          level
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                          (double)damage
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                          knockback
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                          true
                                                                                                                                       );
                                                                                                                                       return entityToSpawn;
                                                                                                                                    }
                                                                                                                                 })
                                                                                                                                 .getArrow(
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                    6.0F,
                                                                                                                                    1
                                                                                                                                 );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                 entity.getX(),
                                                                                                                                 6.0 + entity.getY(),
                                                                                                                                 entity.getZ()
                                                                                                                              );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                 1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                              );
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              );
                                                                                                                           }

                                                                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                              1,
                                                                                                                              () -> {
                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    )
                                                                                                                                  {
                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                          public Projectile getArrow(
                                                                                                                                             Level level,
                                                                                                                                             float damage,
                                                                                                                                             int knockback
                                                                                                                                          ) {
                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                   .get(),
                                                                                                                                                level
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                (double)damage
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                knockback
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                true
                                                                                                                                             );
                                                                                                                                             return entityToSpawn;
                                                                                                                                          }
                                                                                                                                       })
                                                                                                                                       .getArrow(
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                          6.0F,
                                                                                                                                          1
                                                                                                                                       );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                       entity.getX(),
                                                                                                                                       6.0 + entity.getY(),
                                                                                                                                       entity.getZ()
                                                                                                                                    );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       0.2F,
                                                                                                                                       360.0F
                                                                                                                                    );
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    );
                                                                                                                                 }

                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    )
                                                                                                                                  {
                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                          public Projectile getArrow(
                                                                                                                                             Level level,
                                                                                                                                             float damage,
                                                                                                                                             int knockback
                                                                                                                                          ) {
                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                   .get(),
                                                                                                                                                level
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                (double)damage
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                knockback
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                true
                                                                                                                                             );
                                                                                                                                             return entityToSpawn;
                                                                                                                                          }
                                                                                                                                       })
                                                                                                                                       .getArrow(
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                          6.0F,
                                                                                                                                          1
                                                                                                                                       );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                       entity.getX(),
                                                                                                                                       6.0 + entity.getY(),
                                                                                                                                       entity.getZ()
                                                                                                                                    );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       0.2F,
                                                                                                                                       360.0F
                                                                                                                                    );
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    );
                                                                                                                                 }

                                                                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                    1,
                                                                                                                                    () -> {
                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          )
                                                                                                                                        {
                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                public Projectile getArrow(
                                                                                                                                                   Level level,
                                                                                                                                                   float damage,
                                                                                                                                                   int knockback
                                                                                                                                                ) {
                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                         .get(),
                                                                                                                                                      level
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                      (double)damage
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                      knockback
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                      true
                                                                                                                                                   );
                                                                                                                                                   return entityToSpawn;
                                                                                                                                                }
                                                                                                                                             })
                                                                                                                                             .getArrow(
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                6.0F,
                                                                                                                                                1
                                                                                                                                             );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                             entity.getX(),
                                                                                                                                             6.0
                                                                                                                                                + entity.getY(),
                                                                                                                                             entity.getZ()
                                                                                                                                          );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             0.2F,
                                                                                                                                             360.0F
                                                                                                                                          );
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          );
                                                                                                                                       }

                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          )
                                                                                                                                        {
                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                public Projectile getArrow(
                                                                                                                                                   Level level,
                                                                                                                                                   float damage,
                                                                                                                                                   int knockback
                                                                                                                                                ) {
                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                         .get(),
                                                                                                                                                      level
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                      (double)damage
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                      knockback
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                      true
                                                                                                                                                   );
                                                                                                                                                   return entityToSpawn;
                                                                                                                                                }
                                                                                                                                             })
                                                                                                                                             .getArrow(
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                6.0F,
                                                                                                                                                1
                                                                                                                                             );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                             entity.getX(),
                                                                                                                                             6.0
                                                                                                                                                + entity.getY(),
                                                                                                                                             entity.getZ()
                                                                                                                                          );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             0.2F,
                                                                                                                                             360.0F
                                                                                                                                          );
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          );
                                                                                                                                       }

                                                                                                                                       MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                          1,
                                                                                                                                          () -> {
                                                                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                )
                                                                                                                                              {
                                                                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                      public Projectile getArrow(
                                                                                                                                                         Level level,
                                                                                                                                                         float damage,
                                                                                                                                                         int knockback
                                                                                                                                                      ) {
                                                                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                               .get(),
                                                                                                                                                            level
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setBaseDamage(
                                                                                                                                                            (double)damage
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setKnockback(
                                                                                                                                                            knockback
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setSilent(
                                                                                                                                                            true
                                                                                                                                                         );
                                                                                                                                                         return entityToSpawn;
                                                                                                                                                      }
                                                                                                                                                   })
                                                                                                                                                   .getArrow(
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                      6.0F,
                                                                                                                                                      1
                                                                                                                                                   );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                   entity.getX(),
                                                                                                                                                   6.0
                                                                                                                                                      + entity.getY(),
                                                                                                                                                   entity.getZ()
                                                                                                                                                );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   0.2F,
                                                                                                                                                   360.0F
                                                                                                                                                );
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                );
                                                                                                                                             }

                                                                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                )
                                                                                                                                              {
                                                                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                      public Projectile getArrow(
                                                                                                                                                         Level level,
                                                                                                                                                         float damage,
                                                                                                                                                         int knockback
                                                                                                                                                      ) {
                                                                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                               .get(),
                                                                                                                                                            level
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setBaseDamage(
                                                                                                                                                            (double)damage
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setKnockback(
                                                                                                                                                            knockback
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setSilent(
                                                                                                                                                            true
                                                                                                                                                         );
                                                                                                                                                         return entityToSpawn;
                                                                                                                                                      }
                                                                                                                                                   })
                                                                                                                                                   .getArrow(
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                      6.0F,
                                                                                                                                                      1
                                                                                                                                                   );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                   entity.getX(),
                                                                                                                                                   6.0
                                                                                                                                                      + entity.getY(),
                                                                                                                                                   entity.getZ()
                                                                                                                                                );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   0.2F,
                                                                                                                                                   360.0F
                                                                                                                                                );
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                );
                                                                                                                                             }

                                                                                                                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                1,
                                                                                                                                                () -> {
                                                                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      )
                                                                                                                                                    {
                                                                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                            public Projectile getArrow(
                                                                                                                                                               Level level,
                                                                                                                                                               float damage,
                                                                                                                                                               int knockback
                                                                                                                                                            ) {
                                                                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                     .get(),
                                                                                                                                                                  level
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setBaseDamage(
                                                                                                                                                                  (double)damage
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setKnockback(
                                                                                                                                                                  knockback
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setSilent(
                                                                                                                                                                  true
                                                                                                                                                               );
                                                                                                                                                               return entityToSpawn;
                                                                                                                                                            }
                                                                                                                                                         })
                                                                                                                                                         .getArrow(
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                            6.0F,
                                                                                                                                                            1
                                                                                                                                                         );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                         entity.getX(),
                                                                                                                                                         6.0
                                                                                                                                                            + entity.getY(),
                                                                                                                                                         entity.getZ()
                                                                                                                                                      );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         0.2F,
                                                                                                                                                         360.0F
                                                                                                                                                      );
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      );
                                                                                                                                                   }

                                                                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      )
                                                                                                                                                    {
                                                                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                            public Projectile getArrow(
                                                                                                                                                               Level level,
                                                                                                                                                               float damage,
                                                                                                                                                               int knockback
                                                                                                                                                            ) {
                                                                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                     .get(),
                                                                                                                                                                  level
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setBaseDamage(
                                                                                                                                                                  (double)damage
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setKnockback(
                                                                                                                                                                  knockback
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setSilent(
                                                                                                                                                                  true
                                                                                                                                                               );
                                                                                                                                                               return entityToSpawn;
                                                                                                                                                            }
                                                                                                                                                         })
                                                                                                                                                         .getArrow(
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                            6.0F,
                                                                                                                                                            1
                                                                                                                                                         );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                         entity.getX(),
                                                                                                                                                         6.0
                                                                                                                                                            + entity.getY(),
                                                                                                                                                         entity.getZ()
                                                                                                                                                      );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         0.2F,
                                                                                                                                                         360.0F
                                                                                                                                                      );
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      );
                                                                                                                                                   }

                                                                                                                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                      1,
                                                                                                                                                      () -> {
                                                                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            )
                                                                                                                                                          {
                                                                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                  public Projectile getArrow(
                                                                                                                                                                     Level level,
                                                                                                                                                                     float damage,
                                                                                                                                                                     int knockback
                                                                                                                                                                  ) {
                                                                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                           .get(),
                                                                                                                                                                        level
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setBaseDamage(
                                                                                                                                                                        (double)damage
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setKnockback(
                                                                                                                                                                        knockback
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setSilent(
                                                                                                                                                                        true
                                                                                                                                                                     );
                                                                                                                                                                     return entityToSpawn;
                                                                                                                                                                  }
                                                                                                                                                               })
                                                                                                                                                               .getArrow(
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                  6.0F,
                                                                                                                                                                  1
                                                                                                                                                               );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                               entity.getX(),
                                                                                                                                                               6.0
                                                                                                                                                                  + entity.getY(),
                                                                                                                                                               entity.getZ()
                                                                                                                                                            );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               0.2F,
                                                                                                                                                               360.0F
                                                                                                                                                            );
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            );
                                                                                                                                                         }

                                                                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            )
                                                                                                                                                          {
                                                                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                  public Projectile getArrow(
                                                                                                                                                                     Level level,
                                                                                                                                                                     float damage,
                                                                                                                                                                     int knockback
                                                                                                                                                                  ) {
                                                                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                           .get(),
                                                                                                                                                                        level
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setBaseDamage(
                                                                                                                                                                        (double)damage
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setKnockback(
                                                                                                                                                                        knockback
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setSilent(
                                                                                                                                                                        true
                                                                                                                                                                     );
                                                                                                                                                                     return entityToSpawn;
                                                                                                                                                                  }
                                                                                                                                                               })
                                                                                                                                                               .getArrow(
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                  6.0F,
                                                                                                                                                                  1
                                                                                                                                                               );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                               entity.getX(),
                                                                                                                                                               6.0
                                                                                                                                                                  + entity.getY(),
                                                                                                                                                               entity.getZ()
                                                                                                                                                            );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               0.2F,
                                                                                                                                                               360.0F
                                                                                                                                                            );
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            );
                                                                                                                                                         }

                                                                                                                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                            1,
                                                                                                                                                            () -> {
                                                                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                        public Projectile getArrow(
                                                                                                                                                                           Level level,
                                                                                                                                                                           float damage,
                                                                                                                                                                           int knockback
                                                                                                                                                                        ) {
                                                                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                 .get(),
                                                                                                                                                                              level
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                                                                              (double)damage
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setKnockback(
                                                                                                                                                                              knockback
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setSilent(
                                                                                                                                                                              true
                                                                                                                                                                           );
                                                                                                                                                                           return entityToSpawn;
                                                                                                                                                                        }
                                                                                                                                                                     })
                                                                                                                                                                     .getArrow(
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                        6.0F,
                                                                                                                                                                        1
                                                                                                                                                                     );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                     entity.getX(),
                                                                                                                                                                     6.0
                                                                                                                                                                        + entity.getY(),
                                                                                                                                                                     entity.getZ()
                                                                                                                                                                  );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     0.2F,
                                                                                                                                                                     360.0F
                                                                                                                                                                  );
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  );
                                                                                                                                                               }

                                                                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                        public Projectile getArrow(
                                                                                                                                                                           Level level,
                                                                                                                                                                           float damage,
                                                                                                                                                                           int knockback
                                                                                                                                                                        ) {
                                                                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                 .get(),
                                                                                                                                                                              level
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                                                                              (double)damage
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setKnockback(
                                                                                                                                                                              knockback
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setSilent(
                                                                                                                                                                              true
                                                                                                                                                                           );
                                                                                                                                                                           return entityToSpawn;
                                                                                                                                                                        }
                                                                                                                                                                     })
                                                                                                                                                                     .getArrow(
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                        6.0F,
                                                                                                                                                                        1
                                                                                                                                                                     );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                     entity.getX(),
                                                                                                                                                                     6.0
                                                                                                                                                                        + entity.getY(),
                                                                                                                                                                     entity.getZ()
                                                                                                                                                                  );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     0.2F,
                                                                                                                                                                     360.0F
                                                                                                                                                                  );
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  );
                                                                                                                                                               }

                                                                                                                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                  1,
                                                                                                                                                                  () -> {
                                                                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                              public Projectile getArrow(
                                                                                                                                                                                 Level level,
                                                                                                                                                                                 float damage,
                                                                                                                                                                                 int knockback
                                                                                                                                                                              ) {
                                                                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                       .get(),
                                                                                                                                                                                    level
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                                                                    (double)damage
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                                                                    knockback
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setSilent(
                                                                                                                                                                                    true
                                                                                                                                                                                 );
                                                                                                                                                                                 return entityToSpawn;
                                                                                                                                                                              }
                                                                                                                                                                           })
                                                                                                                                                                           .getArrow(
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                              6.0F,
                                                                                                                                                                              1
                                                                                                                                                                           );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                           entity.getX(),
                                                                                                                                                                           6.0
                                                                                                                                                                              + entity.getY(),
                                                                                                                                                                           entity.getZ()
                                                                                                                                                                        );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           0.2F,
                                                                                                                                                                           360.0F
                                                                                                                                                                        );
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        );
                                                                                                                                                                     }

                                                                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                              public Projectile getArrow(
                                                                                                                                                                                 Level level,
                                                                                                                                                                                 float damage,
                                                                                                                                                                                 int knockback
                                                                                                                                                                              ) {
                                                                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                       .get(),
                                                                                                                                                                                    level
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                                                                    (double)damage
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                                                                    knockback
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setSilent(
                                                                                                                                                                                    true
                                                                                                                                                                                 );
                                                                                                                                                                                 return entityToSpawn;
                                                                                                                                                                              }
                                                                                                                                                                           })
                                                                                                                                                                           .getArrow(
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                              6.0F,
                                                                                                                                                                              1
                                                                                                                                                                           );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                           entity.getX(),
                                                                                                                                                                           6.0
                                                                                                                                                                              + entity.getY(),
                                                                                                                                                                           entity.getZ()
                                                                                                                                                                        );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           0.2F,
                                                                                                                                                                           360.0F
                                                                                                                                                                        );
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        );
                                                                                                                                                                     }

                                                                                                                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                        1,
                                                                                                                                                                        () -> {
                                                                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                    public Projectile getArrow(
                                                                                                                                                                                       Level level,
                                                                                                                                                                                       float damage,
                                                                                                                                                                                       int knockback
                                                                                                                                                                                    ) {
                                                                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                             .get(),
                                                                                                                                                                                          level
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                                                                          (double)damage
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                                                                          knockback
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                                                                          true
                                                                                                                                                                                       );
                                                                                                                                                                                       return entityToSpawn;
                                                                                                                                                                                    }
                                                                                                                                                                                 })
                                                                                                                                                                                 .getArrow(
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                    6.0F,
                                                                                                                                                                                    1
                                                                                                                                                                                 );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                 entity.getX(),
                                                                                                                                                                                 6.0
                                                                                                                                                                                    + entity.getY(),
                                                                                                                                                                                 entity.getZ()
                                                                                                                                                                              );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 0.2F,
                                                                                                                                                                                 360.0F
                                                                                                                                                                              );
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              );
                                                                                                                                                                           }

                                                                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                    public Projectile getArrow(
                                                                                                                                                                                       Level level,
                                                                                                                                                                                       float damage,
                                                                                                                                                                                       int knockback
                                                                                                                                                                                    ) {
                                                                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                             .get(),
                                                                                                                                                                                          level
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                                                                          (double)damage
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                                                                          knockback
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                                                                          true
                                                                                                                                                                                       );
                                                                                                                                                                                       return entityToSpawn;
                                                                                                                                                                                    }
                                                                                                                                                                                 })
                                                                                                                                                                                 .getArrow(
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                    6.0F,
                                                                                                                                                                                    1
                                                                                                                                                                                 );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                 entity.getX(),
                                                                                                                                                                                 6.0
                                                                                                                                                                                    + entity.getY(),
                                                                                                                                                                                 entity.getZ()
                                                                                                                                                                              );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 0.2F,
                                                                                                                                                                                 360.0F
                                                                                                                                                                              );
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              );
                                                                                                                                                                           }

                                                                                                                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                              1,
                                                                                                                                                                              () -> {
                                                                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                          public Projectile getArrow(
                                                                                                                                                                                             Level level,
                                                                                                                                                                                             float damage,
                                                                                                                                                                                             int knockback
                                                                                                                                                                                          ) {
                                                                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                   .get(),
                                                                                                                                                                                                level
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                                                                (double)damage
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                                                                knockback
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                                                                true
                                                                                                                                                                                             );
                                                                                                                                                                                             return entityToSpawn;
                                                                                                                                                                                          }
                                                                                                                                                                                       })
                                                                                                                                                                                       .getArrow(
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                          6.0F,
                                                                                                                                                                                          1
                                                                                                                                                                                       );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                       entity.getX(),
                                                                                                                                                                                       6.0
                                                                                                                                                                                          + entity.getY(),
                                                                                                                                                                                       entity.getZ()
                                                                                                                                                                                    );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       0.2F,
                                                                                                                                                                                       360.0F
                                                                                                                                                                                    );
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    );
                                                                                                                                                                                 }

                                                                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                          public Projectile getArrow(
                                                                                                                                                                                             Level level,
                                                                                                                                                                                             float damage,
                                                                                                                                                                                             int knockback
                                                                                                                                                                                          ) {
                                                                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                   .get(),
                                                                                                                                                                                                level
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                                                                (double)damage
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                                                                knockback
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                                                                true
                                                                                                                                                                                             );
                                                                                                                                                                                             return entityToSpawn;
                                                                                                                                                                                          }
                                                                                                                                                                                       })
                                                                                                                                                                                       .getArrow(
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                          6.0F,
                                                                                                                                                                                          1
                                                                                                                                                                                       );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                       entity.getX(),
                                                                                                                                                                                       6.0
                                                                                                                                                                                          + entity.getY(),
                                                                                                                                                                                       entity.getZ()
                                                                                                                                                                                    );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       0.2F,
                                                                                                                                                                                       360.0F
                                                                                                                                                                                    );
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    );
                                                                                                                                                                                 }

                                                                                                                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                                    1,
                                                                                                                                                                                    () -> {
                                                                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                                public Projectile getArrow(
                                                                                                                                                                                                   Level level,
                                                                                                                                                                                                   float damage,
                                                                                                                                                                                                   int knockback
                                                                                                                                                                                                ) {
                                                                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                         .get(),
                                                                                                                                                                                                      level
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                                                                      (double)damage
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                                                                      knockback
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                                                                      true
                                                                                                                                                                                                   );
                                                                                                                                                                                                   return entityToSpawn;
                                                                                                                                                                                                }
                                                                                                                                                                                             })
                                                                                                                                                                                             .getArrow(
                                                                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                                6.0F,
                                                                                                                                                                                                1
                                                                                                                                                                                             );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                             entity.getX(),
                                                                                                                                                                                             6.0
                                                                                                                                                                                                + entity.getY(),
                                                                                                                                                                                             entity.getZ()
                                                                                                                                                                                          );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             0.2F,
                                                                                                                                                                                             360.0F
                                                                                                                                                                                          );
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          );
                                                                                                                                                                                       }

                                                                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                                public Projectile getArrow(
                                                                                                                                                                                                   Level level,
                                                                                                                                                                                                   float damage,
                                                                                                                                                                                                   int knockback
                                                                                                                                                                                                ) {
                                                                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                         .get(),
                                                                                                                                                                                                      level
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                                                                      (double)damage
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                                                                      knockback
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                                                                      true
                                                                                                                                                                                                   );
                                                                                                                                                                                                   return entityToSpawn;
                                                                                                                                                                                                }
                                                                                                                                                                                             })
                                                                                                                                                                                             .getArrow(
                                                                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                                6.0F,
                                                                                                                                                                                                1
                                                                                                                                                                                             );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                             entity.getX(),
                                                                                                                                                                                             6.0
                                                                                                                                                                                                + entity.getY(),
                                                                                                                                                                                             entity.getZ()
                                                                                                                                                                                          );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             0.2F,
                                                                                                                                                                                             360.0F
                                                                                                                                                                                          );
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          );
                                                                                                                                                                                       }
                                                                                                                                                                                    }
                                                                                                                                                                                 );
                                                                                                                                                                              }
                                                                                                                                                                           );
                                                                                                                                                                        }
                                                                                                                                                                     );
                                                                                                                                                                  }
                                                                                                                                                               );
                                                                                                                                                            }
                                                                                                                                                         );
                                                                                                                                                      }
                                                                                                                                                   );
                                                                                                                                                }
                                                                                                                                             );
                                                                                                                                          }
                                                                                                                                       );
                                                                                                                                    }
                                                                                                                                 );
                                                                                                                              }
                                                                                                                           );
                                                                                                                        }
                                                                                                                     );
                                                                                                                  }
                                                                                                               );
                                                                                                            }
                                                                                                         );
                                                                                                      }
                                                                                                   );
                                                                                                }
                                                                                             );
                                                                                          }
                                                                                       );
                                                                                    }
                                                                                 );
                                                                              }
                                                                           );
                                                                        }
                                                                     );
                                                                  }
                                                               );
                                                            }
                                                         );
                                                      }
                                                   );
                                                }
                                             );
                                          }
                                       );
                                    }
                                 );
                              }
                           );
                        }
                     }
                  );
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("jumpattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  57,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 22.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 250, 4.0, 0.2, 4.0, 0.01);
                        }
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 260.0) {
            if (Math.random() <= 0.4) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("wandattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     8,
                     () -> {
                        if (entity.isAlive()) {
                           MokelsBossfightSaphyraMod.queueServerWork(
                              5,
                              () -> {
                                 Level projectileLevel = entity.level();
                                 if (!projectileLevel.isClientSide()) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new WitchBossProjectileEntity(
                                                (EntityType<? extends WitchBossProjectileEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILE.get(),
                                                level
                                             );
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, 6.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.6F, 20.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 if (entity.isAlive()) {
                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       5,
                                       () -> {
                                          Level projectileLevelx = entity.level();
                                          if (!projectileLevelx.isClientSide()) {
                                             Projectile _entityToSpawnx = (new Object() {
                                                   public Projectile getArrow(Level level, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new WitchBossProjectileEntity(
                                                         (EntityType<? extends WitchBossProjectileEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILE
                                                            .get(),
                                                         level
                                                      );
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelx, 6.0F, 1);
                                             _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnx.shoot(
                                                entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.6F, 20.0F
                                             );
                                             projectileLevelx.addFreshEntity(_entityToSpawnx);
                                          }

                                          if (entity.isAlive()) {
                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                5,
                                                () -> {
                                                   Level projectileLevelxx = entity.level();
                                                   if (!projectileLevelxx.isClientSide()) {
                                                      Projectile _entityToSpawnxx = (new Object() {
                                                            public Projectile getArrow(Level level, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new WitchBossProjectileEntity(
                                                                  (EntityType<? extends WitchBossProjectileEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILE
                                                                     .get(),
                                                                  level
                                                               );
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxx, 6.0F, 1);
                                                      _entityToSpawnxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.6F, 20.0F
                                                      );
                                                      projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                                   }
                                                }
                                             );
                                          }
                                       }
                                    );
                                 }
                              }
                           );
                        }
                     }
                  );
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("axeattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 110, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  30,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                        }
                     }
                  }
               );
               MokelsBossfightSaphyraMod.queueServerWork(
                  45,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                        }
                     }
                  }
               );
               MokelsBossfightSaphyraMod.queueServerWork(
                  55,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                        }
                     }
                  }
               );
               MokelsBossfightSaphyraMod.queueServerWork(
                  87,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 18.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 250, 4.0, 0.2, 4.0, 0.01);
                        }
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 420.0) {
            if (Math.random() <= 0.4) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("slashattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     26,
                     () -> {
                        if (entity.isAlive()) {
                           Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F
                                 );
                              }
                           }

                           if (world instanceof Level _levelxx) {
                              if (!_levelxx.isClientSide()) {
                                 _levelxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    2.0F,
                                    1.0F
                                 );
                              } else {
                                 _levelxx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    2.0F,
                                    1.0F,
                                    false
                                 );
                              }
                           }

                           if (world instanceof ServerLevel _levelx) {
                              _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 40, 1.0, 0.2, 1.0, 0.01);
                           }
                        }
                     }
                  );
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("clawattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  32,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 16.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof Level _levelx) {
                           if (!_levelx.isClientSide()) {
                              _levelx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F
                              );
                           } else {
                              _levelx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelxx) {
                           _levelxx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                        }
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 600.0) {
            if (Math.random() <= 0.4) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("rainattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 55, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     10,
                     () -> {
                        for (int index1 = 0; index1 < 2; index1++) {
                           MokelsBossfightSaphyraMod.queueServerWork(
                              1,
                              () -> {
                                 if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                   .get(),
                                                level
                                             );
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, 6.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                    _entityToSpawn.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                   .get(),
                                                level
                                             );
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, 6.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                    _entityToSpawn.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    1,
                                    () -> {
                                       if (world instanceof ServerLevel projectileLevelxx) {
                                          Projectile _entityToSpawnxx = (new Object() {
                                                public Projectile getArrow(Level level, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                         .get(),
                                                      level
                                                   );
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevelxx, 6.0F, 1);
                                          _entityToSpawnxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                          _entityToSpawnxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                          projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                       }

                                       if (world instanceof ServerLevel projectileLevelx) {
                                          Projectile _entityToSpawnx = (new Object() {
                                                public Projectile getArrow(Level level, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                         .get(),
                                                      level
                                                   );
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevelx, 6.0F, 1);
                                          _entityToSpawnx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                          _entityToSpawnx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                          projectileLevelx.addFreshEntity(_entityToSpawnx);
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          1,
                                          () -> {
                                             if (world instanceof ServerLevel projectileLevelxxxx) {
                                                Projectile _entityToSpawnxxxx = (new Object() {
                                                      public Projectile getArrow(Level level, float damage, int knockback) {
                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                               .get(),
                                                            level
                                                         );
                                                         entityToSpawn.setBaseDamage((double)damage);
                                                         entityToSpawn.setKnockback(knockback);
                                                         entityToSpawn.setSilent(true);
                                                         return entityToSpawn;
                                                      }
                                                   })
                                                   .getArrow(projectileLevelxxxx, 6.0F, 1);
                                                _entityToSpawnxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                _entityToSpawnxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxx);
                                             }

                                             if (world instanceof ServerLevel projectileLevelxxx) {
                                                Projectile _entityToSpawnxxx = (new Object() {
                                                      public Projectile getArrow(Level level, float damage, int knockback) {
                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                               .get(),
                                                            level
                                                         );
                                                         entityToSpawn.setBaseDamage((double)damage);
                                                         entityToSpawn.setKnockback(knockback);
                                                         entityToSpawn.setSilent(true);
                                                         return entityToSpawn;
                                                      }
                                                   })
                                                   .getArrow(projectileLevelxxx, 6.0F, 1);
                                                _entityToSpawnxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                _entityToSpawnxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                projectileLevelxxx.addFreshEntity(_entityToSpawnxxx);
                                             }

                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                1,
                                                () -> {
                                                   if (world instanceof ServerLevel projectileLevelxxxxxx) {
                                                      Projectile _entityToSpawnxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                     .get(),
                                                                  level
                                                               );
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxxxxx, 6.0F, 1);
                                                      _entityToSpawnxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                      _entityToSpawnxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                      projectileLevelxxxxxx.addFreshEntity(_entityToSpawnxxxxxx);
                                                   }

                                                   if (world instanceof ServerLevel projectileLevelxxxxx) {
                                                      Projectile _entityToSpawnxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                     .get(),
                                                                  level
                                                               );
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxxxx, 6.0F, 1);
                                                      _entityToSpawnxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                      _entityToSpawnxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                      projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxx);
                                                   }

                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                      1,
                                                      () -> {
                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxx) {
                                                            Projectile _entityToSpawnxxxxxxxx = (new Object() {
                                                                  public Projectile getArrow(Level level, float damage, int knockback) {
                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                           .get(),
                                                                        level
                                                                     );
                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                     entityToSpawn.setKnockback(knockback);
                                                                     entityToSpawn.setSilent(true);
                                                                     return entityToSpawn;
                                                                  }
                                                               })
                                                               .getArrow(projectileLevelxxxxxxxx, 6.0F, 1);
                                                            _entityToSpawnxxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                            _entityToSpawnxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                            projectileLevelxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxx);
                                                         }

                                                         if (world instanceof ServerLevel projectileLevelxxxxxxx) {
                                                            Projectile _entityToSpawnxxxxxxx = (new Object() {
                                                                  public Projectile getArrow(Level level, float damage, int knockback) {
                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                           .get(),
                                                                        level
                                                                     );
                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                     entityToSpawn.setKnockback(knockback);
                                                                     entityToSpawn.setSilent(true);
                                                                     return entityToSpawn;
                                                                  }
                                                               })
                                                               .getArrow(projectileLevelxxxxxxx, 6.0F, 1);
                                                            _entityToSpawnxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                            _entityToSpawnxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                            projectileLevelxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxx);
                                                         }

                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                            1,
                                                            () -> {
                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxx) {
                                                                  Projectile _entityToSpawnxxxxxxxxxx = (new Object() {
                                                                        public Projectile getArrow(Level level, float damage, int knockback) {
                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                 .get(),
                                                                              level
                                                                           );
                                                                           entityToSpawn.setBaseDamage((double)damage);
                                                                           entityToSpawn.setKnockback(knockback);
                                                                           entityToSpawn.setSilent(true);
                                                                           return entityToSpawn;
                                                                        }
                                                                     })
                                                                     .getArrow(projectileLevelxxxxxxxxxx, 6.0F, 1);
                                                                  _entityToSpawnxxxxxxxxxx.setPos(
                                                                     entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                  );
                                                                  _entityToSpawnxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                  projectileLevelxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxx);
                                                               }

                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxx) {
                                                                  Projectile _entityToSpawnxxxxxxxxx = (new Object() {
                                                                        public Projectile getArrow(Level level, float damage, int knockback) {
                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                 .get(),
                                                                              level
                                                                           );
                                                                           entityToSpawn.setBaseDamage((double)damage);
                                                                           entityToSpawn.setKnockback(knockback);
                                                                           entityToSpawn.setSilent(true);
                                                                           return entityToSpawn;
                                                                        }
                                                                     })
                                                                     .getArrow(projectileLevelxxxxxxxxx, 6.0F, 1);
                                                                  _entityToSpawnxxxxxxxxx.setPos(entity.getX(), 6.0 + entity.getY(), entity.getZ());
                                                                  _entityToSpawnxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                  projectileLevelxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxx);
                                                               }

                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                  1,
                                                                  () -> {
                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxx) {
                                                                        Projectile _entityToSpawnxxxxxxxxxxxx = (new Object() {
                                                                              public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                       .get(),
                                                                                    level
                                                                                 );
                                                                                 entityToSpawn.setBaseDamage((double)damage);
                                                                                 entityToSpawn.setKnockback(knockback);
                                                                                 entityToSpawn.setSilent(true);
                                                                                 return entityToSpawn;
                                                                              }
                                                                           })
                                                                           .getArrow(projectileLevelxxxxxxxxxxxx, 6.0F, 1);
                                                                        _entityToSpawnxxxxxxxxxxxx.setPos(
                                                                           entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                        );
                                                                        _entityToSpawnxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                        projectileLevelxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxx);
                                                                     }

                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxx) {
                                                                        Projectile _entityToSpawnxxxxxxxxxxx = (new Object() {
                                                                              public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                       .get(),
                                                                                    level
                                                                                 );
                                                                                 entityToSpawn.setBaseDamage((double)damage);
                                                                                 entityToSpawn.setKnockback(knockback);
                                                                                 entityToSpawn.setSilent(true);
                                                                                 return entityToSpawn;
                                                                              }
                                                                           })
                                                                           .getArrow(projectileLevelxxxxxxxxxxx, 6.0F, 1);
                                                                        _entityToSpawnxxxxxxxxxxx.setPos(
                                                                           entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                        );
                                                                        _entityToSpawnxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                        projectileLevelxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxx);
                                                                     }

                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                        1,
                                                                        () -> {
                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxx) {
                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxx = (new Object() {
                                                                                    public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                             .get(),
                                                                                          level
                                                                                       );
                                                                                       entityToSpawn.setBaseDamage((double)damage);
                                                                                       entityToSpawn.setKnockback(knockback);
                                                                                       entityToSpawn.setSilent(true);
                                                                                       return entityToSpawn;
                                                                                    }
                                                                                 })
                                                                                 .getArrow(projectileLevelxxxxxxxxxxxxxx, 6.0F, 1);
                                                                              _entityToSpawnxxxxxxxxxxxxxx.setPos(
                                                                                 entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                              );
                                                                              _entityToSpawnxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                              projectileLevelxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxx);
                                                                           }

                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxx) {
                                                                              Projectile _entityToSpawnxxxxxxxxxxxxx = (new Object() {
                                                                                    public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                             .get(),
                                                                                          level
                                                                                       );
                                                                                       entityToSpawn.setBaseDamage((double)damage);
                                                                                       entityToSpawn.setKnockback(knockback);
                                                                                       entityToSpawn.setSilent(true);
                                                                                       return entityToSpawn;
                                                                                    }
                                                                                 })
                                                                                 .getArrow(projectileLevelxxxxxxxxxxxxx, 6.0F, 1);
                                                                              _entityToSpawnxxxxxxxxxxxxx.setPos(
                                                                                 entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                              );
                                                                              _entityToSpawnxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                              projectileLevelxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxx);
                                                                           }

                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                              1,
                                                                              () -> {
                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxx) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                   .get(),
                                                                                                level
                                                                                             );
                                                                                             entityToSpawn.setBaseDamage((double)damage);
                                                                                             entityToSpawn.setKnockback(knockback);
                                                                                             entityToSpawn.setSilent(true);
                                                                                             return entityToSpawn;
                                                                                          }
                                                                                       })
                                                                                       .getArrow(projectileLevelxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                    projectileLevelxxxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxx);
                                                                                 }

                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxx) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(Level level, float damage, int knockback) {
                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                   .get(),
                                                                                                level
                                                                                             );
                                                                                             entityToSpawn.setBaseDamage((double)damage);
                                                                                             entityToSpawn.setKnockback(knockback);
                                                                                             entityToSpawn.setSilent(true);
                                                                                             return entityToSpawn;
                                                                                          }
                                                                                       })
                                                                                       .getArrow(projectileLevelxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                    _entityToSpawnxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                    projectileLevelxxxxxxxxxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxx);
                                                                                 }

                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                    1,
                                                                                    () -> {
                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxx) {
                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                public Projectile getArrow(
                                                                                                   Level level, float damage, int knockback
                                                                                                ) {
                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                         .get(),
                                                                                                      level
                                                                                                   );
                                                                                                   entityToSpawn.setBaseDamage((double)damage);
                                                                                                   entityToSpawn.setKnockback(knockback);
                                                                                                   entityToSpawn.setSilent(true);
                                                                                                   return entityToSpawn;
                                                                                                }
                                                                                             })
                                                                                             .getArrow(projectileLevelxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxx.setPos(
                                                                                             entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                          );
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                          projectileLevelxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxx
                                                                                          );
                                                                                       }

                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxx) {
                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                public Projectile getArrow(
                                                                                                   Level level, float damage, int knockback
                                                                                                ) {
                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                         .get(),
                                                                                                      level
                                                                                                   );
                                                                                                   entityToSpawn.setBaseDamage((double)damage);
                                                                                                   entityToSpawn.setKnockback(knockback);
                                                                                                   entityToSpawn.setSilent(true);
                                                                                                   return entityToSpawn;
                                                                                                }
                                                                                             })
                                                                                             .getArrow(projectileLevelxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxx.setPos(
                                                                                             entity.getX(), 6.0 + entity.getY(), entity.getZ()
                                                                                          );
                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxx.shoot(1.0, 1.0, 1.0, 0.2F, 360.0F);
                                                                                          projectileLevelxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxx
                                                                                          );
                                                                                       }

                                                                                       MokelsBossfightSaphyraMod.queueServerWork(
                                                                                          1,
                                                                                          () -> {
                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxx
                                                                                                )
                                                                                              {
                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                      public Projectile getArrow(
                                                                                                         Level level, float damage, int knockback
                                                                                                      ) {
                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                               .get(),
                                                                                                            level
                                                                                                         );
                                                                                                         entityToSpawn.setBaseDamage((double)damage);
                                                                                                         entityToSpawn.setKnockback(knockback);
                                                                                                         entityToSpawn.setSilent(true);
                                                                                                         return entityToSpawn;
                                                                                                      }
                                                                                                   })
                                                                                                   .getArrow(projectileLevelxxxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                   entity.getX(),
                                                                                                   6.0 + entity.getY(),
                                                                                                   entity.getZ()
                                                                                                );
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                   1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                );
                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxx
                                                                                                );
                                                                                             }

                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxx
                                                                                                )
                                                                                              {
                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                      public Projectile getArrow(
                                                                                                         Level level, float damage, int knockback
                                                                                                      ) {
                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                               .get(),
                                                                                                            level
                                                                                                         );
                                                                                                         entityToSpawn.setBaseDamage((double)damage);
                                                                                                         entityToSpawn.setKnockback(knockback);
                                                                                                         entityToSpawn.setSilent(true);
                                                                                                         return entityToSpawn;
                                                                                                      }
                                                                                                   })
                                                                                                   .getArrow(projectileLevelxxxxxxxxxxxxxxxxxxx, 6.0F, 1);
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                   entity.getX(),
                                                                                                   6.0 + entity.getY(),
                                                                                                   entity.getZ()
                                                                                                );
                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                   1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                );
                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxx
                                                                                                );
                                                                                             }

                                                                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                1,
                                                                                                () -> {
                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxx
                                                                                                      )
                                                                                                    {
                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                            public Projectile getArrow(
                                                                                                               Level level, float damage, int knockback
                                                                                                            ) {
                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                     .get(),
                                                                                                                  level
                                                                                                               );
                                                                                                               entityToSpawn.setBaseDamage((double)damage);
                                                                                                               entityToSpawn.setKnockback(knockback);
                                                                                                               entityToSpawn.setSilent(true);
                                                                                                               return entityToSpawn;
                                                                                                            }
                                                                                                         })
                                                                                                         .getArrow(
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxx, 6.0F, 1
                                                                                                         );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                         entity.getX(),
                                                                                                         6.0 + entity.getY(),
                                                                                                         entity.getZ()
                                                                                                      );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                         1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                      );
                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx
                                                                                                      );
                                                                                                   }

                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxx
                                                                                                      )
                                                                                                    {
                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                            public Projectile getArrow(
                                                                                                               Level level, float damage, int knockback
                                                                                                            ) {
                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                     .get(),
                                                                                                                  level
                                                                                                               );
                                                                                                               entityToSpawn.setBaseDamage((double)damage);
                                                                                                               entityToSpawn.setKnockback(knockback);
                                                                                                               entityToSpawn.setSilent(true);
                                                                                                               return entityToSpawn;
                                                                                                            }
                                                                                                         })
                                                                                                         .getArrow(
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxx, 6.0F, 1
                                                                                                         );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                         entity.getX(),
                                                                                                         6.0 + entity.getY(),
                                                                                                         entity.getZ()
                                                                                                      );
                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                         1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                      );
                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxx
                                                                                                      );
                                                                                                   }

                                                                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                      1,
                                                                                                      () -> {
                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            )
                                                                                                          {
                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                  public Projectile getArrow(
                                                                                                                     Level level, float damage, int knockback
                                                                                                                  ) {
                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                           .get(),
                                                                                                                        level
                                                                                                                     );
                                                                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                                                                     entityToSpawn.setKnockback(knockback);
                                                                                                                     entityToSpawn.setSilent(true);
                                                                                                                     return entityToSpawn;
                                                                                                                  }
                                                                                                               })
                                                                                                               .getArrow(
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                  6.0F,
                                                                                                                  1
                                                                                                               );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                               entity.getX(),
                                                                                                               6.0 + entity.getY(),
                                                                                                               entity.getZ()
                                                                                                            );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                               1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                            );
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            );
                                                                                                         }

                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            )
                                                                                                          {
                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                  public Projectile getArrow(
                                                                                                                     Level level, float damage, int knockback
                                                                                                                  ) {
                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                           .get(),
                                                                                                                        level
                                                                                                                     );
                                                                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                                                                     entityToSpawn.setKnockback(knockback);
                                                                                                                     entityToSpawn.setSilent(true);
                                                                                                                     return entityToSpawn;
                                                                                                                  }
                                                                                                               })
                                                                                                               .getArrow(
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                  6.0F,
                                                                                                                  1
                                                                                                               );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                               entity.getX(),
                                                                                                               6.0 + entity.getY(),
                                                                                                               entity.getZ()
                                                                                                            );
                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                               1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                            );
                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            );
                                                                                                         }

                                                                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                            1,
                                                                                                            () -> {
                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  )
                                                                                                                {
                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                        public Projectile getArrow(
                                                                                                                           Level level,
                                                                                                                           float damage,
                                                                                                                           int knockback
                                                                                                                        ) {
                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                 .get(),
                                                                                                                              level
                                                                                                                           );
                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                              (double)damage
                                                                                                                           );
                                                                                                                           entityToSpawn.setKnockback(knockback);
                                                                                                                           entityToSpawn.setSilent(true);
                                                                                                                           return entityToSpawn;
                                                                                                                        }
                                                                                                                     })
                                                                                                                     .getArrow(
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                        6.0F,
                                                                                                                        1
                                                                                                                     );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                     entity.getX(),
                                                                                                                     6.0 + entity.getY(),
                                                                                                                     entity.getZ()
                                                                                                                  );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                     1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                  );
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  );
                                                                                                               }

                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  )
                                                                                                                {
                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                        public Projectile getArrow(
                                                                                                                           Level level,
                                                                                                                           float damage,
                                                                                                                           int knockback
                                                                                                                        ) {
                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                 .get(),
                                                                                                                              level
                                                                                                                           );
                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                              (double)damage
                                                                                                                           );
                                                                                                                           entityToSpawn.setKnockback(knockback);
                                                                                                                           entityToSpawn.setSilent(true);
                                                                                                                           return entityToSpawn;
                                                                                                                        }
                                                                                                                     })
                                                                                                                     .getArrow(
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                        6.0F,
                                                                                                                        1
                                                                                                                     );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                     entity.getX(),
                                                                                                                     6.0 + entity.getY(),
                                                                                                                     entity.getZ()
                                                                                                                  );
                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                     1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                  );
                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                  );
                                                                                                               }

                                                                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                  1,
                                                                                                                  () -> {
                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                              public Projectile getArrow(
                                                                                                                                 Level level,
                                                                                                                                 float damage,
                                                                                                                                 int knockback
                                                                                                                              ) {
                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                       .get(),
                                                                                                                                    level
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                    (double)damage
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                    knockback
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setSilent(true);
                                                                                                                                 return entityToSpawn;
                                                                                                                              }
                                                                                                                           })
                                                                                                                           .getArrow(
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                              6.0F,
                                                                                                                              1
                                                                                                                           );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                           entity.getX(),
                                                                                                                           6.0 + entity.getY(),
                                                                                                                           entity.getZ()
                                                                                                                        );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                           1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                        );
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        );
                                                                                                                     }

                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                              public Projectile getArrow(
                                                                                                                                 Level level,
                                                                                                                                 float damage,
                                                                                                                                 int knockback
                                                                                                                              ) {
                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                       .get(),
                                                                                                                                    level
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                    (double)damage
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                    knockback
                                                                                                                                 );
                                                                                                                                 entityToSpawn.setSilent(true);
                                                                                                                                 return entityToSpawn;
                                                                                                                              }
                                                                                                                           })
                                                                                                                           .getArrow(
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                              6.0F,
                                                                                                                              1
                                                                                                                           );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                           entity.getX(),
                                                                                                                           6.0 + entity.getY(),
                                                                                                                           entity.getZ()
                                                                                                                        );
                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                           1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                        );
                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                        );
                                                                                                                     }

                                                                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                        1,
                                                                                                                        () -> {
                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                    public Projectile getArrow(
                                                                                                                                       Level level,
                                                                                                                                       float damage,
                                                                                                                                       int knockback
                                                                                                                                    ) {
                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                             .get(),
                                                                                                                                          level
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                          (double)damage
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                          knockback
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                          true
                                                                                                                                       );
                                                                                                                                       return entityToSpawn;
                                                                                                                                    }
                                                                                                                                 })
                                                                                                                                 .getArrow(
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                    6.0F,
                                                                                                                                    1
                                                                                                                                 );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                 entity.getX(),
                                                                                                                                 6.0 + entity.getY(),
                                                                                                                                 entity.getZ()
                                                                                                                              );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                 1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                              );
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              );
                                                                                                                           }

                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                    public Projectile getArrow(
                                                                                                                                       Level level,
                                                                                                                                       float damage,
                                                                                                                                       int knockback
                                                                                                                                    ) {
                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                             .get(),
                                                                                                                                          level
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                          (double)damage
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                          knockback
                                                                                                                                       );
                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                          true
                                                                                                                                       );
                                                                                                                                       return entityToSpawn;
                                                                                                                                    }
                                                                                                                                 })
                                                                                                                                 .getArrow(
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                    6.0F,
                                                                                                                                    1
                                                                                                                                 );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                 entity.getX(),
                                                                                                                                 6.0 + entity.getY(),
                                                                                                                                 entity.getZ()
                                                                                                                              );
                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                 1.0, 1.0, 1.0, 0.2F, 360.0F
                                                                                                                              );
                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                              );
                                                                                                                           }

                                                                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                              1,
                                                                                                                              () -> {
                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    )
                                                                                                                                  {
                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                          public Projectile getArrow(
                                                                                                                                             Level level,
                                                                                                                                             float damage,
                                                                                                                                             int knockback
                                                                                                                                          ) {
                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                   .get(),
                                                                                                                                                level
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                (double)damage
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                knockback
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                true
                                                                                                                                             );
                                                                                                                                             return entityToSpawn;
                                                                                                                                          }
                                                                                                                                       })
                                                                                                                                       .getArrow(
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                          6.0F,
                                                                                                                                          1
                                                                                                                                       );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                       entity.getX(),
                                                                                                                                       6.0 + entity.getY(),
                                                                                                                                       entity.getZ()
                                                                                                                                    );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       0.2F,
                                                                                                                                       360.0F
                                                                                                                                    );
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    );
                                                                                                                                 }

                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    )
                                                                                                                                  {
                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                          public Projectile getArrow(
                                                                                                                                             Level level,
                                                                                                                                             float damage,
                                                                                                                                             int knockback
                                                                                                                                          ) {
                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                   .get(),
                                                                                                                                                level
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                (double)damage
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                knockback
                                                                                                                                             );
                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                true
                                                                                                                                             );
                                                                                                                                             return entityToSpawn;
                                                                                                                                          }
                                                                                                                                       })
                                                                                                                                       .getArrow(
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                          6.0F,
                                                                                                                                          1
                                                                                                                                       );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                       entity.getX(),
                                                                                                                                       6.0 + entity.getY(),
                                                                                                                                       entity.getZ()
                                                                                                                                    );
                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       1.0,
                                                                                                                                       0.2F,
                                                                                                                                       360.0F
                                                                                                                                    );
                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                    );
                                                                                                                                 }

                                                                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                    1,
                                                                                                                                    () -> {
                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          )
                                                                                                                                        {
                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                public Projectile getArrow(
                                                                                                                                                   Level level,
                                                                                                                                                   float damage,
                                                                                                                                                   int knockback
                                                                                                                                                ) {
                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                         .get(),
                                                                                                                                                      level
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                      (double)damage
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                      knockback
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                      true
                                                                                                                                                   );
                                                                                                                                                   return entityToSpawn;
                                                                                                                                                }
                                                                                                                                             })
                                                                                                                                             .getArrow(
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                6.0F,
                                                                                                                                                1
                                                                                                                                             );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                             entity.getX(),
                                                                                                                                             6.0
                                                                                                                                                + entity.getY(),
                                                                                                                                             entity.getZ()
                                                                                                                                          );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             0.2F,
                                                                                                                                             360.0F
                                                                                                                                          );
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          );
                                                                                                                                       }

                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          )
                                                                                                                                        {
                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                public Projectile getArrow(
                                                                                                                                                   Level level,
                                                                                                                                                   float damage,
                                                                                                                                                   int knockback
                                                                                                                                                ) {
                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                         .get(),
                                                                                                                                                      level
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                      (double)damage
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                      knockback
                                                                                                                                                   );
                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                      true
                                                                                                                                                   );
                                                                                                                                                   return entityToSpawn;
                                                                                                                                                }
                                                                                                                                             })
                                                                                                                                             .getArrow(
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                6.0F,
                                                                                                                                                1
                                                                                                                                             );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                             entity.getX(),
                                                                                                                                             6.0
                                                                                                                                                + entity.getY(),
                                                                                                                                             entity.getZ()
                                                                                                                                          );
                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             1.0,
                                                                                                                                             0.2F,
                                                                                                                                             360.0F
                                                                                                                                          );
                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                          );
                                                                                                                                       }

                                                                                                                                       MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                          1,
                                                                                                                                          () -> {
                                                                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                )
                                                                                                                                              {
                                                                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                      public Projectile getArrow(
                                                                                                                                                         Level level,
                                                                                                                                                         float damage,
                                                                                                                                                         int knockback
                                                                                                                                                      ) {
                                                                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                               .get(),
                                                                                                                                                            level
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setBaseDamage(
                                                                                                                                                            (double)damage
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setKnockback(
                                                                                                                                                            knockback
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setSilent(
                                                                                                                                                            true
                                                                                                                                                         );
                                                                                                                                                         return entityToSpawn;
                                                                                                                                                      }
                                                                                                                                                   })
                                                                                                                                                   .getArrow(
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                      6.0F,
                                                                                                                                                      1
                                                                                                                                                   );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                   entity.getX(),
                                                                                                                                                   6.0
                                                                                                                                                      + entity.getY(),
                                                                                                                                                   entity.getZ()
                                                                                                                                                );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   0.2F,
                                                                                                                                                   360.0F
                                                                                                                                                );
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                );
                                                                                                                                             }

                                                                                                                                             if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                )
                                                                                                                                              {
                                                                                                                                                Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                      public Projectile getArrow(
                                                                                                                                                         Level level,
                                                                                                                                                         float damage,
                                                                                                                                                         int knockback
                                                                                                                                                      ) {
                                                                                                                                                         AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                            (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                               .get(),
                                                                                                                                                            level
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setBaseDamage(
                                                                                                                                                            (double)damage
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setKnockback(
                                                                                                                                                            knockback
                                                                                                                                                         );
                                                                                                                                                         entityToSpawn.setSilent(
                                                                                                                                                            true
                                                                                                                                                         );
                                                                                                                                                         return entityToSpawn;
                                                                                                                                                      }
                                                                                                                                                   })
                                                                                                                                                   .getArrow(
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                      6.0F,
                                                                                                                                                      1
                                                                                                                                                   );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                   entity.getX(),
                                                                                                                                                   6.0
                                                                                                                                                      + entity.getY(),
                                                                                                                                                   entity.getZ()
                                                                                                                                                );
                                                                                                                                                _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   1.0,
                                                                                                                                                   0.2F,
                                                                                                                                                   360.0F
                                                                                                                                                );
                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                   _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                );
                                                                                                                                             }

                                                                                                                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                1,
                                                                                                                                                () -> {
                                                                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      )
                                                                                                                                                    {
                                                                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                            public Projectile getArrow(
                                                                                                                                                               Level level,
                                                                                                                                                               float damage,
                                                                                                                                                               int knockback
                                                                                                                                                            ) {
                                                                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                     .get(),
                                                                                                                                                                  level
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setBaseDamage(
                                                                                                                                                                  (double)damage
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setKnockback(
                                                                                                                                                                  knockback
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setSilent(
                                                                                                                                                                  true
                                                                                                                                                               );
                                                                                                                                                               return entityToSpawn;
                                                                                                                                                            }
                                                                                                                                                         })
                                                                                                                                                         .getArrow(
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                            6.0F,
                                                                                                                                                            1
                                                                                                                                                         );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                         entity.getX(),
                                                                                                                                                         6.0
                                                                                                                                                            + entity.getY(),
                                                                                                                                                         entity.getZ()
                                                                                                                                                      );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         0.2F,
                                                                                                                                                         360.0F
                                                                                                                                                      );
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      );
                                                                                                                                                   }

                                                                                                                                                   if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      )
                                                                                                                                                    {
                                                                                                                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                            public Projectile getArrow(
                                                                                                                                                               Level level,
                                                                                                                                                               float damage,
                                                                                                                                                               int knockback
                                                                                                                                                            ) {
                                                                                                                                                               AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                  (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                     .get(),
                                                                                                                                                                  level
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setBaseDamage(
                                                                                                                                                                  (double)damage
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setKnockback(
                                                                                                                                                                  knockback
                                                                                                                                                               );
                                                                                                                                                               entityToSpawn.setSilent(
                                                                                                                                                                  true
                                                                                                                                                               );
                                                                                                                                                               return entityToSpawn;
                                                                                                                                                            }
                                                                                                                                                         })
                                                                                                                                                         .getArrow(
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                            6.0F,
                                                                                                                                                            1
                                                                                                                                                         );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                         entity.getX(),
                                                                                                                                                         6.0
                                                                                                                                                            + entity.getY(),
                                                                                                                                                         entity.getZ()
                                                                                                                                                      );
                                                                                                                                                      _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         1.0,
                                                                                                                                                         0.2F,
                                                                                                                                                         360.0F
                                                                                                                                                      );
                                                                                                                                                      projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                         _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                      );
                                                                                                                                                   }

                                                                                                                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                      1,
                                                                                                                                                      () -> {
                                                                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            )
                                                                                                                                                          {
                                                                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                  public Projectile getArrow(
                                                                                                                                                                     Level level,
                                                                                                                                                                     float damage,
                                                                                                                                                                     int knockback
                                                                                                                                                                  ) {
                                                                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                           .get(),
                                                                                                                                                                        level
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setBaseDamage(
                                                                                                                                                                        (double)damage
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setKnockback(
                                                                                                                                                                        knockback
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setSilent(
                                                                                                                                                                        true
                                                                                                                                                                     );
                                                                                                                                                                     return entityToSpawn;
                                                                                                                                                                  }
                                                                                                                                                               })
                                                                                                                                                               .getArrow(
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                  6.0F,
                                                                                                                                                                  1
                                                                                                                                                               );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                               entity.getX(),
                                                                                                                                                               6.0
                                                                                                                                                                  + entity.getY(),
                                                                                                                                                               entity.getZ()
                                                                                                                                                            );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               0.2F,
                                                                                                                                                               360.0F
                                                                                                                                                            );
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            );
                                                                                                                                                         }

                                                                                                                                                         if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            )
                                                                                                                                                          {
                                                                                                                                                            Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                  public Projectile getArrow(
                                                                                                                                                                     Level level,
                                                                                                                                                                     float damage,
                                                                                                                                                                     int knockback
                                                                                                                                                                  ) {
                                                                                                                                                                     AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                        (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                           .get(),
                                                                                                                                                                        level
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setBaseDamage(
                                                                                                                                                                        (double)damage
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setKnockback(
                                                                                                                                                                        knockback
                                                                                                                                                                     );
                                                                                                                                                                     entityToSpawn.setSilent(
                                                                                                                                                                        true
                                                                                                                                                                     );
                                                                                                                                                                     return entityToSpawn;
                                                                                                                                                                  }
                                                                                                                                                               })
                                                                                                                                                               .getArrow(
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                  6.0F,
                                                                                                                                                                  1
                                                                                                                                                               );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                               entity.getX(),
                                                                                                                                                               6.0
                                                                                                                                                                  + entity.getY(),
                                                                                                                                                               entity.getZ()
                                                                                                                                                            );
                                                                                                                                                            _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               1.0,
                                                                                                                                                               0.2F,
                                                                                                                                                               360.0F
                                                                                                                                                            );
                                                                                                                                                            projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                            );
                                                                                                                                                         }

                                                                                                                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                            1,
                                                                                                                                                            () -> {
                                                                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                        public Projectile getArrow(
                                                                                                                                                                           Level level,
                                                                                                                                                                           float damage,
                                                                                                                                                                           int knockback
                                                                                                                                                                        ) {
                                                                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                 .get(),
                                                                                                                                                                              level
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                                                                              (double)damage
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setKnockback(
                                                                                                                                                                              knockback
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setSilent(
                                                                                                                                                                              true
                                                                                                                                                                           );
                                                                                                                                                                           return entityToSpawn;
                                                                                                                                                                        }
                                                                                                                                                                     })
                                                                                                                                                                     .getArrow(
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                        6.0F,
                                                                                                                                                                        1
                                                                                                                                                                     );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                     entity.getX(),
                                                                                                                                                                     6.0
                                                                                                                                                                        + entity.getY(),
                                                                                                                                                                     entity.getZ()
                                                                                                                                                                  );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     0.2F,
                                                                                                                                                                     360.0F
                                                                                                                                                                  );
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  );
                                                                                                                                                               }

                                                                                                                                                               if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                        public Projectile getArrow(
                                                                                                                                                                           Level level,
                                                                                                                                                                           float damage,
                                                                                                                                                                           int knockback
                                                                                                                                                                        ) {
                                                                                                                                                                           AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                              (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                 .get(),
                                                                                                                                                                              level
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setBaseDamage(
                                                                                                                                                                              (double)damage
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setKnockback(
                                                                                                                                                                              knockback
                                                                                                                                                                           );
                                                                                                                                                                           entityToSpawn.setSilent(
                                                                                                                                                                              true
                                                                                                                                                                           );
                                                                                                                                                                           return entityToSpawn;
                                                                                                                                                                        }
                                                                                                                                                                     })
                                                                                                                                                                     .getArrow(
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                        6.0F,
                                                                                                                                                                        1
                                                                                                                                                                     );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                     entity.getX(),
                                                                                                                                                                     6.0
                                                                                                                                                                        + entity.getY(),
                                                                                                                                                                     entity.getZ()
                                                                                                                                                                  );
                                                                                                                                                                  _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     1.0,
                                                                                                                                                                     0.2F,
                                                                                                                                                                     360.0F
                                                                                                                                                                  );
                                                                                                                                                                  projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                     _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                  );
                                                                                                                                                               }

                                                                                                                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                  1,
                                                                                                                                                                  () -> {
                                                                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                              public Projectile getArrow(
                                                                                                                                                                                 Level level,
                                                                                                                                                                                 float damage,
                                                                                                                                                                                 int knockback
                                                                                                                                                                              ) {
                                                                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                       .get(),
                                                                                                                                                                                    level
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                                                                    (double)damage
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                                                                    knockback
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setSilent(
                                                                                                                                                                                    true
                                                                                                                                                                                 );
                                                                                                                                                                                 return entityToSpawn;
                                                                                                                                                                              }
                                                                                                                                                                           })
                                                                                                                                                                           .getArrow(
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                              6.0F,
                                                                                                                                                                              1
                                                                                                                                                                           );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                           entity.getX(),
                                                                                                                                                                           6.0
                                                                                                                                                                              + entity.getY(),
                                                                                                                                                                           entity.getZ()
                                                                                                                                                                        );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           0.2F,
                                                                                                                                                                           360.0F
                                                                                                                                                                        );
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        );
                                                                                                                                                                     }

                                                                                                                                                                     if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                              public Projectile getArrow(
                                                                                                                                                                                 Level level,
                                                                                                                                                                                 float damage,
                                                                                                                                                                                 int knockback
                                                                                                                                                                              ) {
                                                                                                                                                                                 AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                    (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                       .get(),
                                                                                                                                                                                    level
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setBaseDamage(
                                                                                                                                                                                    (double)damage
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setKnockback(
                                                                                                                                                                                    knockback
                                                                                                                                                                                 );
                                                                                                                                                                                 entityToSpawn.setSilent(
                                                                                                                                                                                    true
                                                                                                                                                                                 );
                                                                                                                                                                                 return entityToSpawn;
                                                                                                                                                                              }
                                                                                                                                                                           })
                                                                                                                                                                           .getArrow(
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                              6.0F,
                                                                                                                                                                              1
                                                                                                                                                                           );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                           entity.getX(),
                                                                                                                                                                           6.0
                                                                                                                                                                              + entity.getY(),
                                                                                                                                                                           entity.getZ()
                                                                                                                                                                        );
                                                                                                                                                                        _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           1.0,
                                                                                                                                                                           0.2F,
                                                                                                                                                                           360.0F
                                                                                                                                                                        );
                                                                                                                                                                        projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                        );
                                                                                                                                                                     }

                                                                                                                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                        1,
                                                                                                                                                                        () -> {
                                                                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                    public Projectile getArrow(
                                                                                                                                                                                       Level level,
                                                                                                                                                                                       float damage,
                                                                                                                                                                                       int knockback
                                                                                                                                                                                    ) {
                                                                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                             .get(),
                                                                                                                                                                                          level
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                                                                          (double)damage
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                                                                          knockback
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                                                                          true
                                                                                                                                                                                       );
                                                                                                                                                                                       return entityToSpawn;
                                                                                                                                                                                    }
                                                                                                                                                                                 })
                                                                                                                                                                                 .getArrow(
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                    6.0F,
                                                                                                                                                                                    1
                                                                                                                                                                                 );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                 entity.getX(),
                                                                                                                                                                                 6.0
                                                                                                                                                                                    + entity.getY(),
                                                                                                                                                                                 entity.getZ()
                                                                                                                                                                              );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 0.2F,
                                                                                                                                                                                 360.0F
                                                                                                                                                                              );
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              );
                                                                                                                                                                           }

                                                                                                                                                                           if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                    public Projectile getArrow(
                                                                                                                                                                                       Level level,
                                                                                                                                                                                       float damage,
                                                                                                                                                                                       int knockback
                                                                                                                                                                                    ) {
                                                                                                                                                                                       AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                          (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                             .get(),
                                                                                                                                                                                          level
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setBaseDamage(
                                                                                                                                                                                          (double)damage
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setKnockback(
                                                                                                                                                                                          knockback
                                                                                                                                                                                       );
                                                                                                                                                                                       entityToSpawn.setSilent(
                                                                                                                                                                                          true
                                                                                                                                                                                       );
                                                                                                                                                                                       return entityToSpawn;
                                                                                                                                                                                    }
                                                                                                                                                                                 })
                                                                                                                                                                                 .getArrow(
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                    6.0F,
                                                                                                                                                                                    1
                                                                                                                                                                                 );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                 entity.getX(),
                                                                                                                                                                                 6.0
                                                                                                                                                                                    + entity.getY(),
                                                                                                                                                                                 entity.getZ()
                                                                                                                                                                              );
                                                                                                                                                                              _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 1.0,
                                                                                                                                                                                 0.2F,
                                                                                                                                                                                 360.0F
                                                                                                                                                                              );
                                                                                                                                                                              projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                 _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                              );
                                                                                                                                                                           }

                                                                                                                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                              1,
                                                                                                                                                                              () -> {
                                                                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                          public Projectile getArrow(
                                                                                                                                                                                             Level level,
                                                                                                                                                                                             float damage,
                                                                                                                                                                                             int knockback
                                                                                                                                                                                          ) {
                                                                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                   .get(),
                                                                                                                                                                                                level
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                                                                (double)damage
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                                                                knockback
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                                                                true
                                                                                                                                                                                             );
                                                                                                                                                                                             return entityToSpawn;
                                                                                                                                                                                          }
                                                                                                                                                                                       })
                                                                                                                                                                                       .getArrow(
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                          6.0F,
                                                                                                                                                                                          1
                                                                                                                                                                                       );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                       entity.getX(),
                                                                                                                                                                                       6.0
                                                                                                                                                                                          + entity.getY(),
                                                                                                                                                                                       entity.getZ()
                                                                                                                                                                                    );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       0.2F,
                                                                                                                                                                                       360.0F
                                                                                                                                                                                    );
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    );
                                                                                                                                                                                 }

                                                                                                                                                                                 if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                          public Projectile getArrow(
                                                                                                                                                                                             Level level,
                                                                                                                                                                                             float damage,
                                                                                                                                                                                             int knockback
                                                                                                                                                                                          ) {
                                                                                                                                                                                             AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                   .get(),
                                                                                                                                                                                                level
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setBaseDamage(
                                                                                                                                                                                                (double)damage
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setKnockback(
                                                                                                                                                                                                knockback
                                                                                                                                                                                             );
                                                                                                                                                                                             entityToSpawn.setSilent(
                                                                                                                                                                                                true
                                                                                                                                                                                             );
                                                                                                                                                                                             return entityToSpawn;
                                                                                                                                                                                          }
                                                                                                                                                                                       })
                                                                                                                                                                                       .getArrow(
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                          6.0F,
                                                                                                                                                                                          1
                                                                                                                                                                                       );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                       entity.getX(),
                                                                                                                                                                                       6.0
                                                                                                                                                                                          + entity.getY(),
                                                                                                                                                                                       entity.getZ()
                                                                                                                                                                                    );
                                                                                                                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       1.0,
                                                                                                                                                                                       0.2F,
                                                                                                                                                                                       360.0F
                                                                                                                                                                                    );
                                                                                                                                                                                    projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                    );
                                                                                                                                                                                 }

                                                                                                                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                                                                                                                    1,
                                                                                                                                                                                    () -> {
                                                                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                                public Projectile getArrow(
                                                                                                                                                                                                   Level level,
                                                                                                                                                                                                   float damage,
                                                                                                                                                                                                   int knockback
                                                                                                                                                                                                ) {
                                                                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                         .get(),
                                                                                                                                                                                                      level
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                                                                      (double)damage
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                                                                      knockback
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                                                                      true
                                                                                                                                                                                                   );
                                                                                                                                                                                                   return entityToSpawn;
                                                                                                                                                                                                }
                                                                                                                                                                                             })
                                                                                                                                                                                             .getArrow(
                                                                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                                6.0F,
                                                                                                                                                                                                1
                                                                                                                                                                                             );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                             entity.getX(),
                                                                                                                                                                                             6.0
                                                                                                                                                                                                + entity.getY(),
                                                                                                                                                                                             entity.getZ()
                                                                                                                                                                                          );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             0.2F,
                                                                                                                                                                                             360.0F
                                                                                                                                                                                          );
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          );
                                                                                                                                                                                       }

                                                                                                                                                                                       if (world instanceof ServerLevel projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                                                                                                                                public Projectile getArrow(
                                                                                                                                                                                                   Level level,
                                                                                                                                                                                                   float damage,
                                                                                                                                                                                                   int knockback
                                                                                                                                                                                                ) {
                                                                                                                                                                                                   AbstractArrow entityToSpawn = new WitchBossProjectilefallEntity(
                                                                                                                                                                                                      (EntityType<? extends WitchBossProjectilefallEntity>)MokelsBossfightSaphyraModEntities.WITCH_BOSS_PROJECTILEFALL
                                                                                                                                                                                                         .get(),
                                                                                                                                                                                                      level
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setBaseDamage(
                                                                                                                                                                                                      (double)damage
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setKnockback(
                                                                                                                                                                                                      knockback
                                                                                                                                                                                                   );
                                                                                                                                                                                                   entityToSpawn.setSilent(
                                                                                                                                                                                                      true
                                                                                                                                                                                                   );
                                                                                                                                                                                                   return entityToSpawn;
                                                                                                                                                                                                }
                                                                                                                                                                                             })
                                                                                                                                                                                             .getArrow(
                                                                                                                                                                                                projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                                                                                                                                                6.0F,
                                                                                                                                                                                                1
                                                                                                                                                                                             );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                                                                                                                             entity.getX(),
                                                                                                                                                                                             6.0
                                                                                                                                                                                                + entity.getY(),
                                                                                                                                                                                             entity.getZ()
                                                                                                                                                                                          );
                                                                                                                                                                                          _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             1.0,
                                                                                                                                                                                             0.2F,
                                                                                                                                                                                             360.0F
                                                                                                                                                                                          );
                                                                                                                                                                                          projectileLevelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(
                                                                                                                                                                                             _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                                                                                                          );
                                                                                                                                                                                       }
                                                                                                                                                                                    }
                                                                                                                                                                                 );
                                                                                                                                                                              }
                                                                                                                                                                           );
                                                                                                                                                                        }
                                                                                                                                                                     );
                                                                                                                                                                  }
                                                                                                                                                               );
                                                                                                                                                            }
                                                                                                                                                         );
                                                                                                                                                      }
                                                                                                                                                   );
                                                                                                                                                }
                                                                                                                                             );
                                                                                                                                          }
                                                                                                                                       );
                                                                                                                                    }
                                                                                                                                 );
                                                                                                                              }
                                                                                                                           );
                                                                                                                        }
                                                                                                                     );
                                                                                                                  }
                                                                                                               );
                                                                                                            }
                                                                                                         );
                                                                                                      }
                                                                                                   );
                                                                                                }
                                                                                             );
                                                                                          }
                                                                                       );
                                                                                    }
                                                                                 );
                                                                              }
                                                                           );
                                                                        }
                                                                     );
                                                                  }
                                                               );
                                                            }
                                                         );
                                                      }
                                                   );
                                                }
                                             );
                                          }
                                       );
                                    }
                                 );
                              }
                           );
                        }
                     }
                  );
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("jumpattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  57,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 22.0F);
                           }
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                                 SoundSource.NEUTRAL,
                                 2.0F,
                                 0.6F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 250, 4.0, 0.2, 4.0, 0.01);
                        }
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 860.0 && entity.isAlive()) {
            if (entity instanceof WitchbossEntity) {
               ((WitchbossEntity)entity).setAnimation("axeattack");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 110, 100, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               30,
               () -> {
                  if (entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                        }
                     }

                     if (world instanceof Level _levelxx) {
                        if (!_levelxx.isClientSide()) {
                           _levelxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F
                           );
                        } else {
                           _levelxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                     }
                  }
               }
            );
            MokelsBossfightSaphyraMod.queueServerWork(
               45,
               () -> {
                  if (entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                        }
                     }

                     if (world instanceof Level _levelxx) {
                        if (!_levelxx.isClientSide()) {
                           _levelxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F
                           );
                        } else {
                           _levelxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                     }
                  }
               }
            );
            MokelsBossfightSaphyraMod.queueServerWork(
               55,
               () -> {
                  if (entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 12.0F);
                        }
                     }

                     if (world instanceof Level _levelxx) {
                        if (!_levelxx.isClientSide()) {
                           _levelxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F
                           );
                        } else {
                           _levelxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 100, 2.5, 0.2, 2.5, 0.01);
                     }
                  }
               }
            );
            MokelsBossfightSaphyraMod.queueServerWork(
               87,
               () -> {
                  if (entity.isAlive()) {
                     Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 18.0F);
                        }
                     }

                     if (world instanceof Level _levelxx) {
                        if (!_levelxx.isClientSide()) {
                           _levelxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              0.6F
                           );
                        } else {
                           _levelxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              0.6F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 250, 4.0, 0.2, 4.0, 0.01);
                     }
                  }
               }
            );
         }

         if (entity.getPersistentData().getDouble("IA") == 920.0) {
            entity.getPersistentData().putDouble("IA", 0.0);
         }
      }
   }
}

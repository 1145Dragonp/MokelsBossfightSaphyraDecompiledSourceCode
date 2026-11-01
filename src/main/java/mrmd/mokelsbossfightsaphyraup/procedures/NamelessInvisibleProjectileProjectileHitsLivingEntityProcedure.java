package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessProjectileFallEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NamelessInvisibleProjectileProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      MokelsBossfightSaphyraMod.queueServerWork(
         2,
         () -> {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity && !(entityiterator instanceof NamelessEntity)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entityiterator;
                     if (_livEnt4.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                        continue;
                     }
                  }

                  double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                           )
                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                        .Rotting
                     + 1.0;
                  entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.Rotting = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               2,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                  }

                  Vec3 _centerx = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(3.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerx)))
                     .toList()) {
                     if (entityiteratorx instanceof LivingEntity && !(entityiteratorx instanceof NamelessEntity)) {
                        if (entityiteratorx instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entityiteratorx;
                           if (_livEnt10.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                              continue;
                           }
                        }

                        double _setvalx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorx.getCapability(
                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                 )
                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                              .Rotting
                           + 1.0;
                        entityiteratorx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.Rotting = _setvalx;
                           capability.syncPlayerVariables(entityiteratorx);
                        });
                     }
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     2,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                        }

                        Vec3 _centerxx = new Vec3(x, y, z);

                        for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxx, _centerxx).inflate(3.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxx)))
                           .toList()) {
                           if (entityiteratorxx instanceof LivingEntity && !(entityiteratorxx instanceof NamelessEntity)) {
                              if (entityiteratorxx instanceof LivingEntity) {
                                 LivingEntity _livEnt16 = (LivingEntity)entityiteratorxx;
                                 if (_livEnt16.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                    continue;
                                 }
                              }

                              double _setvalxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                          MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                       )
                                       .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                    .Rotting
                                 + 1.0;
                              entityiteratorxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                 capability.Rotting = _setvalxx;
                                 capability.syncPlayerVariables(entityiteratorxx);
                              });
                           }
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           2,
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              Vec3 _centerxxx = new Vec3(x, y, z);

                              for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxx, _centerxxx).inflate(3.0), e -> true)
                                 .stream()
                                 .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxx)))
                                 .toList()) {
                                 if (entityiteratorxxx instanceof LivingEntity && !(entityiteratorxxx instanceof NamelessEntity)) {
                                    if (entityiteratorxxx instanceof LivingEntity) {
                                       LivingEntity _livEnt22 = (LivingEntity)entityiteratorxxx;
                                       if (_livEnt22.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                          continue;
                                       }
                                    }

                                    double _setvalxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxx.getCapability(
                                                MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                             )
                                             .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                          .Rotting
                                       + 1.0;
                                    entityiteratorxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .ifPresent(capability -> {
                                          capability.Rotting = _setvalxxx;
                                          capability.syncPlayerVariables(entityiteratorxxx);
                                       });
                                 }
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 2,
                                 () -> {
                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    Vec3 _centerxxxx = new Vec3(x, y, z);

                                    for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxxx, _centerxxxx).inflate(3.0), e -> true)
                                       .stream()
                                       .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxx)))
                                       .toList()) {
                                       if (entityiteratorxxxx instanceof LivingEntity && !(entityiteratorxxxx instanceof NamelessEntity)) {
                                          if (entityiteratorxxxx instanceof LivingEntity) {
                                             LivingEntity _livEnt28 = (LivingEntity)entityiteratorxxxx;
                                             if (_livEnt28.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                continue;
                                             }
                                          }

                                          double _setvalxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxx.getCapability(
                                                      MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                   )
                                                   .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                .Rotting
                                             + 1.0;
                                          entityiteratorxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                             .ifPresent(capability -> {
                                                capability.Rotting = _setvalxxxx;
                                                capability.syncPlayerVariables(entityiteratorxxxx);
                                             });
                                       }
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       2,
                                       () -> {
                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                20,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                15,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          Vec3 _centerxxxxx = new Vec3(x, y, z);

                                          for (Entity entityiteratorxxxxx : world.getEntitiesOfClass(
                                                Entity.class, new AABB(_centerxxxxx, _centerxxxxx).inflate(3.0), e -> true
                                             )
                                             .stream()
                                             .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxx)))
                                             .toList()) {
                                             if (entityiteratorxxxxx instanceof LivingEntity && !(entityiteratorxxxxx instanceof NamelessEntity)) {
                                                if (entityiteratorxxxxx instanceof LivingEntity) {
                                                   LivingEntity _livEnt34 = (LivingEntity)entityiteratorxxxxx;
                                                   if (_livEnt34.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                      continue;
                                                   }
                                                }

                                                double _setvalxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxx.getCapability(
                                                            MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                         )
                                                         .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                      .Rotting
                                                   + 1.0;
                                                entityiteratorxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                   .ifPresent(capability -> {
                                                      capability.Rotting = _setvalxxxxx;
                                                      capability.syncPlayerVariables(entityiteratorxxxxx);
                                                   });
                                             }
                                          }

                                          MokelsBossfightSaphyraMod.queueServerWork(
                                             2,
                                             () -> {
                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      20,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      15,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                Vec3 _centerxxxxxx = new Vec3(x, y, z);

                                                for (Entity entityiteratorxxxxxx : world.getEntitiesOfClass(
                                                      Entity.class, new AABB(_centerxxxxxx, _centerxxxxxx).inflate(3.0), e -> true
                                                   )
                                                   .stream()
                                                   .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxx)))
                                                   .toList()) {
                                                   if (entityiteratorxxxxxx instanceof LivingEntity && !(entityiteratorxxxxxx instanceof NamelessEntity)) {
                                                      if (entityiteratorxxxxxx instanceof LivingEntity) {
                                                         LivingEntity _livEnt40 = (LivingEntity)entityiteratorxxxxxx;
                                                         if (_livEnt40.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                            continue;
                                                         }
                                                      }

                                                      double _setvalxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                            .Rotting
                                                         + 1.0;
                                                      entityiteratorxxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                         .ifPresent(capability -> {
                                                            capability.Rotting = _setvalxxxxxx;
                                                            capability.syncPlayerVariables(entityiteratorxxxxxx);
                                                         });
                                                   }
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   2,
                                                   () -> {
                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            20,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            15,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      Vec3 _centerxxxxxxx = new Vec3(x, y, z);

                                                      for (Entity entityiteratorxxxxxxx : world.getEntitiesOfClass(
                                                            Entity.class, new AABB(_centerxxxxxxx, _centerxxxxxxx).inflate(3.0), e -> true
                                                         )
                                                         .stream()
                                                         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxx)))
                                                         .toList()) {
                                                         if (entityiteratorxxxxxxx instanceof LivingEntity
                                                            && !(entityiteratorxxxxxxx instanceof NamelessEntity)) {
                                                            if (entityiteratorxxxxxxx instanceof LivingEntity) {
                                                               LivingEntity _livEnt46 = (LivingEntity)entityiteratorxxxxxxx;
                                                               if (_livEnt46.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                  continue;
                                                               }
                                                            }

                                                            double _setvalxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                  .Rotting
                                                               + 1.0;
                                                            entityiteratorxxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .ifPresent(capability -> {
                                                                  capability.Rotting = _setvalxxxxxxx;
                                                                  capability.syncPlayerVariables(entityiteratorxxxxxxx);
                                                               });
                                                         }
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         2,
                                                         () -> {
                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  20,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  15,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            Vec3 _centerxxxxxxxx = new Vec3(x, y, z);

                                                            for (Entity entityiteratorxxxxxxxx : world.getEntitiesOfClass(
                                                                  Entity.class, new AABB(_centerxxxxxxxx, _centerxxxxxxxx).inflate(3.0), e -> true
                                                               )
                                                               .stream()
                                                               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxx)))
                                                               .toList()) {
                                                               if (entityiteratorxxxxxxxx instanceof LivingEntity
                                                                  && !(entityiteratorxxxxxxxx instanceof NamelessEntity)) {
                                                                  if (entityiteratorxxxxxxxx instanceof LivingEntity) {
                                                                     LivingEntity _livEnt52 = (LivingEntity)entityiteratorxxxxxxxx;
                                                                     if (_livEnt52.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                        continue;
                                                                     }
                                                                  }

                                                                  double _setvalxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                        .Rotting
                                                                     + 1.0;
                                                                  entityiteratorxxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .ifPresent(capability -> {
                                                                        capability.Rotting = _setvalxxxxxxxx;
                                                                        capability.syncPlayerVariables(entityiteratorxxxxxxxx);
                                                                     });
                                                               }
                                                            }

                                                            MokelsBossfightSaphyraMod.queueServerWork(
                                                               2,
                                                               () -> {
                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        20,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        15,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  Vec3 _centerxxxxxxxxx = new Vec3(x, y, z);

                                                                  for (Entity entityiteratorxxxxxxxxx : world.getEntitiesOfClass(
                                                                        Entity.class, new AABB(_centerxxxxxxxxx, _centerxxxxxxxxx).inflate(3.0), e -> true
                                                                     )
                                                                     .stream()
                                                                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxxx)))
                                                                     .toList()) {
                                                                     if (entityiteratorxxxxxxxxx instanceof LivingEntity
                                                                        && !(entityiteratorxxxxxxxxx instanceof NamelessEntity)) {
                                                                        if (entityiteratorxxxxxxxxx instanceof LivingEntity) {
                                                                           LivingEntity _livEnt58 = (LivingEntity)entityiteratorxxxxxxxxx;
                                                                           if (_livEnt58.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                              continue;
                                                                           }
                                                                        }

                                                                        double _setvalxxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxxx.getCapability(
                                                                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                                 )
                                                                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                              .Rotting
                                                                           + 1.0;
                                                                        entityiteratorxxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .ifPresent(capability -> {
                                                                              capability.Rotting = _setvalxxxxxxxxx;
                                                                              capability.syncPlayerVariables(entityiteratorxxxxxxxxx);
                                                                           });
                                                                     }
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
      MokelsBossfightSaphyraMod.queueServerWork(
         20,
         () -> {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity && !(entityiterator instanceof NamelessEntity)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt74 = (LivingEntity)entityiterator;
                     if (_livEnt74.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                        continue;
                     }
                  }

                  double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                           )
                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                        .Rotting
                     + 1.0;
                  entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.Rotting = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               2,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                  }

                  Vec3 _centerx = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(3.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerx)))
                     .toList()) {
                     if (entityiteratorx instanceof LivingEntity && !(entityiteratorx instanceof NamelessEntity)) {
                        if (entityiteratorx instanceof LivingEntity) {
                           LivingEntity _livEnt80 = (LivingEntity)entityiteratorx;
                           if (_livEnt80.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                              continue;
                           }
                        }

                        double _setvalx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorx.getCapability(
                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                 )
                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                              .Rotting
                           + 1.0;
                        entityiteratorx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.Rotting = _setvalx;
                           capability.syncPlayerVariables(entityiteratorx);
                        });
                     }
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     2,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                        }

                        Vec3 _centerxx = new Vec3(x, y, z);

                        for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxx, _centerxx).inflate(3.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxx)))
                           .toList()) {
                           if (entityiteratorxx instanceof LivingEntity && !(entityiteratorxx instanceof NamelessEntity)) {
                              if (entityiteratorxx instanceof LivingEntity) {
                                 LivingEntity _livEnt86 = (LivingEntity)entityiteratorxx;
                                 if (_livEnt86.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                    continue;
                                 }
                              }

                              double _setvalxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                          MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                       )
                                       .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                    .Rotting
                                 + 1.0;
                              entityiteratorxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                 capability.Rotting = _setvalxx;
                                 capability.syncPlayerVariables(entityiteratorxx);
                              });
                           }
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           2,
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              Vec3 _centerxxx = new Vec3(x, y, z);

                              for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxx, _centerxxx).inflate(3.0), e -> true)
                                 .stream()
                                 .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxx)))
                                 .toList()) {
                                 if (entityiteratorxxx instanceof LivingEntity && !(entityiteratorxxx instanceof NamelessEntity)) {
                                    if (entityiteratorxxx instanceof LivingEntity) {
                                       LivingEntity _livEnt92 = (LivingEntity)entityiteratorxxx;
                                       if (_livEnt92.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                          continue;
                                       }
                                    }

                                    double _setvalxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxx.getCapability(
                                                MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                             )
                                             .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                          .Rotting
                                       + 1.0;
                                    entityiteratorxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .ifPresent(capability -> {
                                          capability.Rotting = _setvalxxx;
                                          capability.syncPlayerVariables(entityiteratorxxx);
                                       });
                                 }
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 2,
                                 () -> {
                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    Vec3 _centerxxxx = new Vec3(x, y, z);

                                    for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxxx, _centerxxxx).inflate(3.0), e -> true)
                                       .stream()
                                       .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxx)))
                                       .toList()) {
                                       if (entityiteratorxxxx instanceof LivingEntity && !(entityiteratorxxxx instanceof NamelessEntity)) {
                                          if (entityiteratorxxxx instanceof LivingEntity) {
                                             LivingEntity _livEnt98 = (LivingEntity)entityiteratorxxxx;
                                             if (_livEnt98.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                continue;
                                             }
                                          }

                                          double _setvalxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxx.getCapability(
                                                      MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                   )
                                                   .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                .Rotting
                                             + 1.0;
                                          entityiteratorxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                             .ifPresent(capability -> {
                                                capability.Rotting = _setvalxxxx;
                                                capability.syncPlayerVariables(entityiteratorxxxx);
                                             });
                                       }
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       2,
                                       () -> {
                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                20,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                15,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          Vec3 _centerxxxxx = new Vec3(x, y, z);

                                          for (Entity entityiteratorxxxxx : world.getEntitiesOfClass(
                                                Entity.class, new AABB(_centerxxxxx, _centerxxxxx).inflate(3.0), e -> true
                                             )
                                             .stream()
                                             .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxx)))
                                             .toList()) {
                                             if (entityiteratorxxxxx instanceof LivingEntity && !(entityiteratorxxxxx instanceof NamelessEntity)) {
                                                if (entityiteratorxxxxx instanceof LivingEntity) {
                                                   LivingEntity _livEnt104 = (LivingEntity)entityiteratorxxxxx;
                                                   if (_livEnt104.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                      continue;
                                                   }
                                                }

                                                double _setvalxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxx.getCapability(
                                                            MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                         )
                                                         .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                      .Rotting
                                                   + 1.0;
                                                entityiteratorxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                   .ifPresent(capability -> {
                                                      capability.Rotting = _setvalxxxxx;
                                                      capability.syncPlayerVariables(entityiteratorxxxxx);
                                                   });
                                             }
                                          }

                                          MokelsBossfightSaphyraMod.queueServerWork(
                                             2,
                                             () -> {
                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      20,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      15,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                Vec3 _centerxxxxxx = new Vec3(x, y, z);

                                                for (Entity entityiteratorxxxxxx : world.getEntitiesOfClass(
                                                      Entity.class, new AABB(_centerxxxxxx, _centerxxxxxx).inflate(3.0), e -> true
                                                   )
                                                   .stream()
                                                   .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxx)))
                                                   .toList()) {
                                                   if (entityiteratorxxxxxx instanceof LivingEntity && !(entityiteratorxxxxxx instanceof NamelessEntity)) {
                                                      if (entityiteratorxxxxxx instanceof LivingEntity) {
                                                         LivingEntity _livEnt110 = (LivingEntity)entityiteratorxxxxxx;
                                                         if (_livEnt110.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                            continue;
                                                         }
                                                      }

                                                      double _setvalxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                            .Rotting
                                                         + 1.0;
                                                      entityiteratorxxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                         .ifPresent(capability -> {
                                                            capability.Rotting = _setvalxxxxxx;
                                                            capability.syncPlayerVariables(entityiteratorxxxxxx);
                                                         });
                                                   }
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   2,
                                                   () -> {
                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            20,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            15,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      Vec3 _centerxxxxxxx = new Vec3(x, y, z);

                                                      for (Entity entityiteratorxxxxxxx : world.getEntitiesOfClass(
                                                            Entity.class, new AABB(_centerxxxxxxx, _centerxxxxxxx).inflate(3.0), e -> true
                                                         )
                                                         .stream()
                                                         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxx)))
                                                         .toList()) {
                                                         if (entityiteratorxxxxxxx instanceof LivingEntity
                                                            && !(entityiteratorxxxxxxx instanceof NamelessEntity)) {
                                                            if (entityiteratorxxxxxxx instanceof LivingEntity) {
                                                               LivingEntity _livEnt116 = (LivingEntity)entityiteratorxxxxxxx;
                                                               if (_livEnt116.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                  continue;
                                                               }
                                                            }

                                                            double _setvalxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                  .Rotting
                                                               + 1.0;
                                                            entityiteratorxxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .ifPresent(capability -> {
                                                                  capability.Rotting = _setvalxxxxxxx;
                                                                  capability.syncPlayerVariables(entityiteratorxxxxxxx);
                                                               });
                                                         }
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         2,
                                                         () -> {
                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  20,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  15,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            Vec3 _centerxxxxxxxx = new Vec3(x, y, z);

                                                            for (Entity entityiteratorxxxxxxxx : world.getEntitiesOfClass(
                                                                  Entity.class, new AABB(_centerxxxxxxxx, _centerxxxxxxxx).inflate(3.0), e -> true
                                                               )
                                                               .stream()
                                                               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxx)))
                                                               .toList()) {
                                                               if (entityiteratorxxxxxxxx instanceof LivingEntity
                                                                  && !(entityiteratorxxxxxxxx instanceof NamelessEntity)) {
                                                                  if (entityiteratorxxxxxxxx instanceof LivingEntity) {
                                                                     LivingEntity _livEnt122 = (LivingEntity)entityiteratorxxxxxxxx;
                                                                     if (_livEnt122.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                        continue;
                                                                     }
                                                                  }

                                                                  double _setvalxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                        .Rotting
                                                                     + 1.0;
                                                                  entityiteratorxxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .ifPresent(capability -> {
                                                                        capability.Rotting = _setvalxxxxxxxx;
                                                                        capability.syncPlayerVariables(entityiteratorxxxxxxxx);
                                                                     });
                                                               }
                                                            }

                                                            MokelsBossfightSaphyraMod.queueServerWork(
                                                               2,
                                                               () -> {
                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        20,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        15,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  Vec3 _centerxxxxxxxxx = new Vec3(x, y, z);

                                                                  for (Entity entityiteratorxxxxxxxxx : world.getEntitiesOfClass(
                                                                        Entity.class, new AABB(_centerxxxxxxxxx, _centerxxxxxxxxx).inflate(3.0), e -> true
                                                                     )
                                                                     .stream()
                                                                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxxx)))
                                                                     .toList()) {
                                                                     if (entityiteratorxxxxxxxxx instanceof LivingEntity
                                                                        && !(entityiteratorxxxxxxxxx instanceof NamelessEntity)) {
                                                                        if (entityiteratorxxxxxxxxx instanceof LivingEntity) {
                                                                           LivingEntity _livEnt128 = (LivingEntity)entityiteratorxxxxxxxxx;
                                                                           if (_livEnt128.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())
                                                                              )
                                                                            {
                                                                              continue;
                                                                           }
                                                                        }

                                                                        double _setvalxxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxxx.getCapability(
                                                                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                                 )
                                                                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                              .Rotting
                                                                           + 1.0;
                                                                        entityiteratorxxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .ifPresent(capability -> {
                                                                              capability.Rotting = _setvalxxxxxxxxx;
                                                                              capability.syncPlayerVariables(entityiteratorxxxxxxxxx);
                                                                           });
                                                                     }
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
      MokelsBossfightSaphyraMod.queueServerWork(
         40,
         () -> {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity && !(entityiterator instanceof NamelessEntity)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt144 = (LivingEntity)entityiterator;
                     if (_livEnt144.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                        continue;
                     }
                  }

                  double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                           )
                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                        .Rotting
                     + 1.0;
                  entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.Rotting = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               2,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                  }

                  Vec3 _centerx = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(3.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerx)))
                     .toList()) {
                     if (entityiteratorx instanceof LivingEntity && !(entityiteratorx instanceof NamelessEntity)) {
                        if (entityiteratorx instanceof LivingEntity) {
                           LivingEntity _livEnt150 = (LivingEntity)entityiteratorx;
                           if (_livEnt150.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                              continue;
                           }
                        }

                        double _setvalx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorx.getCapability(
                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                 )
                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                              .Rotting
                           + 1.0;
                        entityiteratorx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.Rotting = _setvalx;
                           capability.syncPlayerVariables(entityiteratorx);
                        });
                     }
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     2,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01);
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01);
                        }

                        Vec3 _centerxx = new Vec3(x, y, z);

                        for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxx, _centerxx).inflate(3.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxx)))
                           .toList()) {
                           if (entityiteratorxx instanceof LivingEntity && !(entityiteratorxx instanceof NamelessEntity)) {
                              if (entityiteratorxx instanceof LivingEntity) {
                                 LivingEntity _livEnt156 = (LivingEntity)entityiteratorxx;
                                 if (_livEnt156.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                    continue;
                                 }
                              }

                              double _setvalxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                          MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                       )
                                       .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                    .Rotting
                                 + 1.0;
                              entityiteratorxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                 capability.Rotting = _setvalxx;
                                 capability.syncPlayerVariables(entityiteratorxx);
                              });
                           }
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           2,
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                 );
                              }

                              Vec3 _centerxxx = new Vec3(x, y, z);

                              for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxx, _centerxxx).inflate(3.0), e -> true)
                                 .stream()
                                 .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxx)))
                                 .toList()) {
                                 if (entityiteratorxxx instanceof LivingEntity && !(entityiteratorxxx instanceof NamelessEntity)) {
                                    if (entityiteratorxxx instanceof LivingEntity) {
                                       LivingEntity _livEnt162 = (LivingEntity)entityiteratorxxx;
                                       if (_livEnt162.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                          continue;
                                       }
                                    }

                                    double _setvalxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxx.getCapability(
                                                MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                             )
                                             .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                          .Rotting
                                       + 1.0;
                                    entityiteratorxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .ifPresent(capability -> {
                                          capability.Rotting = _setvalxxx;
                                          capability.syncPlayerVariables(entityiteratorxxx);
                                       });
                                 }
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 2,
                                 () -> {
                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    if (world instanceof ServerLevel _level) {
                                       _level.sendParticles(
                                          (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 15, 0.5, 0.5, 0.5, 0.01
                                       );
                                    }

                                    Vec3 _centerxxxx = new Vec3(x, y, z);

                                    for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerxxxx, _centerxxxx).inflate(3.0), e -> true)
                                       .stream()
                                       .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxx)))
                                       .toList()) {
                                       if (entityiteratorxxxx instanceof LivingEntity && !(entityiteratorxxxx instanceof NamelessEntity)) {
                                          if (entityiteratorxxxx instanceof LivingEntity) {
                                             LivingEntity _livEnt168 = (LivingEntity)entityiteratorxxxx;
                                             if (_livEnt168.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                continue;
                                             }
                                          }

                                          double _setvalxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxx.getCapability(
                                                      MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                   )
                                                   .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                .Rotting
                                             + 1.0;
                                          entityiteratorxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                             .ifPresent(capability -> {
                                                capability.Rotting = _setvalxxxx;
                                                capability.syncPlayerVariables(entityiteratorxxxx);
                                             });
                                       }
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       2,
                                       () -> {
                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                20,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          if (world instanceof ServerLevel _level) {
                                             _level.sendParticles(
                                                (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                x,
                                                y,
                                                z,
                                                15,
                                                0.5,
                                                0.5,
                                                0.5,
                                                0.01
                                             );
                                          }

                                          Vec3 _centerxxxxx = new Vec3(x, y, z);

                                          for (Entity entityiteratorxxxxx : world.getEntitiesOfClass(
                                                Entity.class, new AABB(_centerxxxxx, _centerxxxxx).inflate(3.0), e -> true
                                             )
                                             .stream()
                                             .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxx)))
                                             .toList()) {
                                             if (entityiteratorxxxxx instanceof LivingEntity && !(entityiteratorxxxxx instanceof NamelessEntity)) {
                                                if (entityiteratorxxxxx instanceof LivingEntity) {
                                                   LivingEntity _livEnt174 = (LivingEntity)entityiteratorxxxxx;
                                                   if (_livEnt174.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                      continue;
                                                   }
                                                }

                                                double _setvalxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxx.getCapability(
                                                            MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                         )
                                                         .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                      .Rotting
                                                   + 1.0;
                                                entityiteratorxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                   .ifPresent(capability -> {
                                                      capability.Rotting = _setvalxxxxx;
                                                      capability.syncPlayerVariables(entityiteratorxxxxx);
                                                   });
                                             }
                                          }

                                          MokelsBossfightSaphyraMod.queueServerWork(
                                             2,
                                             () -> {
                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      20,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                if (world instanceof ServerLevel _level) {
                                                   _level.sendParticles(
                                                      (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                      x,
                                                      y,
                                                      z,
                                                      15,
                                                      0.5,
                                                      0.5,
                                                      0.5,
                                                      0.01
                                                   );
                                                }

                                                Vec3 _centerxxxxxx = new Vec3(x, y, z);

                                                for (Entity entityiteratorxxxxxx : world.getEntitiesOfClass(
                                                      Entity.class, new AABB(_centerxxxxxx, _centerxxxxxx).inflate(3.0), e -> true
                                                   )
                                                   .stream()
                                                   .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxx)))
                                                   .toList()) {
                                                   if (entityiteratorxxxxxx instanceof LivingEntity && !(entityiteratorxxxxxx instanceof NamelessEntity)) {
                                                      if (entityiteratorxxxxxx instanceof LivingEntity) {
                                                         LivingEntity _livEnt180 = (LivingEntity)entityiteratorxxxxxx;
                                                         if (_livEnt180.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                            continue;
                                                         }
                                                      }

                                                      double _setvalxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                            .Rotting
                                                         + 1.0;
                                                      entityiteratorxxxxxx.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                         .ifPresent(capability -> {
                                                            capability.Rotting = _setvalxxxxxx;
                                                            capability.syncPlayerVariables(entityiteratorxxxxxx);
                                                         });
                                                   }
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   2,
                                                   () -> {
                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            20,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      if (world instanceof ServerLevel _level) {
                                                         _level.sendParticles(
                                                            (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                            x,
                                                            y,
                                                            z,
                                                            15,
                                                            0.5,
                                                            0.5,
                                                            0.5,
                                                            0.01
                                                         );
                                                      }

                                                      Vec3 _centerxxxxxxx = new Vec3(x, y, z);

                                                      for (Entity entityiteratorxxxxxxx : world.getEntitiesOfClass(
                                                            Entity.class, new AABB(_centerxxxxxxx, _centerxxxxxxx).inflate(3.0), e -> true
                                                         )
                                                         .stream()
                                                         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxx)))
                                                         .toList()) {
                                                         if (entityiteratorxxxxxxx instanceof LivingEntity
                                                            && !(entityiteratorxxxxxxx instanceof NamelessEntity)) {
                                                            if (entityiteratorxxxxxxx instanceof LivingEntity) {
                                                               LivingEntity _livEnt186 = (LivingEntity)entityiteratorxxxxxxx;
                                                               if (_livEnt186.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                  continue;
                                                               }
                                                            }

                                                            double _setvalxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                  .Rotting
                                                               + 1.0;
                                                            entityiteratorxxxxxxx.getCapability(
                                                                  MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .ifPresent(capability -> {
                                                                  capability.Rotting = _setvalxxxxxxx;
                                                                  capability.syncPlayerVariables(entityiteratorxxxxxxx);
                                                               });
                                                         }
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         2,
                                                         () -> {
                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  20,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            if (world instanceof ServerLevel _level) {
                                                               _level.sendParticles(
                                                                  (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                  x,
                                                                  y,
                                                                  z,
                                                                  15,
                                                                  0.5,
                                                                  0.5,
                                                                  0.5,
                                                                  0.01
                                                               );
                                                            }

                                                            Vec3 _centerxxxxxxxx = new Vec3(x, y, z);

                                                            for (Entity entityiteratorxxxxxxxx : world.getEntitiesOfClass(
                                                                  Entity.class, new AABB(_centerxxxxxxxx, _centerxxxxxxxx).inflate(3.0), e -> true
                                                               )
                                                               .stream()
                                                               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxx)))
                                                               .toList()) {
                                                               if (entityiteratorxxxxxxxx instanceof LivingEntity
                                                                  && !(entityiteratorxxxxxxxx instanceof NamelessEntity)) {
                                                                  if (entityiteratorxxxxxxxx instanceof LivingEntity) {
                                                                     LivingEntity _livEnt192 = (LivingEntity)entityiteratorxxxxxxxx;
                                                                     if (_livEnt192.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                                        continue;
                                                                     }
                                                                  }

                                                                  double _setvalxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                        .Rotting
                                                                     + 1.0;
                                                                  entityiteratorxxxxxxxx.getCapability(
                                                                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                     )
                                                                     .ifPresent(capability -> {
                                                                        capability.Rotting = _setvalxxxxxxxx;
                                                                        capability.syncPlayerVariables(entityiteratorxxxxxxxx);
                                                                     });
                                                               }
                                                            }

                                                            MokelsBossfightSaphyraMod.queueServerWork(
                                                               2,
                                                               () -> {
                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        20,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  if (world instanceof ServerLevel _level) {
                                                                     _level.sendParticles(
                                                                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(),
                                                                        x,
                                                                        y,
                                                                        z,
                                                                        15,
                                                                        0.5,
                                                                        0.5,
                                                                        0.5,
                                                                        0.01
                                                                     );
                                                                  }

                                                                  Vec3 _centerxxxxxxxxx = new Vec3(x, y, z);

                                                                  for (Entity entityiteratorxxxxxxxxx : world.getEntitiesOfClass(
                                                                        Entity.class, new AABB(_centerxxxxxxxxx, _centerxxxxxxxxx).inflate(3.0), e -> true
                                                                     )
                                                                     .stream()
                                                                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerxxxxxxxxx)))
                                                                     .toList()) {
                                                                     if (entityiteratorxxxxxxxxx instanceof LivingEntity
                                                                        && !(entityiteratorxxxxxxxxx instanceof NamelessEntity)) {
                                                                        if (entityiteratorxxxxxxxxx instanceof LivingEntity) {
                                                                           LivingEntity _livEnt198 = (LivingEntity)entityiteratorxxxxxxxxx;
                                                                           if (_livEnt198.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())
                                                                              )
                                                                            {
                                                                              continue;
                                                                           }
                                                                        }

                                                                        double _setvalxxxxxxxxx = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiteratorxxxxxxxxx.getCapability(
                                                                                    MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                                 )
                                                                                 .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                                              .Rotting
                                                                           + 1.0;
                                                                        entityiteratorxxxxxxxxx.getCapability(
                                                                              MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                                           )
                                                                           .ifPresent(capability -> {
                                                                              capability.Rotting = _setvalxxxxxxxxx;
                                                                              capability.syncPlayerVariables(entityiteratorxxxxxxxxx);
                                                                           });
                                                                     }
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
      MokelsBossfightSaphyraMod.queueServerWork(
         60,
         () -> {
            for (int index0 = 0; index0 < 3; index0++) {
               if (world instanceof ServerLevel projectileLevel) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new NamelessProjectileFallEntity(
                              (EntityType<? extends NamelessProjectileFallEntity>)MokelsBossfightSaphyraModEntities.NAMELESS_PROJECTILE_FALL.get(), level
                           );
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, 0.0F, 1);
                  _entityToSpawn.setPos(x, y + 1.0, z);
                  _entityToSpawn.shoot(0.0, 90.0, 0.0, 0.7F, 15.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }
         }
      );
   }
}

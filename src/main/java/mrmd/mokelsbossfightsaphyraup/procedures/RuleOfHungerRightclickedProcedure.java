package mrmd.mokelsbossfightsaphyraup.procedures;

import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.DisgustProjectileFallEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class RuleOfHungerRightclickedProcedure {
   @SubscribeEvent
   public static void onRightClickItem(RightClickItem event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         double baseRate = 0.0;
         double rateWithAmplifier = 0.0;
         if (MokelsBossfightSaphyraModItems.RULE_OF_HUNGER.get()
            == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((Item)MokelsBossfightSaphyraModItems.RULE_OF_HUNGER.get(), 120);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.COOLDOWN.get(), 30, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.STAY_STILL.get(), 30, 1, false, false));
            }

            if (entity.isAlive()) {
               for (int index0 = 0; index0 < 2; index0++) {
                  MokelsBossfightSaphyraMod.queueServerWork(
                     2,
                     () -> {
                        Level projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                       (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL.get(),
                                       level
                                    );
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           2,
                           () -> {
                              Level projectileLevelx = entity.level();
                              if (!projectileLevelx.isClientSide()) {
                                 Projectile _entityToSpawnx = (new Object() {
                                       public Projectile getArrow(Level level, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                             (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL.get(),
                                             level
                                          );
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevelx, 5.0F, 1);
                                 _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                 _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F);
                                 projectileLevelx.addFreshEntity(_entityToSpawnx);
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 2,
                                 () -> {
                                    Level projectileLevelxx = entity.level();
                                    if (!projectileLevelxx.isClientSide()) {
                                       Projectile _entityToSpawnxx = (new Object() {
                                             public Projectile getArrow(Level level, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                   (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                      .get(),
                                                   level
                                                );
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelxx, 5.0F, 1);
                                       _entityToSpawnxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F);
                                       projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       2,
                                       () -> {
                                          Level projectileLevelxxx = entity.level();
                                          if (!projectileLevelxxx.isClientSide()) {
                                             Projectile _entityToSpawnxxx = (new Object() {
                                                   public Projectile getArrow(Level level, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                         (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                            .get(),
                                                         level
                                                      );
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxxx, 5.0F, 1);
                                             _entityToSpawnxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxx.shoot(
                                                entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F
                                             );
                                             projectileLevelxxx.addFreshEntity(_entityToSpawnxxx);
                                          }

                                          MokelsBossfightSaphyraMod.queueServerWork(
                                             2,
                                             () -> {
                                                Level projectileLevelxxxx = entity.level();
                                                if (!projectileLevelxxxx.isClientSide()) {
                                                   Projectile _entityToSpawnxxxx = (new Object() {
                                                         public Projectile getArrow(Level level, float damage, int knockback) {
                                                            AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                               (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                                  .get(),
                                                               level
                                                            );
                                                            entityToSpawn.setBaseDamage((double)damage);
                                                            entityToSpawn.setKnockback(knockback);
                                                            entityToSpawn.setSilent(true);
                                                            return entityToSpawn;
                                                         }
                                                      })
                                                      .getArrow(projectileLevelxxxx, 5.0F, 1);
                                                   _entityToSpawnxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                   _entityToSpawnxxxx.shoot(
                                                      entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F
                                                   );
                                                   projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxx);
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   2,
                                                   () -> {
                                                      Level projectileLevelxxxxx = entity.level();
                                                      if (!projectileLevelxxxxx.isClientSide()) {
                                                         Projectile _entityToSpawnxxxxx = (new Object() {
                                                               public Projectile getArrow(Level level, float damage, int knockback) {
                                                                  AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                                     (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                                        .get(),
                                                                     level
                                                                  );
                                                                  entityToSpawn.setBaseDamage((double)damage);
                                                                  entityToSpawn.setKnockback(knockback);
                                                                  entityToSpawn.setSilent(true);
                                                                  return entityToSpawn;
                                                               }
                                                            })
                                                            .getArrow(projectileLevelxxxxx, 5.0F, 1);
                                                         _entityToSpawnxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                         _entityToSpawnxxxxx.shoot(
                                                            entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.2F, 45.0F
                                                         );
                                                         projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxx);
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         2,
                                                         () -> {
                                                            Level projectileLevelxxxxxx = entity.level();
                                                            if (!projectileLevelxxxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                                           (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                                              .get(),
                                                                           level
                                                                        );
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxxxx, 5.0F, 1);
                                                               _entityToSpawnxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxx.shoot(
                                                                  entity.getLookAngle().x,
                                                                  entity.getLookAngle().y,
                                                                  entity.getLookAngle().z,
                                                                  1.2F,
                                                                  45.0F
                                                               );
                                                               projectileLevelxxxxxx.addFreshEntity(_entityToSpawnxxxxxx);
                                                            }

                                                            MokelsBossfightSaphyraMod.queueServerWork(
                                                               2,
                                                               () -> {
                                                                  Level projectileLevelxxxxxxx = entity.level();
                                                                  if (!projectileLevelxxxxxxx.isClientSide()) {
                                                                     Projectile _entityToSpawnxxxxxxx = (new Object() {
                                                                           public Projectile getArrow(Level level, float damage, int knockback) {
                                                                              AbstractArrow entityToSpawn = new DisgustProjectileFallEntity(
                                                                                 (EntityType<? extends DisgustProjectileFallEntity>)MokelsBossfightSaphyraModEntities.DISGUST_PROJECTILE_FALL
                                                                                    .get(),
                                                                                 level
                                                                              );
                                                                              entityToSpawn.setBaseDamage((double)damage);
                                                                              entityToSpawn.setKnockback(knockback);
                                                                              entityToSpawn.setSilent(true);
                                                                              return entityToSpawn;
                                                                           }
                                                                        })
                                                                        .getArrow(projectileLevelxxxxxxx, 5.0F, 1);
                                                                     _entityToSpawnxxxxxxx.setPos(
                                                                        entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                     );
                                                                     _entityToSpawnxxxxxxx.shoot(
                                                                        entity.getLookAngle().x,
                                                                        entity.getLookAngle().y,
                                                                        entity.getLookAngle().z,
                                                                        1.2F,
                                                                        45.0F
                                                                     );
                                                                     projectileLevelxxxxxxx.addFreshEntity(_entityToSpawnxxxxxxx);
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
            }
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SaphyraAttackPatternFinalProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 40.0) {
            if (Math.random() <= 0.5) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("slashattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 100, false, false));
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     19,
                     () -> {
                        if (entity.isAlive()) {
                           Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (!(entityiterator instanceof WitchbossEntity)
                                 && !world.isEmptyBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + -0.25, entityiterator.getZ()))
                                 )
                               {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 20.0F
                                 );
                              }
                           }

                           if (world instanceof Level _level) {
                              if (!_level.isClientSide()) {
                                 _level.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                 );
                              } else {
                                 _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
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
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 100, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  22,
                  () -> {
                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (!(entityiterator instanceof WitchbossEntity)
                              && !world.isEmptyBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + -0.25, entityiterator.getZ()))) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 26.0F);
                           }
                        }

                        if (world instanceof Level _level) {
                           if (!_level.isClientSide()) {
                              _level.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 0.5F
                              );
                           } else {
                              _level.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 0.5F,
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
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 110.0) {
            if (Math.random() <= 0.5) {
               if (entity.isAlive()) {
                  if (entity instanceof WitchbossEntity) {
                     ((WitchbossEntity)entity).setAnimation("rainattack");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 55, 100, false, false));
                  }
               }
            } else if (Math.random() <= 1.0 && entity.isAlive()) {
               if (entity instanceof WitchbossEntity) {
                  ((WitchbossEntity)entity).setAnimation("jumpattack");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 100, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 70, 2, false, false));
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  50,
                  () -> {
                     if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 100, false, false));
                     }

                     if (entity.isAlive()) {
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (!(entityiterator instanceof WitchbossEntity)
                              && !world.isEmptyBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + -0.25, entityiterator.getZ()))) {
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 26.0F);
                           }
                        }
                     }
                  }
               );
            }
         }
      }
   }
}

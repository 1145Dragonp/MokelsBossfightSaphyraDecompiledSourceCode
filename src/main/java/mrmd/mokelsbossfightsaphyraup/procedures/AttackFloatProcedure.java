package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackFloatProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive() && (!(entity instanceof LivingEntity _livEnt1) || !_livEnt1.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            MokelsBossfightSaphyraMod.queueServerWork(
               1,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt2) || !_livEnt2.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                     && entity.isAlive()) {
                     entity.setDeltaMovement(new Vec3(-1.0 * entity.getLookAngle().x, 1.5, -1.0 * entity.getLookAngle().z));
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.POOF, entity.getX(), entity.getY(), entity.getZ(), 10, 0.5, 0.5, 0.5, 0.1);
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        20,
                        () -> {
                           if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get())) {
                              return;
                           }

                           if (entity instanceof NamelessEntity) {
                              ((NamelessEntity)entity).setAnimation("attackfloat");
                           }

                           if (entity.isAlive()) {
                              entity.setDeltaMovement(
                                 new Vec3(
                                    ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - entity.getX()) * 0.5
                                       - ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX() - entity.getX()) * 0.15,
                                    ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY() - entity.getY()) * 0.5
                                       - ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() - entity.getY()) * 0.15
                                       + 0.15,
                                    ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() - entity.getZ()) * 0.5
                                       - ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.15
                                 )
                              );
                              MokelsBossfightSaphyraMod.queueServerWork(
                                 3,
                                 () -> {
                                    if ((
                                          !(entity instanceof LivingEntity _livEnt33)
                                             || !_livEnt33.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get())
                                       )
                                       && entity.isAlive()) {
                                       entity.setDeltaMovement(new Vec3(0.0, -0.5, 0.0));
                                       if (world instanceof Level _levelx) {
                                          if (!_levelx.isClientSide()) {
                                             _levelx.playSound(
                                                null,
                                                BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                                                (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                                SoundSource.NEUTRAL,
                                                2.0F,
                                                1.0F
                                             );
                                          } else {
                                             _levelx.playLocalSound(
                                                entity.getX(),
                                                entity.getY(),
                                                entity.getZ(),
                                                (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")),
                                                SoundSource.NEUTRAL,
                                                2.0F,
                                                1.0F,
                                                false
                                             );
                                          }
                                       }

                                       Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                                       for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                                          .stream()
                                          .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                          .toList()) {
                                          if (!(entityiterator instanceof NamelessEntity) && entityiterator instanceof LivingEntity) {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt45 = (LivingEntity)entityiterator;
                                                if (_livEnt45.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                                   continue;
                                                }
                                             }

                                             entityiterator.hurt(
                                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
                                                14.0F
                                             );
                                             double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                                                         MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                      )
                                                      .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                                   .Rotting
                                                + 10.0;
                                             entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                .ifPresent(capability -> {
                                                   capability.Rotting = _setval;
                                                   capability.syncPlayerVariables(entityiterator);
                                                });
                                          }
                                       }
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
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackJumpAttackProcedure {
   public static void execute(LevelAccessor world, double x, double z, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof WitchbossEntity) {
               ((WitchbossEntity)entity).setAnimation("jumpattack");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9, 100, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               50,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt4) || !_livEnt4.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))
                     && entity.isAlive()) {
                     if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 17, 100, false, false));
                     }

                     if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                           _level.playSound(
                              null,
                              BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F
                           );
                        } else {
                           _level.playLocalSound(
                              entity.getX(),
                              entity.getY(),
                              entity.getZ(),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                              SoundSource.NEUTRAL,
                              2.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           ParticleTypes.EXPLOSION,
                           entity.getX() + entity.getLookAngle().x * 4.0,
                           entity.getY(),
                           entity.getZ() + entity.getLookAngle().z * 4.0,
                           100,
                           3.0,
                           0.5,
                           3.0,
                           0.01
                        );
                     }

                     Vec3 _center = new Vec3(
                        entity.getX() + entity.getLookAngle().x * 4.0, entity.getY(), entity.getZ() + entity.getLookAngle().z * 4.0
                     );

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiterator instanceof WitchbossEntity) && entityiterator instanceof LivingEntity) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt20 = (LivingEntity)entityiterator;
                              if (_livEnt20.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
                                 continue;
                              }
                           }

                           entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 14.0F);
                           double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                                       MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                                 .Grief
                              + 20.0;
                           entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.Grief = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        }
                     }
                  }
               }
            );
         }
      }
   }
}

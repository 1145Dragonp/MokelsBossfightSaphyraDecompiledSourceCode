package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SaphyraSpawnOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 1.0) {
            MokelsBossfightSaphyraMod.queueServerWork(
               20,
               () -> {
                  if (entity.isAlive()) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Welcome, to the very heart of our universe."), false);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                           entity.getX(),
                           entity.getY() + 1.0,
                           entity.getZ(),
                           25,
                           0.2,
                           0.2,
                           0.2,
                           0.1
                        );
                     }
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     160,
                     () -> {
                        if (entity.isAlive()) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: And the birthplace of Meryd and the white flame."), false);
                           }

                           if (world instanceof ServerLevel _levelxx) {
                              _levelxx.sendParticles(
                                 (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                 entity.getX(),
                                 entity.getY() + 1.0,
                                 entity.getZ(),
                                 50,
                                 0.2,
                                 0.2,
                                 0.2,
                                 0.1
                              );
                           }
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           160,
                           () -> {
                              if (entity.isAlive()) {
                                 if (!world.isClientSide() && world.getServer() != null) {
                                    world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: I urge thou not to hold back."), false);
                                 }

                                 if (world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.sendParticles(
                                       (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                       entity.getX(),
                                       entity.getY() + 1.0,
                                       entity.getZ(),
                                       100,
                                       0.2,
                                       0.2,
                                       0.2,
                                       0.1
                                    );
                                 }
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 100,
                                 () -> {
                                    if (entity.isAlive()) {
                                       if (!world.isClientSide() && world.getServer() != null) {
                                          world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Well then, let us begin."), false);
                                       }

                                       if (world instanceof ServerLevel _levelxxxx) {
                                          _levelxxxx.sendParticles(
                                             (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                             entity.getX(),
                                             entity.getY() + 1.0,
                                             entity.getZ(),
                                             150,
                                             0.2,
                                             0.2,
                                             0.2,
                                             0.1
                                          );
                                       }
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       80,
                                       () -> {
                                          if (entity.isAlive()) {
                                             if (!entity.level().isClientSide()) {
                                                entity.discard();
                                             }

                                             if (world instanceof ServerLevel _levelxxxxxx) {
                                                Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.WITCHBOSS.get())
                                                   .spawn(
                                                      _levelxxxxxx,
                                                      BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                                                      MobSpawnType.MOB_SUMMONED
                                                   );
                                                if (entityToSpawn != null) {
                                                   entityToSpawn.setYRot(entity.getYRot());
                                                   entityToSpawn.setYBodyRot(entity.getYRot());
                                                   entityToSpawn.setYHeadRot(entity.getYRot());
                                                   entityToSpawn.setXRot(entity.getXRot());
                                                   entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                                }
                                             }

                                             if (world instanceof ServerLevel _levelx) {
                                                _levelx.sendParticles(
                                                   (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                                   entity.getX(),
                                                   entity.getY() + 1.0,
                                                   entity.getZ(),
                                                   200,
                                                   0.2,
                                                   0.2,
                                                   0.2,
                                                   0.2
                                                );
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

         Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if ((new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL
                              : false;
                        }
                     }
                  })
                  .checkGamemode(entityiterator)
               && (entityiterator instanceof Player || entityiterator instanceof ServerPlayer)
               && entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.STAY_STILL.get(), 5, 1, false, false));
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
               entity.getX(),
               entity.getY() + 1.0,
               entity.getZ(),
               8,
               0.1,
               0.1,
               0.1,
               0.03
            );
         }
      }
   }
}

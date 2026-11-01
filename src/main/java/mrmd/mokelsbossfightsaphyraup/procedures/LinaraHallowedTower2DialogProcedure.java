package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LinaraHallowedTower2DialogProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         MokelsBossfightSaphyraMod.queueServerWork(
            20,
            () -> {
               if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: I bid thee for forgiveness"), false);
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  100,
                  () -> {
                     if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                        world.getServer()
                           .getPlayerList()
                           .broadcastSystemMessage(Component.literal("Linara: My goal was to find out how resistant thou are against the vile curse called manic"), false);
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        200,
                        () -> {
                           if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: And here thee standeth before me."), false);
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(
                              120,
                              () -> {
                                 if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                    world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Without loosing your mind"), false);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    100,
                                    () -> {
                                       if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                          world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: So resistant..."), false);
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          80,
                                          () -> {
                                             if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: So powerful..."), false);
                                             }

                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                80,
                                                () -> {
                                                   if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                      world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: I have to go now."), false);
                                                   }

                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                      80,
                                                      () -> {
                                                         if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                            world.getServer()
                                                               .getPlayerList()
                                                               .broadcastSystemMessage(Component.literal("Linara: My duty is needed elsewhere."), false);
                                                         }

                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                            120,
                                                            () -> {
                                                               if (entity.isAlive()) {
                                                                  if (!world.isClientSide() && world.getServer() != null) {
                                                                     world.getServer()
                                                                        .getPlayerList()
                                                                        .broadcastSystemMessage(Component.literal("Linara: May we meet again."), false);
                                                                  }

                                                                  if (entity instanceof LinaraEntity) {
                                                                     ((LinaraEntity)entity).setAnimation("sky");
                                                                  }

                                                                  MokelsBossfightSaphyraMod.queueServerWork(
                                                                     70,
                                                                     () -> {
                                                                        if (entity.isAlive()) {
                                                                           if (!entity.level().isClientSide()) {
                                                                              entity.discard();
                                                                           }

                                                                           for (int index0 = 0; index0 < 3; index0++) {
                                                                              if (world instanceof ServerLevel _level) {
                                                                                 _level.sendParticles(
                                                                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.PURPLE_FLAME_PARTICLE
                                                                                       .get(),
                                                                                    entity.getX(),
                                                                                    entity.getY(),
                                                                                    entity.getZ(),
                                                                                    400,
                                                                                    0.2,
                                                                                    1.2,
                                                                                    0.2,
                                                                                    0.1
                                                                                 );
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  );
                                                               }

                                                               MokelsBossfightSaphyraMod.queueServerWork(160, () -> {
                                                                  if (!world.isClientSide() && world.getServer() != null) {
                                                                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Please..."), false);
                                                                  }

                                                                  MokelsBossfightSaphyraMod.queueServerWork(80, () -> {
                                                                     if (!world.isClientSide() && world.getServer() != null) {
                                                                        world.getServer()
                                                                           .getPlayerList()
                                                                           .broadcastSystemMessage(Component.literal("Linara: Do not give up..."), false);
                                                                     }

                                                                     MokelsBossfightSaphyraMod.queueServerWork(100, () -> {
                                                                        if (!world.isClientSide() && world.getServer() != null) {
                                                                           world.getServer()
                                                                              .getPlayerList()
                                                                              .broadcastSystemMessage(Component.literal("Linara: I believe in thou..."), false);
                                                                        }
                                                                     });
                                                                  });
                                                               });
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
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraHallowedTowerEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class LinaraTalkHallowedTowerProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         MokelsBossfightSaphyraMod.queueServerWork(
            20,
            () -> {
               if (entity.isAlive()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Hello again"), false);
                  }

                  if (entity instanceof LinaraHallowedTowerEntity) {
                     ((LinaraHallowedTowerEntity)entity).setAnimation("greetings");
                  }
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  80,
                  () -> {
                     if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: I watched thou fight against the Nameless Gatekeeper"), false);
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        160,
                        () -> {
                           if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: greatly done"), false);
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(
                              80,
                              () -> {
                                 if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                    world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: However..."), false);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    60,
                                    () -> {
                                       if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                          world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: The wind whispers to me. "), false);
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          100,
                                          () -> {
                                             if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                world.getServer()
                                                   .getPlayerList()
                                                   .broadcastSystemMessage(Component.literal("Linara: His rotten mind still taints the canvas of our world"), false);
                                             }

                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                140,
                                                () -> {
                                                   if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                      world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: ..."), false);
                                                   }

                                                   MokelsBossfightSaphyraMod.queueServerWork(
                                                      60,
                                                      () -> {
                                                         if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                            world.getServer()
                                                               .getPlayerList()
                                                               .broadcastSystemMessage(
                                                                  Component.literal("Linara: could thee go back to the church of the oath pus for me?"),
                                                                  false
                                                               );
                                                         }

                                                         MokelsBossfightSaphyraMod.queueServerWork(
                                                            160,
                                                            () -> {
                                                               if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                  world.getServer()
                                                                     .getPlayerList()
                                                                     .broadcastSystemMessage(Component.literal("Linara: I bear the key to a treasure room"), false);
                                                               }

                                                               MokelsBossfightSaphyraMod.queueServerWork(
                                                                  140,
                                                                  () -> {
                                                                     if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                        world.getServer()
                                                                           .getPlayerList()
                                                                           .broadcastSystemMessage(Component.literal("Linara: bring me the \"Manic Eye\""), false);
                                                                     }

                                                                     MokelsBossfightSaphyraMod.queueServerWork(
                                                                        100,
                                                                        () -> {
                                                                           if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                              world.getServer()
                                                                                 .getPlayerList()
                                                                                 .broadcastSystemMessage(
                                                                                    Component.literal(
                                                                                       "Linara: Thy payment shall be the rest of the treasure."
                                                                                    ),
                                                                                    false
                                                                                 );
                                                                           }

                                                                           MokelsBossfightSaphyraMod.queueServerWork(
                                                                              60,
                                                                              () -> {
                                                                                 if (entity.isAlive()) {
                                                                                    if (!world.isClientSide() && world.getServer() != null) {
                                                                                       world.getServer()
                                                                                          .getPlayerList()
                                                                                          .broadcastSystemMessage(Component.literal("Linara: Here, take the key"), false);
                                                                                    }

                                                                                    if (entity instanceof LinaraHallowedTowerEntity) {
                                                                                       ((LinaraHallowedTowerEntity)entity).setAnimation("give");
                                                                                    }

                                                                                    MokelsBossfightSaphyraMod.queueServerWork(
                                                                                       20,
                                                                                       () -> {
                                                                                          if (world instanceof ServerLevel _level) {
                                                                                             ItemEntity entityToSpawn = new ItemEntity(
                                                                                                _level,
                                                                                                entity.getX(),
                                                                                                entity.getY(),
                                                                                                entity.getZ(),
                                                                                                new ItemStack(
                                                                                                   (ItemLike)MokelsBossfightSaphyraModItems.KEY_3.get()
                                                                                                )
                                                                                             );
                                                                                             entityToSpawn.setPickUpDelay(0);
                                                                                             entityToSpawn.setUnlimitedLifetime();
                                                                                             _level.addFreshEntity(entityToSpawn);
                                                                                          }
                                                                                       }
                                                                                    );
                                                                                 }

                                                                                 MokelsBossfightSaphyraMod.queueServerWork(
                                                                                    100,
                                                                                    () -> {
                                                                                       if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                                          world.getServer()
                                                                                             .getPlayerList()
                                                                                             .broadcastSystemMessage(
                                                                                                Component.literal(
                                                                                                   "Linara: I shall wait here for thee to return"
                                                                                                ),
                                                                                                false
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
   }
}

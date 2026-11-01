package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SaphyraDialog03Procedure {
   public static void execute(LevelAccessor world, double x, double z, Entity entity) {
      if (entity != null) {
         if (!world.isClientSide() && world.getServer() != null) {
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: well done,"), false);
         }

         MokelsBossfightSaphyraMod.queueServerWork(
            80,
            () -> {
               if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Thee earned respect."), false);
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  100,
                  () -> {
                     if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Thou art in possession of his memory, I perceive."), false);
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        140,
                        () -> {
                           if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Talk to Marlene."), false);
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(
                              80,
                              () -> {
                                 if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                    world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: She is a student of mine,"), false);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    100,
                                    () -> {
                                       if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                          world.getServer()
                                             .getPlayerList()
                                             .broadcastSystemMessage(Component.literal("Saphyra: And the only one able to convert his past."), false);
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          120,
                                          () -> {
                                             if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Take these keys."), false);
                                             }

                                             MokelsBossfightSaphyraMod.queueServerWork(
                                                80,
                                                () -> {
                                                   if (entity.isAlive()) {
                                                      if (!world.isClientSide() && world.getServer() != null) {
                                                         world.getServer()
                                                            .getPlayerList()
                                                            .broadcastSystemMessage(Component.literal("Saphyra: It will open the path to her room."), false);
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         20,
                                                         () -> {
                                                            if (world instanceof ServerLevel _level) {
                                                               ItemEntity entityToSpawn = new ItemEntity(
                                                                  _level,
                                                                  entity.getX() + entity.getLookAngle().x * 2.0,
                                                                  entity.getY(),
                                                                  entity.getZ() + entity.getLookAngle().z * 2.0,
                                                                  new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.HALLOWED_KEY_2.get())
                                                               );
                                                               entityToSpawn.setPickUpDelay(0);
                                                               entityToSpawn.setUnlimitedLifetime();
                                                               _level.addFreshEntity(entityToSpawn);
                                                            }

                                                            if (world instanceof ServerLevel _level) {
                                                               ItemEntity entityToSpawn = new ItemEntity(
                                                                  _level,
                                                                  entity.getX() + entity.getLookAngle().x * 2.0,
                                                                  entity.getY(),
                                                                  entity.getZ() + entity.getLookAngle().z * 2.0,
                                                                  new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.HALLOWED_KEY_2.get())
                                                               );
                                                               entityToSpawn.setPickUpDelay(0);
                                                               entityToSpawn.setUnlimitedLifetime();
                                                               _level.addFreshEntity(entityToSpawn);
                                                            }
                                                         }
                                                      );
                                                   }

                                                   MokelsBossfightSaphyraMod.queueServerWork(120, () -> {
                                                      if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                         world.getServer()
                                                            .getPlayerList()
                                                            .broadcastSystemMessage(Component.literal("Saphyra: She stands upon the second level."), false);
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(120, () -> {
                                                         if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                            world.getServer()
                                                               .getPlayerList()
                                                               .broadcastSystemMessage(Component.literal("Saphyra: Once it is done, return to me."), false);
                                                         }
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
   }
}

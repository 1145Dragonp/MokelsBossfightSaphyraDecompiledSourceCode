package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MarleneDialogProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0) {
            MokelsBossfightSaphyraMod.queueServerWork(
               20,
               () -> {
                  if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Who art thou?"), false);
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     80,
                     () -> {
                        if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                           world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Did mother send thee forth?"), false);
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           120,
                           () -> {
                              if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                 world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: ..."), false);
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 60,
                                 () -> {
                                    if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                       world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: good..."), false);
                                    }

                                    MokelsBossfightSaphyraMod.queueServerWork(
                                       60,
                                       () -> {
                                          if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                             world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: well..."), false);
                                          }

                                          MokelsBossfightSaphyraMod.queueServerWork(
                                             60,
                                             () -> {
                                                if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                   world.getServer()
                                                      .getPlayerList()
                                                      .broadcastSystemMessage(Component.literal("Marlene: i sense thou got your hold on a memory?"), false);
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   140,
                                                   () -> {
                                                      if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                         world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: I shall convert it,"), false);
                                                      }

                                                      MokelsBossfightSaphyraMod.queueServerWork(
                                                         80,
                                                         () -> {
                                                            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                               world.getServer()
                                                                  .getPlayerList()
                                                                  .broadcastSystemMessage(Component.literal("Marlene: but only if thou offer me thy help first."), false);
                                                            }

                                                            MokelsBossfightSaphyraMod.queueServerWork(
                                                               160,
                                                               () -> {
                                                                  if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                     world.getServer()
                                                                        .getPlayerList()
                                                                        .broadcastSystemMessage(
                                                                           Component.literal(
                                                                              "Marlene: I am a scholar of the written word, a seeker of forgotten lore"
                                                                           ),
                                                                           false
                                                                        );
                                                                  }

                                                                  MokelsBossfightSaphyraMod.queueServerWork(
                                                                     180,
                                                                     () -> {
                                                                        if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                           world.getServer()
                                                                              .getPlayerList()
                                                                              .broadcastSystemMessage(
                                                                                 Component.literal(
                                                                                    "Marlene: Bring me a book, a tale I have not yet encountered."
                                                                                 ),
                                                                                 false
                                                                              );
                                                                        }

                                                                        MokelsBossfightSaphyraMod.queueServerWork(
                                                                           180,
                                                                           () -> {
                                                                              if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                                                 world.getServer()
                                                                                    .getPlayerList()
                                                                                    .broadcastSystemMessage(
                                                                                       Component.literal(
                                                                                          "Marlene: When thou hast found it, return to me, and I shall grant thy wish."
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

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "/tp @s ~ ~ ~ facing entity @p[distance=0..48]"
               );
         }
      }
   }
}

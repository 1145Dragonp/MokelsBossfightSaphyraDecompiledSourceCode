package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class WellItSeemethProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: Welcome"), false);
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               80,
               () -> {
                  if (entity.isAlive()) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: Linara informed me of thy imminent arrival."), false);
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        120,
                        () -> {
                           if (entity.isAlive()) {
                              if (!world.isClientSide() && world.getServer() != null) {
                                 world.getServer()
                                    .getPlayerList()
                                    .broadcastSystemMessage(
                                       Component.literal("Saphyra: I am Saphyra, one of the few remaining witches that still draw breath in this world."),
                                       false
                                    );
                              }

                              MokelsBossfightSaphyraMod.queueServerWork(
                                 180,
                                 () -> {
                                    if (entity.isAlive()) {
                                       if (!world.isClientSide() && world.getServer() != null) {
                                          world.getServer()
                                             .getPlayerList()
                                             .broadcastSystemMessage(
                                                Component.literal(
                                                   "Saphyra: As the leader of the children of aenthir, I welcome thee into my guiding embrace."
                                                ),
                                                false
                                             );
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(
                                          180,
                                          () -> {
                                             if (entity.isAlive()) {
                                                if (!world.isClientSide() && world.getServer() != null) {
                                                   world.getServer()
                                                      .getPlayerList()
                                                      .broadcastSystemMessage(Component.literal("Saphyra: Hand me the invitation Linara gave thee."), false);
                                                }

                                                MokelsBossfightSaphyraMod.queueServerWork(
                                                   120,
                                                   () -> {
                                                      if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                                         world.getServer()
                                                            .getPlayerList()
                                                            .broadcastSystemMessage(Component.literal("Saphyra: And i will gladly adopt thou into my loving care"), false);
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
                     );
                  }
               }
            );
         }
      }
   }
}

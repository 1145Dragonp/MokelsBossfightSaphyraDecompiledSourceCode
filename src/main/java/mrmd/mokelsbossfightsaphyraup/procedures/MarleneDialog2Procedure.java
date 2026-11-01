package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MarleneDialog2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Good..."), false);
         }

         MokelsBossfightSaphyraMod.queueServerWork(60, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: As promised, i shall convert the memory you achieved."), false);
            }

            MokelsBossfightSaphyraMod.queueServerWork(140, () -> {
               if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Just Hand it over."), false);
               }
            });
         });
      }
   }
}

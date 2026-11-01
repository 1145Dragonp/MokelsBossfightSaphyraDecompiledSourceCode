package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class Witchhat2RightClickedOnEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Well, it seemeth that someone has found me."), false);
            }

            MokelsBossfightSaphyraMod.queueServerWork(180, () -> {
               if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("It has been quite the while."), false);
               }
            });
         }

         if (entity.getPersistentData().getDouble("IA") == 3000.0) {
            entity.getPersistentData().putDouble("IA", 0.0);
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class WitchhatOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 5.0) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("hey you! yes you. I'm over here!"), false);
            }

            MokelsBossfightSaphyraMod.queueServerWork(200, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity.getPersistentData().getDouble("IA") == 400.0) {
            entity.getPersistentData().putDouble("IA", 0.0);
         }
      }
   }
}

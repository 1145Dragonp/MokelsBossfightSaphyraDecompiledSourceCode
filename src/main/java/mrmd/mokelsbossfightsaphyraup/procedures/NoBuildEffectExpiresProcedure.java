package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class NoBuildEffectExpiresProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof Player _player) {
            _player.getAbilities().mayBuild = false;
            _player.onUpdateAbilities();
         }

         return false;
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class NoBuildEffectStartedappliedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _player) {
            _player.getAbilities().mayBuild = true;
            _player.onUpdateAbilities();
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.world.entity.Entity;

public class DevotionBarProc3Procedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .Devotion
            >= 40.0;
   }
}

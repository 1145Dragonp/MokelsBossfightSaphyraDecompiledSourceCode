package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.world.entity.Entity;

public class ManicEyeTickInventoryProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                     MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                  )
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .Manic
            + 0.1;
         entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.Manic = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}

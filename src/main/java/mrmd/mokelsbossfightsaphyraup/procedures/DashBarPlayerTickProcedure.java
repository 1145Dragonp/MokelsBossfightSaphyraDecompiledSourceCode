package mrmd.mokelsbossfightsaphyraup.procedures;

import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DashBarPlayerTickProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player);
      }
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Dash
               > 0.0
            && !(
               ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Dash
                  < 0.0
            )) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Dash
               + 0.2;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Dash = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Dash
               == 0.0
            && !(
               ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Dash
                  < 0.0
            )) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Dash
               + 5.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Dash = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .Dash
            > 30.0) {
            double _setval = 30.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Dash = _setval;
               capability.syncPlayerVariables(entity);
            });
         }
      }
   }
}

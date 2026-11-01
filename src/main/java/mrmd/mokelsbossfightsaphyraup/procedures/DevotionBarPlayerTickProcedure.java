package mrmd.mokelsbossfightsaphyraup.procedures;

import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DevotionBarPlayerTickProcedure {
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
                  .Devotion
               > 0.0
            && !(
               ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Devotion
                  < 0.0
            )) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Devotion
               - 0.05;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Devotion = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Devotion
               == 0.0
            && !(
               ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Devotion
                  < 0.0
            )) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Devotion
               - 5.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Devotion = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .Devotion
            > 70.0) {
            double _setval = 0.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Devotion = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (!(entity instanceof MothbossEntity)
               && !(entity instanceof WitchbossEntity)
               && entity instanceof LivingEntity
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.GRIEF_EFFECT.get(), 200, 0, false, false));
            }
         }
      }
   }
}

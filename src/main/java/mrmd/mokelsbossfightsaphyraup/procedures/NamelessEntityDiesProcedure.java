package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class NamelessEntityDiesProcedure {
   public static void execute(Entity sourceentity) {
      if (sourceentity != null) {
         if ((sourceentity instanceof Player || sourceentity instanceof ServerPlayer)
            && sourceentity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 1000, false, false));
         }
      }
   }
}

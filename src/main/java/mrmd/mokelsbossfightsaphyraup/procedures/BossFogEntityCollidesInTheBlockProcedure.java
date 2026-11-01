package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class BossFogEntityCollidesInTheBlockProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof Player || entity instanceof ServerPlayer) && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.STAY_STILL.get(), 2, 1, false, false));
         }
      }
   }
}

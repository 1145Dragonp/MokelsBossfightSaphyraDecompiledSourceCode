package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class NoBuildOnEffectActiveTickProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else if (!(entity instanceof Player) && !(entity instanceof ServerPlayer)) {
         return false;
      } else {
         if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.NO_BUILD.get())) {
            if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.NO_BUILD.get())) {
               if (entity instanceof Player _player) {
                  _player.getAbilities().mayBuild = false;
                  _player.onUpdateAbilities();
               }

               return true;
            }

            return false;
         }

         if (entity instanceof Player _player) {
            _player.getAbilities().mayBuild = true;
            _player.onUpdateAbilities();
         }

         return true;
      }
   }
}

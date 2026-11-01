package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DisgustProjectileFallProjectileHitsLivingEntityProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((!(entity instanceof LivingEntity _livEnt0) || !_livEnt0.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get()))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 2, false, false));
         }
      }
   }
}

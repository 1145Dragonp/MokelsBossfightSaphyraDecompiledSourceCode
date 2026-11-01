package mrmd.mokelsbossfightsaphyraup.potion;

import mrmd.mokelsbossfightsaphyraup.procedures.NoBuildOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class NoBuildMobEffect extends MobEffect {
   public NoBuildMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      NoBuildOnEffectActiveTickProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}

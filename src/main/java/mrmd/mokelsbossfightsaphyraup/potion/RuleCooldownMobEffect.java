package mrmd.mokelsbossfightsaphyraup.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class RuleCooldownMobEffect extends MobEffect {
   public RuleCooldownMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}

package mrmd.mokelsbossfightsaphyraup.potion;

import mrmd.mokelsbossfightsaphyraup.procedures.RotEffectEffectStartedappliedProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.RotEffectOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class RotEffectMobEffect extends MobEffect {
   public RotEffectMobEffect() {
      super(MobEffectCategory.HARMFUL, -6750208);
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      RotEffectEffectStartedappliedProcedure.execute(entity.level(), entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      RotEffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}

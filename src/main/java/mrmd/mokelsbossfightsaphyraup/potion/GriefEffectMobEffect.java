package mrmd.mokelsbossfightsaphyraup.potion;

import mrmd.mokelsbossfightsaphyraup.procedures.GriefEffectEffectExpiresProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefEffectEffectStartedappliedProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.GriefEffectOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class GriefEffectMobEffect extends MobEffect {
   public GriefEffectMobEffect() {
      super(MobEffectCategory.HARMFUL, -16764007);
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      GriefEffectEffectStartedappliedProcedure.execute(entity.level(), entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      GriefEffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      GriefEffectEffectExpiresProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}

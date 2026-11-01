package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class AttackShieldBlockProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof NamelessEntity) {
               ((NamelessEntity)entity).setAnimation("attackshield");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 90, 100, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 100, false, false));
            }
         }
      }
   }
}

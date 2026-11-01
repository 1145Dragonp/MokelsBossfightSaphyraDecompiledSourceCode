package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class LouringClaymoreLivingEntityIsHitWithToolProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
            if (!(sourceentity instanceof LivingEntity _livEnt2) || !_livEnt2.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.GRIEF_EFFECT.get())) {
               double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)sourceentity.getCapability(
                           MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                        )
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Grief
                  + 10.0;
               sourceentity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.Grief = _setval;
                  capability.syncPlayerVariables(sourceentity);
               });
               return;
            }

            if (sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.GRIEF_EFFECT.get())) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity), 10.0F);
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                     entity.getX(),
                     1.0 + entity.getY(),
                     entity.getZ(),
                     30,
                     0.2,
                     0.2,
                     0.2,
                     0.03
                  );
               }
            }
         }
      }
   }
}

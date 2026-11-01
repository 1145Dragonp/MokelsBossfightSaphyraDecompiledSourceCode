package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.configuration.StaminaBarConfiguration;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class DashProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((Boolean)StaminaBarConfiguration.STAMINABAR.get()
            && entity.isAlive()
            && (!(entity instanceof LivingEntity _livEnt2) || !_livEnt2.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.COOLDOWN.get()))
            && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + -0.1, entity.getZ()))
            && !(
               ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Dash
                  < 10.0
            )) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Dash
               - 10.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Dash = _setval;
               capability.syncPlayerVariables(entity);
            });
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 7.0, 0.15, entity.getDeltaMovement().z() * 7.0));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get(), 6, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.COOLDOWN.get(), 10, 1, false, false));
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.POOF, entity.getX(), 0.2 + entity.getY(), entity.getZ(), 15, 0.3, 0.0, 0.3, 0.05);
            }

            if (entity instanceof Player _player) {
               _player.getFoodData().setSaturation(-2.0F);
            }
         }
      }
   }
}

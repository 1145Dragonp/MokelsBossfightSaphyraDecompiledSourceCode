package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class NamelessProjectileFallProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         MokelsBossfightSaphyraMod.queueServerWork(2, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (entity instanceof LivingEntity
            && !(entity instanceof NamelessEntity)
            && (!(entity instanceof LivingEntity _livEnt4) || !_livEnt4.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get()))) {
            double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                        MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                     )
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                  .Rotting
               + 40.0;
            entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.Rotting = _setval;
               capability.syncPlayerVariables(entity);
            });
            entity.hurt(
               new DamageSource(
                  world.registryAccess()
                     .registryOrThrow(Registries.DAMAGE_TYPE)
                     .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mokels_bossfight_saphyra:rot")))
               ),
               4.0F
            );
         }
      }
   }
}

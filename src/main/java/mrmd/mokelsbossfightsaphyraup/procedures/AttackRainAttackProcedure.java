package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class AttackRainAttackProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof WitchbossEntity) {
               ((WitchbossEntity)entity).setAnimation("rainattack");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 100, false, false));
            }

            if (entity.isAlive()) {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.MOONBEAM.get())
                     .spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 4.0, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  20,
                  () -> {
                     if (entity.isAlive()) {
                        if (world instanceof ServerLevel _levelx) {
                           Entity entityToSpawnx = ((EntityType)MokelsBossfightSaphyraModEntities.MOONBEAM.get())
                              .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY() + 4.0, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnx != null) {
                              entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(
                           20,
                           () -> {
                              if (entity.isAlive() && world instanceof ServerLevel _levelxx) {
                                 Entity entityToSpawnxx = ((EntityType)MokelsBossfightSaphyraModEntities.MOONBEAM.get())
                                    .spawn(
                                       _levelxx, BlockPos.containing(entity.getX(), entity.getY() + 4.0, entity.getZ()), MobSpawnType.MOB_SUMMONED
                                    );
                                 if (entityToSpawnxx != null) {
                                    entityToSpawnxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }
                           }
                        );
                     }
                  }
               );
            }
         }
      }
   }
}

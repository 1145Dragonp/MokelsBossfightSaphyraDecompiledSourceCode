package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WitchbossStopSoundProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof WitchbossEntity) {
            ((WitchbossEntity)entity).setAnimation("empty");
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "/stopsound @a music"
               );
         }

         if (!world.isClientSide() && world.getServer() != null) {
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Very well..."), false);
         }

         MokelsBossfightSaphyraMod.queueServerWork(60, () -> {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Enough playing around."), false);
            }

            MokelsBossfightSaphyraMod.queueServerWork(80, () -> {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: Let's get serious."), false);
               }
            });
         });
         MokelsBossfightSaphyraMod.queueServerWork(
            120,
            () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles(
                     (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                     entity.getX(),
                     3.0 + entity.getY(),
                     entity.getZ(),
                     10,
                     0.2,
                     0.2,
                     0.2,
                     0.05
                  );
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  20,
                  () -> {
                     if (world instanceof ServerLevel _levelxx) {
                        _levelxx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                           entity.getX(),
                           3.0 + entity.getY(),
                           entity.getZ(),
                           40,
                           0.2,
                           0.2,
                           0.2,
                           0.05
                        );
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(
                        20,
                        () -> {
                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.sendParticles(
                                 (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                                 entity.getX(),
                                 3.0 + entity.getY(),
                                 entity.getZ(),
                                 160,
                                 0.2,
                                 0.2,
                                 0.2,
                                 0.05
                              );
                           }
                        }
                     );
                  }
               );
            }
         );
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfestedWitchOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
               entity.getX(),
               1.35 + entity.getY(),
               entity.getZ(),
               2,
               0.1,
               0.1,
               0.1,
               0.05
            );
         }

         Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player && entityiterator instanceof ServerPlayer) {
               double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entityiterator.getCapability(
                           MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                        )
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Rotting
                  + 0.9;
               entityiterator.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.Rotting = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
            }
         }
      }
   }
}

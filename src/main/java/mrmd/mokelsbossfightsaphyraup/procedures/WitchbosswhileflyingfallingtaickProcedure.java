package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class WitchbosswhileflyingfallingtaickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.GHOSTLY_FLAME_PARTICLE.get(), x, y, z, 20, 0.1, 0.1, 0.1, 0.01);
      }
   }
}

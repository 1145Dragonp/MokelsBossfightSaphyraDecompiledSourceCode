package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class StayStillOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
      }
   }
}

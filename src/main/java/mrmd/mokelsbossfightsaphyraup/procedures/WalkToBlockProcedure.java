package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class WalkToBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.AZURE_BRICKS_ANIMATED.get()
            && entity instanceof Mob _entity) {
            _entity.getNavigation().moveTo(x, y, z, 2.0);
         }
      }
   }
}

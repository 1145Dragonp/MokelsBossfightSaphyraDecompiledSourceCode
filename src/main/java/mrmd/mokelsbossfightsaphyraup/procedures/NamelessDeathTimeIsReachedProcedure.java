package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class NamelessDeathTimeIsReachedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         ItemEntity entityToSpawn = new ItemEntity(
            _level, x, y, z, new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.NAMELESS_GATEKEEPER_REMEMBRANCE.get())
         );
         entityToSpawn.setPickUpDelay(2);
         entityToSpawn.setUnlimitedLifetime();
         _level.addFreshEntity(entityToSpawn);
      }

      if (world instanceof ServerLevel _level) {
         ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.KEY_4.get()));
         entityToSpawn.setPickUpDelay(2);
         entityToSpawn.setUnlimitedLifetime();
         _level.addFreshEntity(entityToSpawn);
      }
   }
}

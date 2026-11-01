package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class MothbossDeathTimeIsReachedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
               entity.getX(),
               entity.getY(),
               entity.getZ(),
               800,
               0.6,
               1.7,
               0.6,
               0.01
            );
         }

         if (world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(
               _level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.BOTTOMLESS_BAG.get())
            );
            entityToSpawn.setPickUpDelay(2);
            entityToSpawn.setUnlimitedLifetime();
            _level.addFreshEntity(entityToSpawn);
         }
      }
   }
}

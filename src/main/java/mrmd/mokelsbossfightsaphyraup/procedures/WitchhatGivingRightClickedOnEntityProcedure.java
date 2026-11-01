package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class WitchhatGivingRightClickedOnEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
            == MokelsBossfightSaphyraModItems.TOTEM_OF_ROT_AND_DECAY.get()) {
            if (sourceentity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.TOTEM_OF_ROT_AND_DECAY.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            MokelsBossfightSaphyraMod.queueServerWork(20, () -> {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I'll pray that thy valor shall suffice to defeat me in this duel."), false);
               }
            });
            MokelsBossfightSaphyraMod.queueServerWork(
               120,
               () -> {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.WITCHBOSS.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.POOF, x, y, z, 250, 1.0, 2.0, 1.0, 0.1);
                  }
               }
            );
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RightclickSinisterBagProcedure {
   @SubscribeEvent
   public static void onRightClickItem(RightClickItem event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MokelsBossfightSaphyraModItems.SINISTER_BAG.get()
            )
          {
            if (world.isClientSide()) {
               Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SINISTER_BAG.get()));
            }

            if (entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SINISTER_BAG.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(
                  _level,
                  entity.getX(),
                  0.5 + entity.getY(),
                  entity.getZ(),
                  new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SHATTERED_BLOOD_VAIL.get())
               );
               entityToSpawn.setPickUpDelay(0);
               entityToSpawn.setUnlimitedLifetime();
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(
                  _level,
                  entity.getX(),
                  0.5 + entity.getY(),
                  entity.getZ(),
                  new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SWORD_OF_THE_NAMELESS_GATEKEEPER.get())
               );
               entityToSpawn.setPickUpDelay(0);
               entityToSpawn.setUnlimitedLifetime();
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, entity.getX(), 0.5 + entity.getY(), entity.getZ(), new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE));
               entityToSpawn.setPickUpDelay(0);
               entityToSpawn.setUnlimitedLifetime();
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, entity.getX(), 0.5 + entity.getY(), entity.getZ(), new ItemStack(Items.NETHERITE_INGOT));
               entityToSpawn.setPickUpDelay(0);
               entityToSpawn.setUnlimitedLifetime();
               _level.addFreshEntity(entityToSpawn);
            }
         }
      }
   }
}

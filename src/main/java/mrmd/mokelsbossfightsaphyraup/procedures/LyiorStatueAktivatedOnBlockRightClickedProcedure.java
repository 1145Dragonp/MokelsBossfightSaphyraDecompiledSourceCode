package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;

public class LyiorStatueAktivatedOnBlockRightClickedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
            == MokelsBossfightSaphyraModItems.BROKEN_SIGIL_OF_THE_RED_SUN.get()) {
            if (entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.BROKEN_SIGIL_OF_THE_RED_SUN.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            if (entity instanceof Player _player) {
               ItemStack _setstack = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SIGIL_OF_THE_RED_SUN_STAGE_2.get()).copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }
      }
   }
}

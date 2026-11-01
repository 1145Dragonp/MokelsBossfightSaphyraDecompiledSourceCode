package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.ItemStack;

public class ShowTextProcedure {
   public static boolean execute(ItemStack itemstack) {
      return itemstack.getItem() == MokelsBossfightSaphyraModItems.SIGIL_OF_THE_RED_SUN.get() && Screen.hasShiftDown();
   }
}

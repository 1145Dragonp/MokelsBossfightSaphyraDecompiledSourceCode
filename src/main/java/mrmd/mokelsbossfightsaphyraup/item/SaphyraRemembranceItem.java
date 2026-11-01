package mrmd.mokelsbossfightsaphyraup.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SaphyraRemembranceItem extends Item {
   public SaphyraRemembranceItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Godmother of every infant of Aenthir. One of the few witches that survived the day of the white flame. "));
      list.add(Component.literal(""));
      list.add(Component.literal("STORY ITEM"));
   }
}

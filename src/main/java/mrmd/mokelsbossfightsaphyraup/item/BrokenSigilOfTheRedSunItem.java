package mrmd.mokelsbossfightsaphyraup.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class BrokenSigilOfTheRedSunItem extends Item {
   public BrokenSigilOfTheRedSunItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Under the red sun, all hope was lost, and the age of witchcraft came to an end. A new god was born."));
      list.add(Component.literal("It tells you to take it to one of Lyiors statues"));
      list.add(Component.literal(""));
      list.add(Component.literal("STORY ITEM"));
   }
}

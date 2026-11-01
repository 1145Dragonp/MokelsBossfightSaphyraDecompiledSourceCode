package mrmd.mokelsbossfightsaphyraup.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class EmptyRuleItem extends Item {
   public EmptyRuleItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
   }
}

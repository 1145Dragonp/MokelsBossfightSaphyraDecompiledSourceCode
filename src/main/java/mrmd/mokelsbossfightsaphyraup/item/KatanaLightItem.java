package mrmd.mokelsbossfightsaphyraup.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;

public class KatanaLightItem extends SwordItem {
   public KatanaLightItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 2.0F;
         }

         public float getAttackDamageBonus() {
            return 2.5F;
         }

         public int getLevel() {
            return 0;
         }

         public int getEnchantmentValue() {
            return 15;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 3, -2.0F, new Properties().fireResistant());
   }
}

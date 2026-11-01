package mrmd.mokelsbossfightsaphyraup.item;

import java.util.List;
import mrmd.mokelsbossfightsaphyraup.procedures.SwordTearAndDropletEntitySwingsItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class SwordTearAndDropletItem extends SwordItem {
   public SwordTearAndDropletItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 2.0F;
         }

         public float getAttackDamageBonus() {
            return 1.0F;
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
      }, 3, -2.4F, new Properties().fireResistant());
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      SwordTearAndDropletEntitySwingsItemProcedure.execute(entity.level(), entity, sourceentity);
      return retval;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Deals 75% additional damage when it's raining and 150% additional damage during thunderstorms"));
   }
}

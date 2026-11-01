package mrmd.mokelsbossfightsaphyraup.item;

import java.util.List;
import mrmd.mokelsbossfightsaphyraup.procedures.LouringClaymoreLivingEntityIsHitWithToolProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class LouringClaymoreItem extends SwordItem {
   public LouringClaymoreItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 2.0F;
         }

         public float getAttackDamageBonus() {
            return 7.0F;
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
      }, 3, -3.0F, new Properties().fireResistant());
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      LouringClaymoreLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity, sourceentity);
      return retval;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "Passive Ability: Each time a target is hit, the grief bar slowly fills up. While you're cursed with grief, the Louring Claymore deals additional damage that ignores the targets armor protection"
         )
      );
   }
}

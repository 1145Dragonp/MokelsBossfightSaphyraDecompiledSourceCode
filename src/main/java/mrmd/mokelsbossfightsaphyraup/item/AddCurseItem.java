package mrmd.mokelsbossfightsaphyraup.item;

import mrmd.mokelsbossfightsaphyraup.procedures.AdddCurseProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class AddCurseItem extends Item {
   public AddCurseItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AdddCurseProcedure.execute(world, entity, (ItemStack)ar.getObject());
      return ar;
   }
}

package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.item.SaphyrasCapeItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ArmorAnimationFactory {
   @SubscribeEvent
   public static void animatedArmors(PlayerTickEvent event) {
      String animation = "";
      if (event.phase == Phase.END) {
         if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() != ItemStack.EMPTY.getItem()
            && event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GeoItem
            && !event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim").equals("")) {
            animation = event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim");
            event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SaphyrasCapeItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
            }
         }

         if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() != ItemStack.EMPTY.getItem()
            && event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GeoItem
            && !event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim").equals("")) {
            animation = event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim");
            event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SaphyrasCapeItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
            }
         }

         if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() != ItemStack.EMPTY.getItem()
            && event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GeoItem
            && !event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim").equals("")) {
            animation = event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim");
            event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SaphyrasCapeItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
            }
         }

         if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() != ItemStack.EMPTY.getItem()
            && event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GeoItem
            && !event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim").equals("")) {
            animation = event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim");
            event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SaphyrasCapeItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
            }
         }
      }
   }
}

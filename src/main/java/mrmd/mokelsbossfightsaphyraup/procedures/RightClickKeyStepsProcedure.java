package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlocks;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class RightClickKeyStepsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() != MokelsBossfightSaphyraModItems.KEY_1.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != MokelsBossfightSaphyraModItems.KEY_1.get()) {
            if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem() != ItemStack.EMPTY.getItem()
               && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() != ItemStack.EMPTY.getItem()) {
               if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     != MokelsBossfightSaphyraModItems.KEY_3.get()
                  && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     != MokelsBossfightSaphyraModItems.KEY_3.get()) {
                  if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        != MokelsBossfightSaphyraModItems.KEY_4.get()
                     && (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != MokelsBossfightSaphyraModItems.KEY_4.get()) {
                     if ((entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                           != MokelsBossfightSaphyraModItems.HALLOWED_KEY_3.get()
                        && (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                           != MokelsBossfightSaphyraModItems.HALLOWED_KEY_3.get()) {
                        if ((entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                              != MokelsBossfightSaphyraModItems.HALLOWED_KEY_1.get()
                           && (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              != MokelsBossfightSaphyraModItems.HALLOWED_KEY_1.get()) {
                           if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                 != MokelsBossfightSaphyraModItems.KEY_2.get()
                              && (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                 != MokelsBossfightSaphyraModItems.KEY_2.get()) {
                              if ((
                                    (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                          == MokelsBossfightSaphyraModItems.HALLOWED_KEY_2.get()
                                       || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                             .getItem()
                                          == MokelsBossfightSaphyraModItems.HALLOWED_KEY_2.get()
                                 )
                                 && !world.isClientSide()
                                 && world.getServer() != null) {
                                 world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
                              }
                           } else if (!world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
                           }
                        } else if (!world.isClientSide() && world.getServer() != null) {
                           world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
                        }
                     } else if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
                     }
                  } else if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
                  }
               } else if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
               }
            } else if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("you need a \"Steps\" key"), false);
            }
         } else {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, 1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, 1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, -1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, -1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, y, 1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, y, 1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, 1.0 + y, 1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, 1.0 + y, 1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, -1.0 + y, 1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, -1.0 + y, 1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, 1.0 + y, -1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, 1.0 + y, -1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, y, -1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, y, -1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, -1.0 + y, -1.0 + z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, -1.0 + y, -1.0 + z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, 1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, 1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(x, -1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(x, -1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(1.0 + x, y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(1.0 + x, y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(1.0 + x, 1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(1.0 + x, 1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(1.0 + x, -1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(1.0 + x, -1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(-1.0 + x, 1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(-1.0 + x, 1.0 + y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(-1.0 + x, y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(-1.0 + x, y, z), false);
            }

            if (world.getBlockState(BlockPos.containing(-1.0 + x, -1.0 + y, z)).getBlock() == MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS.get()) {
               world.destroyBlock(BlockPos.containing(-1.0 + x, -1.0 + y, z), false);
            }

            if (entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.KEY_1.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("the barrier broke"), false);
            }
         }
      }
   }
}

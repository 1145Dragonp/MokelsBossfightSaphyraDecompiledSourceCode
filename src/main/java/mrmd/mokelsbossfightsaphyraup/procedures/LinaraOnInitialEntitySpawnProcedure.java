package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraEntity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class LinaraOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         MokelsBossfightSaphyraMod.queueServerWork(40, () -> {
            if (entity.isAlive()) {
               if (entity instanceof LinaraEntity) {
                  ((LinaraEntity)entity).setAnimation("greeting");
               }

               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: Greetings,"), false);
               }
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(100, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: I am Linara, one of the many scions of the children of aenthir"), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(240, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Thou wert cast into this realm with a purpose."), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(340, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: We are both of like kind."), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(440, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Led by the grace of the white flame."), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(540, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Alas, our encounter is blessed with fleeting attention."), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(
            660,
            () -> {
               if (entity.isAlive()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: Here, take this invitation and show it to my mistress."), false);
                  }

                  if (entity instanceof LinaraEntity) {
                     ((LinaraEntity)entity).setAnimation("give");
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     30,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(
                              _level,
                              entity.getX(),
                              entity.getY(),
                              entity.getZ(),
                              new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.HALLOWED_KEY_1.get())
                           );
                           entityToSpawn.setPickUpDelay(2);
                           entityToSpawn.setUnlimitedLifetime();
                           _level.addFreshEntity(entityToSpawn);
                        }

                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(
                              _level,
                              entity.getX(),
                              entity.getY(),
                              entity.getZ(),
                              new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.INVITATION_TO_THE_HALLOWED_TOWER.get())
                           );
                           entityToSpawn.setPickUpDelay(2);
                           entityToSpawn.setUnlimitedLifetime();
                           _level.addFreshEntity(entityToSpawn);
                        }
                     }
                  );
               }
            }
         );
         MokelsBossfightSaphyraMod.queueServerWork(740, () -> {
            if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: She awaits thy arrival in the main hallowed tower."), false);
            }
         });
         MokelsBossfightSaphyraMod.queueServerWork(
            840,
            () -> {
               if (entity.isAlive()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Linara: farewell."), false);
                  }

                  if (entity instanceof LinaraEntity) {
                     ((LinaraEntity)entity).setAnimation("sky");
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     70,
                     () -> {
                        if (entity.isAlive()) {
                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }

                           for (int index0 = 0; index0 < 3; index0++) {
                              if (world instanceof ServerLevel _level) {
                                 _level.sendParticles(
                                    (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.PURPLE_FLAME_PARTICLE.get(),
                                    entity.getX(),
                                    entity.getY(),
                                    entity.getZ(),
                                    400,
                                    0.2,
                                    1.2,
                                    0.2,
                                    0.1
                                 );
                              }
                           }
                        }
                     }
                  );
               }
            }
         );
      }
   }
}

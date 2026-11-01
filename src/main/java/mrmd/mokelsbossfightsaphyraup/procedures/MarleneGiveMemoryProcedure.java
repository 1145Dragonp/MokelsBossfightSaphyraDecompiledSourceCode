package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.MarleneHumanFormDialog2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog3Entity;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MarleneGiveMemoryProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
            == MokelsBossfightSaphyraModItems.NAMELESS_GATEKEEPER_REMEMBRANCE.get()) {
            Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof SaphyraDialog3Entity) {
                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_4.get())
                        .spawn(
                           _level,
                           BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entityiterator.getYRot());
                        entityToSpawn.setYBodyRot(entityiterator.getYRot());
                        entityToSpawn.setYHeadRot(entityiterator.getYRot());
                        entityToSpawn.setXRot(entityiterator.getXRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            }

            if (sourceentity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.NAMELESS_GATEKEEPER_REMEMBRANCE.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            if (entity instanceof MarleneHumanFormDialog2Entity) {
               ((MarleneHumanFormDialog2Entity)entity).setAnimation("convert");
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               66,
               () -> {
                  if (entity.isAlive()) {
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawnx = new ItemEntity(
                           _levelxx,
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SINISTER_BAG.get())
                        );
                        entityToSpawnx.setPickUpDelay(2);
                        entityToSpawnx.setUnlimitedLifetime();
                        _levelxx.addFreshEntity(entityToSpawnx);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(),
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           300,
                           0.2,
                           1.0,
                           0.2,
                           0.05
                        );
                     }

                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: ..."), false);
                     }
                  }

                  MokelsBossfightSaphyraMod.queueServerWork(
                     60,
                     () -> {
                        if (entity.isAlive()) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Thee should head to the observatory"), false);
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(
                              120,
                              () -> {
                                 if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                    world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Mother wishes to test thy strength in a duel."), false);
                                 }

                                 MokelsBossfightSaphyraMod.queueServerWork(
                                    140,
                                    () -> {
                                       if (entity.isAlive()) {
                                          if (!world.isClientSide() && world.getServer() != null) {
                                             world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: Take this key"), false);
                                          }

                                          if (entity.isAlive() && world instanceof ServerLevel _levelxxx) {
                                             ItemEntity entityToSpawnxx = new ItemEntity(
                                                _levelxxx,
                                                entity.getX(),
                                                entity.getY(),
                                                entity.getZ(),
                                                new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SAPHYRA_KEY.get())
                                             );
                                             entityToSpawnxx.setPickUpDelay(2);
                                             entityToSpawnxx.setUnlimitedLifetime();
                                             _levelxxx.addFreshEntity(entityToSpawnxx);
                                          }
                                       }

                                       MokelsBossfightSaphyraMod.queueServerWork(80, () -> {
                                          if (entity.isAlive() && !world.isClientSide() && world.getServer() != null) {
                                             world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Marlene: I wish thee good luck..."), false);
                                          }
                                       });
                                    }
                                 );
                              }
                           );
                        }
                     }
                  );
               }
            );
         } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
            == MokelsBossfightSaphyraModItems.SAPHYRA_REMEMBRANCE.get()) {
            if (sourceentity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.SAPHYRA_REMEMBRANCE.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            if (entity instanceof MarleneHumanFormDialog2Entity) {
               ((MarleneHumanFormDialog2Entity)entity).setAnimation("convert");
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               66,
               () -> {
                  if (entity.isAlive()) {
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawnx = new ItemEntity(
                           _levelxx,
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           new ItemStack((ItemLike)MokelsBossfightSaphyraModItems.BOTTOMLESS_BAG.get())
                        );
                        entityToSpawnx.setPickUpDelay(2);
                        entityToSpawnx.setUnlimitedLifetime();
                        _levelxx.addFreshEntity(entityToSpawnx);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(),
                           entity.getX(),
                           entity.getY(),
                           entity.getZ(),
                           300,
                           0.2,
                           1.0,
                           0.2,
                           0.05
                        );
                     }
                  }
               }
            );
         }
      }
   }
}

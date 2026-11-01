package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class NamelessAttackPatternProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0
            && (!(entity instanceof LivingEntity _livEnt5) || !_livEnt5.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackDoubleProcedure.execute(world, entity);
                  } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackRotProcedure.execute(world, x, z, entity);
                  }
               }
            } else if (Math.random() <= 1.0 && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackOnceProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackFloatProcedure.execute(world, entity);
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 100.0
            && (!(entity instanceof LivingEntity _livEnt15) || !_livEnt15.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof LivingEntity) {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackShieldBlockProcedure.execute(entity);
                  } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackFloatProcedure.execute(world, entity);
                     MokelsBossfightSaphyraMod.queueServerWork(30, () -> {
                        AttackFloatProcedure.execute(world, entity);
                        MokelsBossfightSaphyraMod.queueServerWork(30, () -> AttackFloatProcedure.execute(world, entity));
                     });
                  }
               }
            } else if (Math.random() <= 1.0 && (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof LivingEntity) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackShieldSlashProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackRotProcedure.execute(world, x, z, entity);
                  MokelsBossfightSaphyraMod.queueServerWork(35, () -> AttackRotProcedure.execute(world, x, z, entity));
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 220.0
            && (!(entity instanceof LivingEntity _livEnt28) || !_livEnt28.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) instanceof LivingEntity) {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackSuperProcedure.execute(world, entity);
                  } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackRotProcedure.execute(world, x, z, entity);
                     MokelsBossfightSaphyraMod.queueServerWork(35, () -> AttackRotProcedure.execute(world, x, z, entity));
                  }
               }
            } else if (Math.random() <= 1.0 && (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null) instanceof LivingEntity) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackDoubleOnceProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackFloatProcedure.execute(world, entity);
                  MokelsBossfightSaphyraMod.queueServerWork(30, () -> AttackFloatProcedure.execute(world, entity));
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 340.0
            && (!(entity instanceof LivingEntity _livEnt40) || !_livEnt40.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null) instanceof LivingEntity
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  AttackGroundProcedure.execute(world, entity);
               }
            } else if (Math.random() <= 1.0
               && (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null) instanceof LivingEntity
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
               AttackBruellenProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 450.0
            && (!(entity instanceof LivingEntity _livEnt48) || !_livEnt48.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null) instanceof LivingEntity
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  AttackRotProcedure.execute(world, x, z, entity);
               }
            } else if (Math.random() <= 1.0) {
               if (Math.random() <= 0.5) {
                  if ((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null) instanceof LivingEntity) {
                     if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                        AttackDoubleProcedure.execute(world, entity);
                     } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                        AttackFloatProcedure.execute(world, entity);
                     }
                  }
               } else if (Math.random() <= 1.0 && (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null) instanceof LivingEntity) {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackOnceProcedure.execute(world, entity);
                  } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                     AttackFloatProcedure.execute(world, entity);
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 520.0
            && (!(entity instanceof LivingEntity _livEnt61) || !_livEnt61.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.STUN.get()))) {
            if (Math.random() <= 0.5) {
               if ((entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null) instanceof LivingEntity
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  AttackStompProcedure.execute(world, entity);
               }
            } else if (Math.random() <= 1.0
               && (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null) instanceof LivingEntity
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
               AttackFloatProcedure.execute(world, entity);
               MokelsBossfightSaphyraMod.queueServerWork(30, () -> {
                  AttackFloatProcedure.execute(world, entity);
                  MokelsBossfightSaphyraMod.queueServerWork(30, () -> AttackFloatProcedure.execute(world, entity));
               });
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 620.0) {
            entity.getPersistentData().putDouble("IA", 0.0);
         }

         if ((entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("music", entity.getPersistentData().getDouble("music") + 1.0);
         }

         if (entity.getPersistentData().getDouble("music") == 20.0 && entity.isAlive()) {
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme1")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme1")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelx,
                           4,
                           "",
                           Component.literal(""),
                           _levelx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 320.0 && entity.isAlive()) {
            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme2")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme2")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 620.0 && entity.isAlive()) {
            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme3")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme3")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxx) {
               _levelxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 920.0 && entity.isAlive()) {
            if (world instanceof ServerLevel _levelxxx) {
               _levelxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }

            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme4")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme4")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }
         }

         if (entity.getPersistentData().getDouble("music") == 1220.0 && entity.isAlive()) {
            if (world instanceof Level _levelxxxx) {
               if (!_levelxxxx.isClientSide()) {
                  _levelxxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme5")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme5")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxxxx) {
               _levelxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 1520.0 && entity.isAlive()) {
            if (world instanceof Level _levelxxxxx) {
               if (!_levelxxxxx.isClientSide()) {
                  _levelxxxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme6")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme6")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxxxxx) {
               _levelxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxxxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxxxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 1820.0 && entity.isAlive()) {
            if (world instanceof Level _levelxxxxxx) {
               if (!_levelxxxxxx.isClientSide()) {
                  _levelxxxxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme7")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxxxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:namelesstheme7")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxx) {
               _levelxxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxxxxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxxxxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 1900.0) {
            entity.getPersistentData().putDouble("music", 0.0);
         }

         if (world instanceof ServerLevel _levelxxxxxxx) {
            _levelxxxxxxx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                        Vec2.ZERO,
                        _levelxxxxxxx,
                        4,
                        "",
                        Component.literal(""),
                        _levelxxxxxxx.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "/tp @s ~ ~ ~ facing entity @p[distance=0..48]"
               );
         }

         WalkToBlockProcedure.execute(world, x, y, z, entity);
      }
   }
}

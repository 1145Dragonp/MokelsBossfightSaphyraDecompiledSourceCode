package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MothbossAttackPatternProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("IA", entity.getPersistentData().getDouble("IA") + 1.0);
         }

         if (entity.getPersistentData().getDouble("IA") == 20.0) {
            if (Math.random() < 0.5) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackDashBackProcedure.execute(world, entity);
                  AttackSmiteProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackSmiteProcedure.execute(world, entity);
               }
            } else if (Math.random() < 1.0) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackSwordOnceProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackDashForthProcedure.execute(world, entity);
                  AttackSwordOnceProcedure.execute(world, entity);
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 120.0) {
            if (Math.random() < 0.5) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttacktwirlProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttacktwirlProcedure.execute(world, entity);
                  AttackDashForthProcedure.execute(world, entity);
               }
            } else if (Math.random() < 1.0) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackGroundMothProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackDashForthProcedure.execute(world, entity);
                  AttackGroundMothProcedure.execute(world, entity);
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 240.0) {
            if (Math.random() < 0.5) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackskyProcedure.execute(world, entity);
                  AttackDashBackProcedure.execute(world, entity);
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackskyProcedure.execute(world, entity);
               }
            } else if (Math.random() < 1.0) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackBackProcedure.execute(world, entity);
                  MokelsBossfightSaphyraMod.queueServerWork(35, () -> AttackSwordOnceProcedure.execute(world, entity));
               } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
                  AttackBackProcedure.execute(world, entity);
                  AttackDashForthProcedure.execute(world, entity);
                  MokelsBossfightSaphyraMod.queueServerWork(35, () -> {
                     AttackDashForthProcedure.execute(world, entity);
                     AttackSwordOnceProcedure.execute(world, entity);
                  });
               }
            }
         }

         if (entity.getPersistentData().getDouble("IA") == 320.0) {
            entity.getPersistentData().putDouble("IA", 0.0);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.getPersistentData().putDouble("music", entity.getPersistentData().getDouble("music") + 1.0);
         }

         if (entity.getPersistentData().getDouble("music") == 20.0 && entity.isAlive()) {
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme1")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme1")),
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
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme2")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme2")),
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
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme3")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme3")),
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
            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme4")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme4")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxxx) {
               _levelxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _levelxxxx,
                           4,
                           "",
                           Component.literal(""),
                           _levelxxxx.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/stopsound @a music"
                  );
            }
         }

         if (entity.getPersistentData().getDouble("music") == 1220.0 && entity.isAlive()) {
            if (world instanceof Level _levelxxxx) {
               if (!_levelxxxx.isClientSide()) {
                  _levelxxxx.playSound(
                     null,
                     BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme5")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme5")),
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
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme6")),
                     SoundSource.MUSIC,
                     2.0F,
                     1.0F
                  );
               } else {
                  _levelxxxxx.playLocalSound(
                     entity.getX(),
                     entity.getY(),
                     entity.getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:ivorydevil_theme6")),
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

         if (entity.getPersistentData().getDouble("music") == 1780.0) {
            entity.getPersistentData().putDouble("music", 0.0);
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
                  "/tp @s ~ ~ ~ facing entity @p[distance=0..48]"
               );
         }
      }
   }
}

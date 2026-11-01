package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MothbossEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof MothbossEntity) {
            ((MothbossEntity)entity).setAnimation("empty");
         }

         MokelsBossfightSaphyraMod.queueServerWork(
            20,
            () -> {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "/stopsound @a music"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "/title @a title {\"text\":\"EMERGED VICTORIOUS\",\"bold\":true,\"color\":\"#FFCF25\"}"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "/title @a times 20 40 20"
                     );
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:bosskilled")),
                        SoundSource.MASTER,
                        2.0F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:bosskilled")),
                        SoundSource.MASTER,
                        2.0F,
                        1.0F,
                        false
                     );
                  }
               }
            }
         );
         MokelsBossfightSaphyraMod.queueServerWork(
            20,
            () -> {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer()
                     .getPlayerList()
                     .broadcastSystemMessage(
                        Component.literal("Saphyra: At last, I have found one, enduring enough to confront the horrors that linger within this world"), false
                     );
               }

               MokelsBossfightSaphyraMod.queueServerWork(
                  200,
                  () -> {
                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer()
                           .getPlayerList()
                           .broadcastSystemMessage(
                              Component.literal(
                                 "Saphyra: Though I regret placing this burden upon thee, know that thou art the chosen one to end our suffering."
                              ),
                              false
                           );
                     }

                     MokelsBossfightSaphyraMod.queueServerWork(240, () -> {
                        if (!world.isClientSide() && world.getServer() != null) {
                           world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Saphyra: forgive me..."), false);
                        }

                        MokelsBossfightSaphyraMod.queueServerWork(160, () -> {
                           if (!world.isClientSide() && world.getServer() != null) {
                              world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("END OF CHAPTER 1"), false);
                           }

                           MokelsBossfightSaphyraMod.queueServerWork(140, () -> {
                              if (!world.isClientSide() && world.getServer() != null) {
                                 world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("CHAPTER 2 COMING SOON"), false);
                              }
                           });
                        });
                     });
                  }
               );
            }
         );
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.util.List;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkDirection;

public class ManicEffectStartedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                  } else {
                     return _ent.level().isClientSide() && _ent instanceof Player _player
                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                           && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL
                        : false;
                  }
               }
            })
            .checkGamemode(entity)) {
            if (world.isClientSide() && entity instanceof AbstractClientPlayer player) {
               ModifierLayer<IAnimation> animation = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player)
                  .get(new ResourceLocation("mokels_bossfight_saphyra", "player_animation"));
               if (animation != null) {
                  animation.setAnimation(
                     new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("mokels_bossfight_saphyra", "manic")))
                  );
               }
            }

            if (!world.isClientSide() && entity instanceof Player && world instanceof ServerLevel srvLvl_) {
               List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
               synchronized (connections) {
                  for (Connection connection : connections) {
                     if (!connection.isConnecting() && connection.isConnected()) {
                        MokelsBossfightSaphyraMod.PACKET_HANDLER
                           .sendTo(
                              new AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage(Component.literal("manic"), entity.getId(), true),
                              connection,
                              NetworkDirection.PLAY_TO_CLIENT
                           );
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.STAY_STILL.get(), 80, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.COOLDOWN.get(), 80, 1, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(
               30,
               () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(
                        (SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.GOLDEN_PARTICLE.get(),
                        entity.getX(),
                        1.0 + entity.getY(),
                        entity.getZ(),
                        100,
                        0.2,
                        0.2,
                        0.2,
                        0.25
                     );
                  }
               }
            );
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/title @p times 20 20 20"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "/title @p title {\"text\":\"Manic\",\"color\":\"yellow\"}"
                  );
            }
         }
      }
   }
}

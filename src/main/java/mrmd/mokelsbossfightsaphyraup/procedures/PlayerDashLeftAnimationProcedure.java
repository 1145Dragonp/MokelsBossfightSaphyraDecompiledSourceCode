package mrmd.mokelsbossfightsaphyraup.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.util.List;
import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.NetworkDirection;

@EventBusSubscriber
public class PlayerDashLeftAnimationProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.level(), event.player);
      }
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      return execute(null, world, entity);
   }

   private static boolean execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if ((entity instanceof Player || entity instanceof ServerPlayer)
            && entity instanceof LivingEntity _livEnt2
            && _livEnt2.hasEffect((MobEffect)MokelsBossfightSaphyraModMobEffects.IMMUNE.get())) {
            if (world.isClientSide() && entity instanceof AbstractClientPlayer player) {
               ModifierLayer<IAnimation> animation = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player)
                  .get(new ResourceLocation("mokels_bossfight_saphyra", "player_animation"));
               if (animation != null) {
                  animation.setAnimation(
                     new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("mokels_bossfight_saphyra", "dashnormal")))
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
                              new AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage(Component.literal("dashnormal"), entity.getId(), true),
                              connection,
                              NetworkDirection.PLAY_TO_CLIENT
                           );
                     }
                  }
               }
            }

            return true;
         }

         return false;
      }
   }
}

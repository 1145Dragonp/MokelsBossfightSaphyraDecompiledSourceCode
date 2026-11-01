package mrmd.mokelsbossfightsaphyraup.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   modid = "mokels_bossfight_saphyra",
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class AnimationsSetUpProcedure {
   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      PlayerAnimationFactory.ANIMATION_DATA_FACTORY
         .registerFactory(new ResourceLocation("mokels_bossfight_saphyra", "player_animation"), 1000, AnimationsSetUpProcedure::registerPlayerAnimations);
   }

   private static IAnimation registerPlayerAnimations(AbstractClientPlayer player) {
      return new ModifierLayer();
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
   }

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class MokelsBossfightSaphyraModAnimationMessage {
      Component animation;
      int target;
      boolean override;

      public MokelsBossfightSaphyraModAnimationMessage(Component animation, int target, boolean override) {
         this.animation = animation;
         this.target = target;
         this.override = override;
      }

      public MokelsBossfightSaphyraModAnimationMessage(FriendlyByteBuf buffer) {
         this.animation = buffer.readComponent();
         this.target = buffer.readInt();
         this.override = buffer.readBoolean();
      }

      public static void buffer(AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage message, FriendlyByteBuf buffer) {
         buffer.writeComponent(message.animation);
         buffer.writeInt(message.target);
         buffer.writeBoolean(message.override);
      }

      public static void handler(AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(
            () -> {
               Level level = Minecraft.getInstance().player.level();
               if (level.getEntity(message.target) != null) {
                  Player player = (Player)level.getEntity(message.target);
                  if (player instanceof AbstractClientPlayer player_) {
                     ModifierLayer<IAnimation> animation = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player_)
                        .get(new ResourceLocation("mokels_bossfight_saphyra", "player_animation"));
                     if (animation != null && (message.override || !animation.isActive())) {
                        animation.setAnimation(
                           new KeyframeAnimationPlayer(
                              PlayerAnimationRegistry.getAnimation(new ResourceLocation("mokels_bossfight_saphyra", message.animation.getString()))
                           )
                        );
                     }
                  }
               }
            }
         );
         context.setPacketHandled(true);
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
         MokelsBossfightSaphyraMod.addNetworkMessage(
            AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage.class,
            AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage::buffer,
            AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage::new,
            AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage::handler
         );
      }
   }
}

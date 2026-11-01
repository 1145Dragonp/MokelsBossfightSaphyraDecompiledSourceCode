package mrmd.mokelsbossfightsaphyraup.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.util.List;
import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModMobEffects;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.NetworkDirection;

@EventBusSubscriber
public class RuleOfWisdomrightclickedProcedure {
   @SubscribeEvent
   public static void onRightClickItem(RightClickItem event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         double baseRate = 0.0;
         double rateWithAmplifier = 0.0;
         if (MokelsBossfightSaphyraModItems.RULE_OF_HATERED.get()
            == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((Item)MokelsBossfightSaphyraModItems.RULE_OF_HATERED.get(), 2400);
            }

            if (world.isClientSide() && entity instanceof AbstractClientPlayer player) {
               ModifierLayer<IAnimation> animation = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player)
                  .get(new ResourceLocation("mokels_bossfight_saphyra", "player_animation"));
               if (animation != null) {
                  animation.setAnimation(
                     new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("mokels_bossfight_saphyra", "wisdom")))
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
                              new AnimationsSetUpProcedure.MokelsBossfightSaphyraModAnimationMessage(Component.literal("wisdom"), entity.getId(), true),
                              connection,
                              NetworkDirection.PLAY_TO_CLIENT
                           );
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.COOLDOWN.get(), 80, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)MokelsBossfightSaphyraModMobEffects.STAY_STILL.get(), 80, 1, false, false));
            }

            MokelsBossfightSaphyraMod.queueServerWork(52, () -> {
               if (entity instanceof LivingEntity _entityxxxx && !_entityxxxx.level().isClientSide()) {
                  _entityxxxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1, true, false));
               }

               if (entity instanceof LivingEntity _entityxxx && !_entityxxx.level().isClientSide()) {
                  _entityxxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, true, false));
               }

               if (entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                  _entityxx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, true, false));
               }

               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1, true, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.WITCH, entity.getX(), entity.getY(), entity.getZ(), 200, 0.2, 0.1, 0.2, 0.1);
               }
            });
         }
      }
   }
}

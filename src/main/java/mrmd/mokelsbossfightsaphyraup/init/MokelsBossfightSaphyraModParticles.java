package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.client.particle.DisgustOmenParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.GhostlyFlameParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.GoldenParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.LongGhostlyFlameParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.PukeParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.PurpleFlameParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.RedfireParticleParticle;
import mrmd.mokelsbossfightsaphyraup.client.particle.RedflameParticleParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class MokelsBossfightSaphyraModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.GHOSTLY_FLAME_PARTICLE.get(), GhostlyFlameParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.PURPLE_FLAME_PARTICLE.get(), PurpleFlameParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), RedflameParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), RedfireParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.PUKE_PARTICLE.get(), PukeParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.DISGUST_OMEN_PARTICLE.get(), DisgustOmenParticleParticle::provider);
      event.registerSpriteSet((ParticleType)MokelsBossfightSaphyraModParticleTypes.GOLDEN_PARTICLE.get(), GoldenParticleParticle::provider);
      event.registerSpriteSet(
         (ParticleType)MokelsBossfightSaphyraModParticleTypes.LONG_GHOSTLY_FLAME_PARTICLE.get(), LongGhostlyFlameParticleParticle::provider
      );
   }
}

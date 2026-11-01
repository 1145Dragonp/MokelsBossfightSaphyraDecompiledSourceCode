package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.potion.BlessingOfTheWhiteFlameMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.CooldownMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.DisgustEffectMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.GriefEffectMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.ImmuneMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.ManicEffectMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.NoBuildMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.NoGravityMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.RotEffectMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.RuleCooldownMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.SprintMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.StayStillMobEffect;
import mrmd.mokelsbossfightsaphyraup.potion.StunMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MokelsBossfightSaphyraModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "mokels_bossfight_saphyra");
   public static final RegistryObject<MobEffect> IMMUNE = REGISTRY.register("immune", () -> new ImmuneMobEffect());
   public static final RegistryObject<MobEffect> COOLDOWN = REGISTRY.register("cooldown", () -> new CooldownMobEffect());
   public static final RegistryObject<MobEffect> GRIEF_EFFECT = REGISTRY.register("grief_effect", () -> new GriefEffectMobEffect());
   public static final RegistryObject<MobEffect> ROT_EFFECT = REGISTRY.register("rot_effect", () -> new RotEffectMobEffect());
   public static final RegistryObject<MobEffect> NO_BUILD = REGISTRY.register("no_build", () -> new NoBuildMobEffect());
   public static final RegistryObject<MobEffect> DISGUST_EFFECT = REGISTRY.register("disgust_effect", () -> new DisgustEffectMobEffect());
   public static final RegistryObject<MobEffect> STAY_STILL = REGISTRY.register("stay_still", () -> new StayStillMobEffect());
   public static final RegistryObject<MobEffect> NO_GRAVITY = REGISTRY.register("no_gravity", () -> new NoGravityMobEffect());
   public static final RegistryObject<MobEffect> SPRINT = REGISTRY.register("sprint", () -> new SprintMobEffect());
   public static final RegistryObject<MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
   public static final RegistryObject<MobEffect> RULE_COOLDOWN = REGISTRY.register("rule_cooldown", () -> new RuleCooldownMobEffect());
   public static final RegistryObject<MobEffect> MANIC_EFFECT = REGISTRY.register("manic_effect", () -> new ManicEffectMobEffect());
   public static final RegistryObject<MobEffect> BLESSING_OF_THE_WHITE_FLAME = REGISTRY.register(
      "blessing_of_the_white_flame", () -> new BlessingOfTheWhiteFlameMobEffect()
   );
}

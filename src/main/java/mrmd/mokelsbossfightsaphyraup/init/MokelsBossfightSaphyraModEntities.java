package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.entity.DisgustProjectileFallEntity;
import mrmd.mokelsbossfightsaphyraup.entity.GhostSpiritEntity;
import mrmd.mokelsbossfightsaphyraup.entity.GhostZombieEntity;
import mrmd.mokelsbossfightsaphyraup.entity.InfestedWitchEntity;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraEntity;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraHallowedTower2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.LinaraHallowedTowerEntity;
import mrmd.mokelsbossfightsaphyraup.entity.MarleneHumanFormDialog2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.MarleneHumanFormEntity;
import mrmd.mokelsbossfightsaphyraup.entity.MirrorBladeProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.entity.MoonbeamEntity;
import mrmd.mokelsbossfightsaphyraup.entity.MothbossEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessInvisibleProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessProjectileFallEntity;
import mrmd.mokelsbossfightsaphyraup.entity.NamelessSpawnEntity;
import mrmd.mokelsbossfightsaphyraup.entity.PuppetOfYivaNemorEntity;
import mrmd.mokelsbossfightsaphyraup.entity.PutridRoseEntity;
import mrmd.mokelsbossfightsaphyraup.entity.RotProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog1Entity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog2Entity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog3Entity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraDialog4Entity;
import mrmd.mokelsbossfightsaphyraup.entity.SaphyraSpawnEntity;
import mrmd.mokelsbossfightsaphyraup.entity.ScorchedEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectileEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchBossProjectilefallEntity;
import mrmd.mokelsbossfightsaphyraup.entity.WitchbossEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.Level;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class MokelsBossfightSaphyraModEntities {
   public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "mokels_bossfight_saphyra");
   public static final RegistryObject<EntityType<WitchbossEntity>> WITCHBOSS = register(
           "witchboss",
           Builder.of((EntityType<WitchbossEntity> type, Level level) -> new WitchbossEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(128)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(WitchbossEntity::new)
                   .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<MoonbeamEntity>> MOONBEAM = register(
           "moonbeam",
           Builder.of((EntityType<MoonbeamEntity> type, Level level) -> new MoonbeamEntity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(MoonbeamEntity::new)
                   .fireImmune()
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<WitchBossProjectileEntity>> WITCH_BOSS_PROJECTILE = register(
           "witch_boss_projectile",
           Builder.of((EntityType<WitchBossProjectileEntity> type, Level level) -> new WitchBossProjectileEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(WitchBossProjectileEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<WitchBossProjectilefallEntity>> WITCH_BOSS_PROJECTILEFALL = register(
           "witch_boss_projectilefall",
           Builder.of((EntityType<WitchBossProjectilefallEntity> type, Level level) -> new WitchBossProjectilefallEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(WitchBossProjectilefallEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<GhostSpiritEntity>> GHOST_SPIRIT = register(
           "ghost_spirit",
           Builder.of((EntityType<GhostSpiritEntity> type, Level level) -> new GhostSpiritEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(GhostSpiritEntity::new)
                   .sized(0.8F, 1.0F)
   );
   public static final RegistryObject<EntityType<MothbossEntity>> MOTHBOSS = register(
           "mothboss",
           Builder.of((EntityType<MothbossEntity> type, Level level) -> new MothbossEntity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(128)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(MothbossEntity::new)
                   .sized(0.9F, 3.0F)
   );
   public static final RegistryObject<EntityType<PutridRoseEntity>> PUTRID_ROSE = register(
           "putrid_rose",
           Builder.of((EntityType<PutridRoseEntity> type, Level level) -> new PutridRoseEntity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(128)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(PutridRoseEntity::new)
                   .sized(1.9F, 3.9F)
   );
   public static final RegistryObject<EntityType<GhostZombieEntity>> GHOST_ZOMBIE = register(
           "ghost_zombie",
           Builder.of((EntityType<GhostZombieEntity> type, Level level) -> new GhostZombieEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(GhostZombieEntity::new)
                   .fireImmune()
                   .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<NamelessEntity>> NAMELESS = register(
           "nameless",
           Builder.of((EntityType<NamelessEntity> type, Level level) -> new NamelessEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(128)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(NamelessEntity::new)
                   .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<NamelessProjectileFallEntity>> NAMELESS_PROJECTILE_FALL = register(
           "nameless_projectile_fall",
           Builder.of((EntityType<NamelessProjectileFallEntity> type, Level level) -> new NamelessProjectileFallEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(NamelessProjectileFallEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<NamelessInvisibleProjectileEntity>> NAMELESS_INVISIBLE_PROJECTILE = register(
           "nameless_invisible_projectile",
           Builder.of((EntityType<NamelessInvisibleProjectileEntity> type, Level level) -> new NamelessInvisibleProjectileEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(NamelessInvisibleProjectileEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DisgustProjectileFallEntity>> DISGUST_PROJECTILE_FALL = register(
           "disgust_projectile_fall",
           Builder.of((EntityType<DisgustProjectileFallEntity> type, Level level) -> new DisgustProjectileFallEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(DisgustProjectileFallEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<LinaraEntity>> LINARA = register(
           "linara",
           Builder.of((EntityType<LinaraEntity> type, Level level) -> new LinaraEntity(type, level), MobCategory.AMBIENT)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(LinaraEntity::new)
                   .fireImmune()
                   .sized(0.8F, 1.2F)
   );
   public static final RegistryObject<EntityType<PuppetOfYivaNemorEntity>> PUPPET_OF_YIVA_NEMOR = register(
           "puppet_of_yiva_nemor",
           Builder.of((EntityType<PuppetOfYivaNemorEntity> type, Level level) -> new PuppetOfYivaNemorEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(128)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(PuppetOfYivaNemorEntity::new)
                   .sized(0.6F, 2.3F)
   );
   public static final RegistryObject<EntityType<SaphyraDialog1Entity>> SAPHYRA_DIALOG_1 = register(
           "saphyra_dialog_1",
           Builder.of((EntityType<SaphyraDialog1Entity> type, Level level) -> new SaphyraDialog1Entity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(SaphyraDialog1Entity::new)
                   .fireImmune()
                   .sized(0.9F, 2.0F)
   );
   public static final RegistryObject<EntityType<SaphyraDialog2Entity>> SAPHYRA_DIALOG_2 = register(
           "saphyra_dialog_2",
           Builder.of((EntityType<SaphyraDialog2Entity> type, Level level) -> new SaphyraDialog2Entity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(SaphyraDialog2Entity::new)
                   .fireImmune()
                   .sized(0.9F, 2.0F)
   );
   public static final RegistryObject<EntityType<MirrorBladeProjectileEntity>> MIRROR_BLADE_PROJECTILE = register(
           "mirror_blade_projectile",
           Builder.of((EntityType<MirrorBladeProjectileEntity> type, Level level) -> new MirrorBladeProjectileEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(MirrorBladeProjectileEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<RotProjectileEntity>> ROT_PROJECTILE = register(
           "rot_projectile",
           Builder.of((EntityType<RotProjectileEntity> type, Level level) -> new RotProjectileEntity(type, level), MobCategory.MISC)
                   .setCustomClientFactory(RotProjectileEntity::new)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(1)
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<NamelessSpawnEntity>> NAMELESS_SPAWN = register(
           "nameless_spawn",
           Builder.of((EntityType<NamelessSpawnEntity> type, Level level) -> new NamelessSpawnEntity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(NamelessSpawnEntity::new)
                   .fireImmune()
                   .sized(1.2F, 1.2F)
   );
   public static final RegistryObject<EntityType<MarleneHumanFormEntity>> MARLENE_HUMAN_FORM = register(
           "marlene_human_form",
           Builder.of((EntityType<MarleneHumanFormEntity> type, Level level) -> new MarleneHumanFormEntity(type, level), MobCategory.AMBIENT)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(MarleneHumanFormEntity::new)
                   .fireImmune()
                   .sized(0.6F, 1.9F)
   );
   public static final RegistryObject<EntityType<SaphyraDialog3Entity>> SAPHYRA_DIALOG_3 = register(
           "saphyra_dialog_3",
           Builder.of((EntityType<SaphyraDialog3Entity> type, Level level) -> new SaphyraDialog3Entity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(SaphyraDialog3Entity::new)
                   .fireImmune()
                   .sized(0.9F, 2.0F)
   );
   public static final RegistryObject<EntityType<MarleneHumanFormDialog2Entity>> MARLENE_HUMAN_FORM_DIALOG_2 = register(
           "marlene_human_form_dialog_2",
           Builder.of((EntityType<MarleneHumanFormDialog2Entity> type, Level level) -> new MarleneHumanFormDialog2Entity(type, level), MobCategory.AMBIENT)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(MarleneHumanFormDialog2Entity::new)
                   .fireImmune()
                   .sized(0.6F, 1.9F)
   );
   public static final RegistryObject<EntityType<LinaraHallowedTowerEntity>> LINARA_HALLOWED_TOWER = register(
           "linara_hallowed_tower",
           Builder.of((EntityType<LinaraHallowedTowerEntity> type, Level level) -> new LinaraHallowedTowerEntity(type, level), MobCategory.AMBIENT)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(LinaraHallowedTowerEntity::new)
                   .fireImmune()
                   .sized(0.8F, 1.2F)
   );
   public static final RegistryObject<EntityType<LinaraHallowedTower2Entity>> LINARA_HALLOWED_TOWER_2 = register(
           "linara_hallowed_tower_2",
           Builder.of((EntityType<LinaraHallowedTower2Entity> type, Level level) -> new LinaraHallowedTower2Entity(type, level), MobCategory.AMBIENT)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(LinaraHallowedTower2Entity::new)
                   .fireImmune()
                   .sized(0.8F, 1.2F)
   );
   public static final RegistryObject<EntityType<ScorchedEntity>> SCORCHED = register(
           "scorched",
           Builder.of((EntityType<ScorchedEntity> type, Level level) -> new ScorchedEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(ScorchedEntity::new)
                   .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<InfestedWitchEntity>> INFESTED_WITCH = register(
           "infested_witch",
           Builder.of((EntityType<InfestedWitchEntity> type, Level level) -> new InfestedWitchEntity(type, level), MobCategory.CREATURE)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(InfestedWitchEntity::new)
                   .sized(1.0F, 1.4F)
   );
   public static final RegistryObject<EntityType<SaphyraSpawnEntity>> SAPHYRA_SPAWN = register(
           "saphyra_spawn",
           Builder.of((EntityType<SaphyraSpawnEntity> type, Level level) -> new SaphyraSpawnEntity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(SaphyraSpawnEntity::new)
                   .fireImmune()
                   .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SaphyraDialog4Entity>> SAPHYRA_DIALOG_4 = register(
           "saphyra_dialog_4",
           Builder.of((EntityType<SaphyraDialog4Entity> type, Level level) -> new SaphyraDialog4Entity(type, level), MobCategory.MONSTER)
                   .setShouldReceiveVelocityUpdates(true)
                   .setTrackingRange(64)
                   .setUpdateInterval(3)
                   .setCustomClientFactory(SaphyraDialog4Entity::new)
                   .fireImmune()
                   .sized(0.9F, 2.0F)
   );

   private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
      return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> {
         WitchbossEntity.init();
         MoonbeamEntity.init();
         GhostSpiritEntity.init();
         MothbossEntity.init();
         PutridRoseEntity.init();
         GhostZombieEntity.init();
         NamelessEntity.init();
         LinaraEntity.init();
         PuppetOfYivaNemorEntity.init();
         SaphyraDialog1Entity.init();
         SaphyraDialog2Entity.init();
         NamelessSpawnEntity.init();
         MarleneHumanFormEntity.init();
         SaphyraDialog3Entity.init();
         MarleneHumanFormDialog2Entity.init();
         LinaraHallowedTowerEntity.init();
         LinaraHallowedTower2Entity.init();
         ScorchedEntity.init();
         InfestedWitchEntity.init();
         SaphyraSpawnEntity.init();
         SaphyraDialog4Entity.init();
      });
   }

   @SubscribeEvent
   public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put((EntityType)WITCHBOSS.get(), WitchbossEntity.createAttributes().build());
      event.put((EntityType)MOONBEAM.get(), MoonbeamEntity.createAttributes().build());
      event.put((EntityType)GHOST_SPIRIT.get(), GhostSpiritEntity.createAttributes().build());
      event.put((EntityType)MOTHBOSS.get(), MothbossEntity.createAttributes().build());
      event.put((EntityType)PUTRID_ROSE.get(), PutridRoseEntity.createAttributes().build());
      event.put((EntityType)GHOST_ZOMBIE.get(), GhostZombieEntity.createAttributes().build());
      event.put((EntityType)NAMELESS.get(), NamelessEntity.createAttributes().build());
      event.put((EntityType)LINARA.get(), LinaraEntity.createAttributes().build());
      event.put((EntityType)PUPPET_OF_YIVA_NEMOR.get(), PuppetOfYivaNemorEntity.createAttributes().build());
      event.put((EntityType)SAPHYRA_DIALOG_1.get(), SaphyraDialog1Entity.createAttributes().build());
      event.put((EntityType)SAPHYRA_DIALOG_2.get(), SaphyraDialog2Entity.createAttributes().build());
      event.put((EntityType)NAMELESS_SPAWN.get(), NamelessSpawnEntity.createAttributes().build());
      event.put((EntityType)MARLENE_HUMAN_FORM.get(), MarleneHumanFormEntity.createAttributes().build());
      event.put((EntityType)SAPHYRA_DIALOG_3.get(), SaphyraDialog3Entity.createAttributes().build());
      event.put((EntityType)MARLENE_HUMAN_FORM_DIALOG_2.get(), MarleneHumanFormDialog2Entity.createAttributes().build());
      event.put((EntityType)LINARA_HALLOWED_TOWER.get(), LinaraHallowedTowerEntity.createAttributes().build());
      event.put((EntityType)LINARA_HALLOWED_TOWER_2.get(), LinaraHallowedTower2Entity.createAttributes().build());
      event.put((EntityType)SCORCHED.get(), ScorchedEntity.createAttributes().build());
      event.put((EntityType)INFESTED_WITCH.get(), InfestedWitchEntity.createAttributes().build());
      event.put((EntityType)SAPHYRA_SPAWN.get(), SaphyraSpawnEntity.createAttributes().build());
      event.put((EntityType)SAPHYRA_DIALOG_4.get(), SaphyraDialog4Entity.createAttributes().build());
   }
}
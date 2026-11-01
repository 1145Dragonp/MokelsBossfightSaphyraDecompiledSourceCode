package mrmd.mokelsbossfightsaphyraup.init;

import mrmd.mokelsbossfightsaphyraup.block.display.BossDoor1DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.BossDoor3DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.BossDoorDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueAktivatedDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.LyiorStatueDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.OddmentHallowedTowerDisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.OddmentStage2DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor1DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor2DisplayItem;
import mrmd.mokelsbossfightsaphyraup.block.display.SaphyraDoor3DisplayItem;
import mrmd.mokelsbossfightsaphyraup.item.AddCurseItem;
import mrmd.mokelsbossfightsaphyraup.item.BellSpiritItem;
import mrmd.mokelsbossfightsaphyraup.item.BottomlessBagItem;
import mrmd.mokelsbossfightsaphyraup.item.BrokenSigilOfTheRedSun2Item;
import mrmd.mokelsbossfightsaphyraup.item.BrokenSigilOfTheRedSunItem;
import mrmd.mokelsbossfightsaphyraup.item.EmptyRuleItem;
import mrmd.mokelsbossfightsaphyraup.item.FlaskOfHealingItem;
import mrmd.mokelsbossfightsaphyraup.item.FlaskOfHealinglvltwoItem;
import mrmd.mokelsbossfightsaphyraup.item.GluttonousFlaskItem;
import mrmd.mokelsbossfightsaphyraup.item.GrassVisageItem;
import mrmd.mokelsbossfightsaphyraup.item.HallowedKey1Item;
import mrmd.mokelsbossfightsaphyraup.item.HallowedKey2Item;
import mrmd.mokelsbossfightsaphyraup.item.HallowedKey3Item;
import mrmd.mokelsbossfightsaphyraup.item.InvitationToTheHallowedTowerItem;
import mrmd.mokelsbossfightsaphyraup.item.KatanaHeavyItem;
import mrmd.mokelsbossfightsaphyraup.item.KatanaLightItem;
import mrmd.mokelsbossfightsaphyraup.item.KatanaPoolOfRotItem;
import mrmd.mokelsbossfightsaphyraup.item.Key1Item;
import mrmd.mokelsbossfightsaphyraup.item.Key2Item;
import mrmd.mokelsbossfightsaphyraup.item.Key3Item;
import mrmd.mokelsbossfightsaphyraup.item.Key4Item;
import mrmd.mokelsbossfightsaphyraup.item.LouringClaymoreItem;
import mrmd.mokelsbossfightsaphyraup.item.ManicEyeItem;
import mrmd.mokelsbossfightsaphyraup.item.MirrorBladeItem;
import mrmd.mokelsbossfightsaphyraup.item.NamelessGatekeeperRemembranceItem;
import mrmd.mokelsbossfightsaphyraup.item.PuppetOfYivaRemembranceItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfDespairItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfExudationItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfHateredItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfHungerItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfPurificationItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfSobbingItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfThePLaguedItem;
import mrmd.mokelsbossfightsaphyraup.item.RuleOfVisionItem;
import mrmd.mokelsbossfightsaphyraup.item.SaphyraKeyItem;
import mrmd.mokelsbossfightsaphyraup.item.SaphyraRemembranceItem;
import mrmd.mokelsbossfightsaphyraup.item.SaphyrasCapeItem;
import mrmd.mokelsbossfightsaphyraup.item.SaphyrasHatItem;
import mrmd.mokelsbossfightsaphyraup.item.ScrollItem;
import mrmd.mokelsbossfightsaphyraup.item.ShatteredBloodVailItem;
import mrmd.mokelsbossfightsaphyraup.item.SigilOfTheRedSunItem;
import mrmd.mokelsbossfightsaphyraup.item.SigilOfTheRedSunStage2Item;
import mrmd.mokelsbossfightsaphyraup.item.SigilOfTheRedSunStage3Item;
import mrmd.mokelsbossfightsaphyraup.item.SinisterBagItem;
import mrmd.mokelsbossfightsaphyraup.item.SpiritRuneSwordItem;
import mrmd.mokelsbossfightsaphyraup.item.SpriritualRuneItem;
import mrmd.mokelsbossfightsaphyraup.item.SunveilItem;
import mrmd.mokelsbossfightsaphyraup.item.SwordOfTheNamelessGatekeeperItem;
import mrmd.mokelsbossfightsaphyraup.item.SwordTearAndDropletItem;
import mrmd.mokelsbossfightsaphyraup.item.TheFirstGodItem;
import mrmd.mokelsbossfightsaphyraup.item.TotemOfRotAndDecayItem;
import mrmd.mokelsbossfightsaphyraup.item.VocalCordsItem;
import mrmd.mokelsbossfightsaphyraup.item.WarriorKeyItem;
import mrmd.mokelsbossfightsaphyraup.item.WitchStaffItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MokelsBossfightSaphyraModItems {
   public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "mokels_bossfight_saphyra");
   public static final RegistryObject<Item> WITCHBOSS_SPAWN_EGG = REGISTRY.register(
      "witchboss_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.WITCHBOSS, -10263709, -6684710, new Properties())
   );
   public static final RegistryObject<Item> TOTEM_OF_ROT_AND_DECAY = REGISTRY.register("totem_of_rot_and_decay", () -> new TotemOfRotAndDecayItem());
   public static final RegistryObject<Item> BOTTOMLESS_BAG = REGISTRY.register("bottomless_bag", () -> new BottomlessBagItem());
   public static final RegistryObject<Item> WITCH_STAFF = REGISTRY.register("witch_staff", () -> new WitchStaffItem());
   public static final RegistryObject<Item> FLASK_OF_HEALING = REGISTRY.register("flask_of_healing", () -> new FlaskOfHealingItem());
   public static final RegistryObject<Item> FLASK_OF_HEALINGLVLTWO = REGISTRY.register("flask_of_healinglvltwo", () -> new FlaskOfHealinglvltwoItem());
   public static final RegistryObject<Item> SPRIRITUAL_RUNE = REGISTRY.register("spriritual_rune", () -> new SpriritualRuneItem());
   public static final RegistryObject<Item> SAPHYRAS_HAT_HELMET = REGISTRY.register("saphyras_hat_helmet", () -> new SaphyrasHatItem.Helmet());
   public static final RegistryObject<Item> SPIRIT_RUNE_SWORD = REGISTRY.register("spirit_rune_sword", () -> new SpiritRuneSwordItem());
   public static final RegistryObject<Item> BELL_SPIRIT = REGISTRY.register("bell_spirit", () -> new BellSpiritItem());
   public static final RegistryObject<Item> MOTHBOSS_SPAWN_EGG = REGISTRY.register(
      "mothboss_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.MOTHBOSS, -5855578, -12527732, new Properties())
   );
   public static final RegistryObject<Item> RULE_OF_PURIFICATION = REGISTRY.register("rule_of_purification", () -> new RuleOfPurificationItem());
   public static final RegistryObject<Item> EMPTY_RULE = REGISTRY.register("empty_rule", () -> new EmptyRuleItem());
   public static final RegistryObject<Item> RULE_OF_VISION = REGISTRY.register("rule_of_vision", () -> new RuleOfVisionItem());
   public static final RegistryObject<Item> NAMELESS_SPAWN_EGG = REGISTRY.register(
      "nameless_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.NAMELESS, -11711155, -6222065, new Properties())
   );
   public static final RegistryObject<Item> BOSS_DOOR2 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.BOSS_DOOR2.getId().getPath(),
      () -> new BossDoorDisplayItem((Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR2.get(), new Properties())
   );
   public static final RegistryObject<Item> LYIOR_STATUE = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.LYIOR_STATUE.getId().getPath(),
      () -> new LyiorStatueDisplayItem((Block)MokelsBossfightSaphyraModBlocks.LYIOR_STATUE.get(), new Properties())
   );
   public static final RegistryObject<Item> LYIOR_STATUE_AKTIVATED = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.LYIOR_STATUE_AKTIVATED.getId().getPath(),
      () -> new LyiorStatueAktivatedDisplayItem((Block)MokelsBossfightSaphyraModBlocks.LYIOR_STATUE_AKTIVATED.get(), new Properties())
   );
   public static final RegistryObject<Item> AZURE_BRICKS = block(MokelsBossfightSaphyraModBlocks.AZURE_BRICKS);
   public static final RegistryObject<Item> AZURE_SLAB = block(MokelsBossfightSaphyraModBlocks.AZURE_SLAB);
   public static final RegistryObject<Item> AZURE_STAIRS = block(MokelsBossfightSaphyraModBlocks.AZURE_STAIRS);
   public static final RegistryObject<Item> AZURE_WALL = block(MokelsBossfightSaphyraModBlocks.AZURE_WALL);
   public static final RegistryObject<Item> AZURE_BRICKS_ANIMATED = block(MokelsBossfightSaphyraModBlocks.AZURE_BRICKS_ANIMATED);
   public static final RegistryObject<Item> BOSS_DOOR_1 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.BOSS_DOOR_1.getId().getPath(),
      () -> new BossDoor1DisplayItem((Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR_1.get(), new Properties())
   );
   public static final RegistryObject<Item> WARRIOR_KEY = REGISTRY.register("warrior_key", () -> new WarriorKeyItem());
   public static final RegistryObject<Item> BOSS_DOOR_3 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.BOSS_DOOR_3.getId().getPath(),
      () -> new BossDoor3DisplayItem((Block)MokelsBossfightSaphyraModBlocks.BOSS_DOOR_3.get(), new Properties())
   );
   public static final RegistryObject<Item> ADD_CURSE = REGISTRY.register("add_curse", () -> new AddCurseItem());
   public static final RegistryObject<Item> SHATTERED_BLOOD_VAIL = REGISTRY.register("shattered_blood_vail", () -> new ShatteredBloodVailItem());
   public static final RegistryObject<Item> RULE_OF_HATERED = REGISTRY.register("rule_of_hatered", () -> new RuleOfHateredItem());
   public static final RegistryObject<Item> GLUTTONOUS_FLASK = REGISTRY.register("gluttonous_flask", () -> new GluttonousFlaskItem());
   public static final RegistryObject<Item> SPACE_BLOCK = block(MokelsBossfightSaphyraModBlocks.SPACE_BLOCK);
   public static final RegistryObject<SaphyrasCapeItem> SAPHYRAS_CAPE_CHESTPLATE = REGISTRY.register(
      "saphyras_cape_chestplate", () -> new SaphyrasCapeItem(Type.CHESTPLATE, new Properties().fireResistant())
   );
   public static final RegistryObject<Item> ODDMENT_STAGE_2 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.ODDMENT_STAGE_2.getId().getPath(),
      () -> new OddmentStage2DisplayItem((Block)MokelsBossfightSaphyraModBlocks.ODDMENT_STAGE_2.get(), new Properties())
   );
   public static final RegistryObject<Item> RULE_OF_HUNGER = REGISTRY.register("rule_of_hunger", () -> new RuleOfHungerItem());
   public static final RegistryObject<Item> RULE_OF_THE_P_LAGUED = REGISTRY.register("rule_of_the_p_lagued", () -> new RuleOfThePLaguedItem());
   public static final RegistryObject<Item> SIGIL_OF_THE_RED_SUN = REGISTRY.register("sigil_of_the_red_sun", () -> new SigilOfTheRedSunItem());
   public static final RegistryObject<Item> VOCAL_CORDS = REGISTRY.register("vocal_cords", () -> new VocalCordsItem());
   public static final RegistryObject<Item> LINARA_SPAWN_EGG = REGISTRY.register(
      "linara_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.LINARA, -10914729, -11126220, new Properties())
   );
   public static final RegistryObject<Item> GRASS_VISAGE_HELMET = REGISTRY.register("grass_visage_helmet", () -> new GrassVisageItem.Helmet());
   public static final RegistryObject<Item> SWORD_OF_THE_NAMELESS_GATEKEEPER = REGISTRY.register(
      "sword_of_the_nameless_gatekeeper", () -> new SwordOfTheNamelessGatekeeperItem()
   );
   public static final RegistryObject<Item> BLOOD_WALL = block(MokelsBossfightSaphyraModBlocks.BLOOD_WALL);
   public static final RegistryObject<Item> BLOOD_BRICKS = block(MokelsBossfightSaphyraModBlocks.BLOOD_BRICKS);
   public static final RegistryObject<Item> POLISHED_BLOOD_BRICKS = block(MokelsBossfightSaphyraModBlocks.POLISHED_BLOOD_BRICKS);
   public static final RegistryObject<Item> DARK_POLISHED_BLOOD_BRICKS = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_BLOOD_BRICKS);
   public static final RegistryObject<Item> DARK_POLISHED_BLOOD_WALL = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_BLOOD_WALL);
   public static final RegistryObject<Item> DARK_POLISHED_BLOOD_STAIRS = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_BLOOD_STAIRS);
   public static final RegistryObject<Item> DARK_POLISHED_BLOOD_SLAB = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_BLOOD_SLAB);
   public static final RegistryObject<Item> BLOOD_BRICKS_SLAB = block(MokelsBossfightSaphyraModBlocks.BLOOD_BRICKS_SLAB);
   public static final RegistryObject<Item> BLOOD_BRICKS_STAIRS = block(MokelsBossfightSaphyraModBlocks.BLOOD_BRICKS_STAIRS);
   public static final RegistryObject<Item> PUPPET_OF_YIVA_REMEMBRANCE = REGISTRY.register(
      "puppet_of_yiva_remembrance", () -> new PuppetOfYivaRemembranceItem()
   );
   public static final RegistryObject<Item> SAPHYRA_REMEMBRANCE = REGISTRY.register("saphyra_remembrance", () -> new SaphyraRemembranceItem());
   public static final RegistryObject<Item> BLOOD_LANTERN = block(MokelsBossfightSaphyraModBlocks.BLOOD_LANTERN);
   public static final RegistryObject<Item> RULE_OF_EXUDATION = REGISTRY.register("rule_of_exudation", () -> new RuleOfExudationItem());
   public static final RegistryObject<Item> WHITE_FLAME = block(MokelsBossfightSaphyraModBlocks.WHITE_FLAME);
   public static final RegistryObject<Item> BLOOD_DOOR_1 = doubleBlock(MokelsBossfightSaphyraModBlocks.BLOOD_DOOR_1);
   public static final RegistryObject<Item> KEY_1 = REGISTRY.register("key_1", () -> new Key1Item());
   public static final RegistryObject<Item> KEY_2 = REGISTRY.register("key_2", () -> new Key2Item());
   public static final RegistryObject<Item> KEY_3 = REGISTRY.register("key_3", () -> new Key3Item());
   public static final RegistryObject<Item> KEY_4 = REGISTRY.register("key_4", () -> new Key4Item());
   public static final RegistryObject<Item> NAMELESS_GATEKEEPER_REMEMBRANCE = REGISTRY.register(
      "nameless_gatekeeper_remembrance", () -> new NamelessGatekeeperRemembranceItem()
   );
   public static final RegistryObject<Item> POLISHED_AZURE_BRICKS = block(MokelsBossfightSaphyraModBlocks.POLISHED_AZURE_BRICKS);
   public static final RegistryObject<Item> AZURE_LANTERN = block(MokelsBossfightSaphyraModBlocks.AZURE_LANTERN);
   public static final RegistryObject<Item> DARK_POLISHED_AZURE_BRICKS = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_AZURE_BRICKS);
   public static final RegistryObject<Item> DARK_POLISHED_AZURE_SLAB = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_AZURE_SLAB);
   public static final RegistryObject<Item> DARK_POLISHED_AZURE_STAIRS = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_AZURE_STAIRS);
   public static final RegistryObject<Item> DARK_POLISHED_AZURE_WALL = block(MokelsBossfightSaphyraModBlocks.DARK_POLISHED_AZURE_WALL);
   public static final RegistryObject<Item> SAPHYRA_DIALOG_1_SPAWN_EGG = REGISTRY.register(
      "saphyra_dialog_1_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.SAPHYRA_DIALOG_1, -1, -3342337, new Properties())
   );
   public static final RegistryObject<Item> INVITATION_TO_THE_HALLOWED_TOWER = REGISTRY.register(
      "invitation_to_the_hallowed_tower", () -> new InvitationToTheHallowedTowerItem()
   );
   public static final RegistryObject<Item> LOURING_CLAYMORE = REGISTRY.register("louring_claymore", () -> new LouringClaymoreItem());
   public static final RegistryObject<Item> SUNVEIL = REGISTRY.register("sunveil", () -> new SunveilItem());
   public static final RegistryObject<Item> MIRROR_BLADE = REGISTRY.register("mirror_blade", () -> new MirrorBladeItem());
   public static final RegistryObject<Item> NAMELESS_SPAWN_SPAWN_EGG = REGISTRY.register(
      "nameless_spawn_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.NAMELESS_SPAWN, -13421773, -3407872, new Properties())
   );
   public static final RegistryObject<Item> MARLENE_HUMAN_FORM_SPAWN_EGG = REGISTRY.register(
      "marlene_human_form_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.MARLENE_HUMAN_FORM, -15066598, -10473907, new Properties())
   );
   public static final RegistryObject<Item> HALLOWED_KEY_1 = REGISTRY.register("hallowed_key_1", () -> new HallowedKey1Item());
   public static final RegistryObject<Item> HALLOWED_KEY_2 = REGISTRY.register("hallowed_key_2", () -> new HallowedKey2Item());
   public static final RegistryObject<Item> HALLOWED_KEY_3 = REGISTRY.register("hallowed_key_3", () -> new HallowedKey3Item());
   public static final RegistryObject<Item> LOCKED_FOG_CHAIN = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_CHAIN);
   public static final RegistryObject<Item> LOCKED_FOG_SHATTERED = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_SHATTERED);
   public static final RegistryObject<Item> LOCKED_FOG_WORSHIP = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_WORSHIP);
   public static final RegistryObject<Item> LOCKED_FOG_KNIFE = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_KNIFE);
   public static final RegistryObject<Item> LOCKED_FOG_STEPS = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_STEPS);
   public static final RegistryObject<Item> LOCKED_FOG_LOVERS = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_LOVERS);
   public static final RegistryObject<Item> LOCKED_FOG_HATERED = block(MokelsBossfightSaphyraModBlocks.LOCKED_FOG_HATERED);
   public static final RegistryObject<Item> SIGIL_OF_THE_RED_SUN_STAGE_2 = REGISTRY.register(
      "sigil_of_the_red_sun_stage_2", () -> new SigilOfTheRedSunStage2Item()
   );
   public static final RegistryObject<Item> SIGIL_OF_THE_RED_SUN_STAGE_3 = REGISTRY.register(
      "sigil_of_the_red_sun_stage_3", () -> new SigilOfTheRedSunStage3Item()
   );
   public static final RegistryObject<Item> THE_FIRST_GOD = REGISTRY.register("the_first_god", () -> new TheFirstGodItem());
   public static final RegistryObject<Item> SINISTER_BAG = REGISTRY.register("sinister_bag", () -> new SinisterBagItem());
   public static final RegistryObject<Item> BROKEN_SIGIL_OF_THE_RED_SUN = REGISTRY.register(
      "broken_sigil_of_the_red_sun", () -> new BrokenSigilOfTheRedSunItem()
   );
   public static final RegistryObject<Item> MANIC_EYE = REGISTRY.register("manic_eye", () -> new ManicEyeItem());
   public static final RegistryObject<Item> ODDMENT_HALLOWED_TOWER = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.ODDMENT_HALLOWED_TOWER.getId().getPath(),
      () -> new OddmentHallowedTowerDisplayItem((Block)MokelsBossfightSaphyraModBlocks.ODDMENT_HALLOWED_TOWER.get(), new Properties())
   );
   public static final RegistryObject<Item> RED_GLASS = block(MokelsBossfightSaphyraModBlocks.RED_GLASS);
   public static final RegistryObject<Item> BOSS_FOG = block(MokelsBossfightSaphyraModBlocks.BOSS_FOG);
   public static final RegistryObject<Item> SCORCHED_SPAWN_EGG = REGISTRY.register(
      "scorched_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.SCORCHED, -13228507, -12120819, new Properties())
   );
   public static final RegistryObject<Item> INFESTED_WITCH_SPAWN_EGG = REGISTRY.register(
      "infested_witch_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.INFESTED_WITCH, -9300972, -12120819, new Properties())
   );
   public static final RegistryObject<Item> BROKEN_SIGIL_OF_THE_RED_SUN_2 = REGISTRY.register(
      "broken_sigil_of_the_red_sun_2", () -> new BrokenSigilOfTheRedSun2Item()
   );
   public static final RegistryObject<Item> SAPHYRA_SPAWN_SPAWN_EGG = REGISTRY.register(
      "saphyra_spawn_spawn_egg", () -> new ForgeSpawnEggItem(MokelsBossfightSaphyraModEntities.SAPHYRA_SPAWN, -13369345, -16711681, new Properties())
   );
   public static final RegistryObject<Item> SCROLL = REGISTRY.register("scroll", () -> new ScrollItem());
   public static final RegistryObject<Item> KATANA_HEAVY = REGISTRY.register("katana_heavy", () -> new KatanaHeavyItem());
   public static final RegistryObject<Item> KATANA_LIGHT = REGISTRY.register("katana_light", () -> new KatanaLightItem());
   public static final RegistryObject<Item> KATANA_POOL_OF_ROT = REGISTRY.register("katana_pool_of_rot", () -> new KatanaPoolOfRotItem());
   public static final RegistryObject<Item> SWORD_TEAR_AND_DROPLET = REGISTRY.register("sword_tear_and_droplet", () -> new SwordTearAndDropletItem());
   public static final RegistryObject<Item> RULE_OF_DESPAIR = REGISTRY.register("rule_of_despair", () -> new RuleOfDespairItem());
   public static final RegistryObject<Item> RULE_OF_SOBBING = REGISTRY.register("rule_of_sobbing", () -> new RuleOfSobbingItem());
   public static final RegistryObject<Item> AZURE_TILES = block(MokelsBossfightSaphyraModBlocks.AZURE_TILES);
   public static final RegistryObject<Item> SAPHYRA_DOOR_1 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_1.getId().getPath(),
      () -> new SaphyraDoor1DisplayItem((Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_1.get(), new Properties())
   );
   public static final RegistryObject<Item> SAPHYRA_DOOR_2 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_2.getId().getPath(),
      () -> new SaphyraDoor2DisplayItem((Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_2.get(), new Properties())
   );
   public static final RegistryObject<Item> SAPHYRA_DOOR_3 = REGISTRY.register(
      MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_3.getId().getPath(),
      () -> new SaphyraDoor3DisplayItem((Block)MokelsBossfightSaphyraModBlocks.SAPHYRA_DOOR_3.get(), new Properties())
   );
   public static final RegistryObject<Item> SAPHYRA_KEY = REGISTRY.register("saphyra_key", () -> new SaphyraKeyItem());

   private static RegistryObject<Item> block(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Properties()));
   }

   private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem((Block)block.get(), new Properties()));
   }
}

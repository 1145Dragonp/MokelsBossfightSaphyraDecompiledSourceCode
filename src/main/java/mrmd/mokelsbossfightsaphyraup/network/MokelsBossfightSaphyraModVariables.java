package mrmd.mokelsbossfightsaphyraup.network;

import java.util.function.Supplier;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class MokelsBossfightSaphyraModVariables {
   public static final Capability<MokelsBossfightSaphyraModVariables.PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(
      new CapabilityToken<MokelsBossfightSaphyraModVariables.PlayerVariables>() {
      }
   );

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      MokelsBossfightSaphyraMod.addNetworkMessage(
         MokelsBossfightSaphyraModVariables.SavedDataSyncMessage.class,
         MokelsBossfightSaphyraModVariables.SavedDataSyncMessage::buffer,
         MokelsBossfightSaphyraModVariables.SavedDataSyncMessage::new,
         MokelsBossfightSaphyraModVariables.SavedDataSyncMessage::handler
      );
      MokelsBossfightSaphyraMod.addNetworkMessage(
         MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage.class,
         MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage::buffer,
         MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage::new,
         MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage::handler
      );
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(MokelsBossfightSaphyraModVariables.PlayerVariables.class);
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((MokelsBossfightSaphyraModVariables.PlayerVariables)event.getEntity()
                  .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerRespawnEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((MokelsBossfightSaphyraModVariables.PlayerVariables)event.getEntity()
                  .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((MokelsBossfightSaphyraModVariables.PlayerVariables)event.getEntity()
                  .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void clonePlayer(Clone event) {
         event.getOriginal().revive();
         MokelsBossfightSaphyraModVariables.PlayerVariables original = (MokelsBossfightSaphyraModVariables.PlayerVariables)event.getOriginal()
            .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables());
         MokelsBossfightSaphyraModVariables.PlayerVariables clone = (MokelsBossfightSaphyraModVariables.PlayerVariables)event.getEntity()
            .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables());
         clone.Dash = original.Dash;
         clone.Rotting = original.Rotting;
         clone.Grief = original.Grief;
         clone.Manic = original.Manic;
         clone.Xplayer = original.Xplayer;
         clone.Zplayer = original.Zplayer;
         clone.Devotion = original.Devotion;
         if (!event.isWasDeath()) {
         }
      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData mapdata = MokelsBossfightSaphyraModVariables.MapVariables.get(event.getEntity().level());
            SavedData worlddata = MokelsBossfightSaphyraModVariables.WorldVariables.get(event.getEntity().level());
            if (mapdata != null) {
               MokelsBossfightSaphyraMod.PACKET_HANDLER
                  .send(
                     PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()),
                     new MokelsBossfightSaphyraModVariables.SavedDataSyncMessage(0, mapdata)
                  );
            }

            if (worlddata != null) {
               MokelsBossfightSaphyraMod.PACKET_HANDLER
                  .send(
                     PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()),
                     new MokelsBossfightSaphyraModVariables.SavedDataSyncMessage(1, worlddata)
                  );
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData worlddata = MokelsBossfightSaphyraModVariables.WorldVariables.get(event.getEntity().level());
            if (worlddata != null) {
               MokelsBossfightSaphyraMod.PACKET_HANDLER
                  .send(
                     PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()),
                     new MokelsBossfightSaphyraModVariables.SavedDataSyncMessage(1, worlddata)
                  );
            }
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "mokels_bossfight_saphyra_mapvars";
      static MokelsBossfightSaphyraModVariables.MapVariables clientSide = new MokelsBossfightSaphyraModVariables.MapVariables();

      public static MokelsBossfightSaphyraModVariables.MapVariables load(CompoundTag tag) {
         MokelsBossfightSaphyraModVariables.MapVariables data = new MokelsBossfightSaphyraModVariables.MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag save(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level && !world.isClientSide()) {
            MokelsBossfightSaphyraMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new MokelsBossfightSaphyraModVariables.SavedDataSyncMessage(0, this));
         }
      }

      public static MokelsBossfightSaphyraModVariables.MapVariables get(LevelAccessor world) {
         return world instanceof ServerLevelAccessor serverLevelAcc
            ? (MokelsBossfightSaphyraModVariables.MapVariables)serverLevelAcc.getLevel()
               .getServer()
               .getLevel(Level.OVERWORLD)
               .getDataStorage()
               .computeIfAbsent(e -> load(e), MokelsBossfightSaphyraModVariables.MapVariables::new, "mokels_bossfight_saphyra_mapvars")
            : clientSide;
      }
   }

   public static class PlayerVariables {
      public double Dash = 0.0;
      public double Rotting = 0.0;
      public double Grief = 0.0;
      public double Manic = 0.0;
      public double Xplayer = 0.0;
      public double Zplayer = 0.0;
      public double Devotion = 0.0;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            MokelsBossfightSaphyraMod.PACKET_HANDLER
               .send(PacketDistributor.PLAYER.with(() -> serverPlayer), new MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage(this));
         }
      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.putDouble("Dash", this.Dash);
         nbt.putDouble("Rotting", this.Rotting);
         nbt.putDouble("Grief", this.Grief);
         nbt.putDouble("Manic", this.Manic);
         nbt.putDouble("Xplayer", this.Xplayer);
         nbt.putDouble("Zplayer", this.Zplayer);
         nbt.putDouble("Devotion", this.Devotion);
         return nbt;
      }

      public void readNBT(Tag tag) {
         CompoundTag nbt = (CompoundTag)tag;
         this.Dash = nbt.getDouble("Dash");
         this.Rotting = nbt.getDouble("Rotting");
         this.Grief = nbt.getDouble("Grief");
         this.Manic = nbt.getDouble("Manic");
         this.Xplayer = nbt.getDouble("Xplayer");
         this.Zplayer = nbt.getDouble("Zplayer");
         this.Devotion = nbt.getDouble("Devotion");
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final MokelsBossfightSaphyraModVariables.PlayerVariables playerVariables = new MokelsBossfightSaphyraModVariables.PlayerVariables();
      private final LazyOptional<MokelsBossfightSaphyraModVariables.PlayerVariables> instance = LazyOptional.of(() -> this.playerVariables);

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(
               new ResourceLocation("mokels_bossfight_saphyra", "player_variables"), new MokelsBossfightSaphyraModVariables.PlayerVariablesProvider()
            );
         }
      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final MokelsBossfightSaphyraModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new MokelsBossfightSaphyraModVariables.PlayerVariables();
         this.data.readNBT(buffer.readNbt());
      }

      public PlayerVariablesSyncMessage(MokelsBossfightSaphyraModVariables.PlayerVariables data) {
         this.data = data;
      }

      public static void buffer(MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeNbt((CompoundTag)message.data.writeNBT());
      }

      public static void handler(MokelsBossfightSaphyraModVariables.PlayerVariablesSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(
            () -> {
               if (!context.getDirection().getReceptionSide().isServer()) {
                  MokelsBossfightSaphyraModVariables.PlayerVariables variables = (MokelsBossfightSaphyraModVariables.PlayerVariables)Minecraft.getInstance()
                     .player
                     .getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables());
                  variables.Dash = message.data.Dash;
                  variables.Rotting = message.data.Rotting;
                  variables.Grief = message.data.Grief;
                  variables.Manic = message.data.Manic;
                  variables.Xplayer = message.data.Xplayer;
                  variables.Zplayer = message.data.Zplayer;
                  variables.Devotion = message.data.Devotion;
               }
            }
         );
         context.setPacketHandled(true);
      }
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.readNbt();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0
               ? new MokelsBossfightSaphyraModVariables.MapVariables()
               : new MokelsBossfightSaphyraModVariables.WorldVariables());
            if (this.data instanceof MokelsBossfightSaphyraModVariables.MapVariables mapVariables) {
               mapVariables.read(nbt);
            } else if (this.data instanceof MokelsBossfightSaphyraModVariables.WorldVariables worldVariables) {
               worldVariables.read(nbt);
            }
         }
      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(MokelsBossfightSaphyraModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.writeNbt(message.data.save(new CompoundTag()));
         }
      }

      public static void handler(MokelsBossfightSaphyraModVariables.SavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  MokelsBossfightSaphyraModVariables.MapVariables.clientSide = (MokelsBossfightSaphyraModVariables.MapVariables)message.data;
               } else {
                  MokelsBossfightSaphyraModVariables.WorldVariables.clientSide = (MokelsBossfightSaphyraModVariables.WorldVariables)message.data;
               }
            }
         });
         context.setPacketHandled(true);
      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "mokels_bossfight_saphyra_worldvars";
      public double Playerfacing = 1.0;
      public double playerjoinedworld = 0.0;
      static MokelsBossfightSaphyraModVariables.WorldVariables clientSide = new MokelsBossfightSaphyraModVariables.WorldVariables();

      public static MokelsBossfightSaphyraModVariables.WorldVariables load(CompoundTag tag) {
         MokelsBossfightSaphyraModVariables.WorldVariables data = new MokelsBossfightSaphyraModVariables.WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         this.Playerfacing = nbt.getDouble("Playerfacing");
         this.playerjoinedworld = nbt.getDouble("playerjoinedworld");
      }

      public CompoundTag save(CompoundTag nbt) {
         nbt.putDouble("Playerfacing", this.Playerfacing);
         nbt.putDouble("playerjoinedworld", this.playerjoinedworld);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level level && !level.isClientSide()) {
            MokelsBossfightSaphyraMod.PACKET_HANDLER
               .send(PacketDistributor.DIMENSION.with(level::dimension), new MokelsBossfightSaphyraModVariables.SavedDataSyncMessage(1, this));
         }
      }

      public static MokelsBossfightSaphyraModVariables.WorldVariables get(LevelAccessor world) {
         return world instanceof ServerLevel level
            ? (MokelsBossfightSaphyraModVariables.WorldVariables)level.getDataStorage()
               .computeIfAbsent(e -> load(e), MokelsBossfightSaphyraModVariables.WorldVariables::new, "mokels_bossfight_saphyra_worldvars")
            : clientSide;
      }
   }
}

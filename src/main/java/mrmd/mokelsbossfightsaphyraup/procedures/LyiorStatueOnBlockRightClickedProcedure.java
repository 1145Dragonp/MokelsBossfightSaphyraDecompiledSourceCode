package mrmd.mokelsbossfightsaphyraup.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LyiorStatueOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp = BlockPos.containing(x, y, z);
      BlockState _bs = ((Block)MokelsBossfightSaphyraModBlocks.LYIOR_STATUE_AKTIVATED.get()).defaultBlockState();
      BlockState _bso = world.getBlockState(_bp);
      UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

      while (var10.hasNext()) {
         Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
         Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
         if (_property != null && _bs.getValue(_property) != null) {
            try {
               _bs = (BlockState)_bs.setValue((Property) _property, (Comparable) entry.getValue());
            } catch (Exception var14) {
            }
         }
      }

      world.setBlock(_bp, _bs, 3);
      if (world instanceof ServerLevel _level) {
         _level.getServer()
            .getCommands()
            .performPrefixedCommand(
               new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                  .withSuppressedOutput(),
               "/title @a times 20 40 20"
            );
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer()
            .getCommands()
            .performPrefixedCommand(
               new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                  .withSuppressedOutput(),
               "/title @a title {\"text\":\"lost spirit marked\",\"color\":\"aqua\"}"
            );
      }

      if (world instanceof Level _level) {
         if (!_level.isClientSide()) {
            _level.playSound(
               null,
               BlockPos.containing(x, y, z),
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:lyiorsoundstatue")),
               SoundSource.BLOCKS,
               1.0F,
               1.0F
            );
         } else {
            _level.playLocalSound(
               x,
               y,
               z,
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:lyiorsoundstatue")),
               SoundSource.BLOCKS,
               1.0F,
               1.0F,
               false
            );
         }
      }
   }
}

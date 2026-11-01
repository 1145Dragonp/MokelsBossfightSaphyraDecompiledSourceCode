package mrmd.mokelsbossfightsaphyraup.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import mrmd.mokelsbossfightsaphyraup.MokelsBossfightSaphyraMod;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class OddmentOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      int _value = 1;
      BlockPos _pos = BlockPos.containing(x, y, z);
      BlockState _bs = world.getBlockState(_pos);
      if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value)) {
         world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
      }

      MokelsBossfightSaphyraMod.queueServerWork(160, () -> {
         BlockPos _bp = BlockPos.containing(x, y, z);
         BlockState _bsx = ((Block)MokelsBossfightSaphyraModBlocks.ODDMENT_STAGE_2.get()).defaultBlockState();
         BlockState _bso = world.getBlockState(_bp);
         UnmodifiableIterator var10x = _bso.getValues().entrySet().iterator();

         while (var10x.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10x.next();
            Property _property = _bsx.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            if (_property != null && _bsx.getValue(_property) != null) {
               try {
                  _bsx = (BlockState)_bsx.setValue((Property) _property, (Comparable) entry.getValue());
               } catch (Exception var14) {
               }
            }
         }

         world.setBlock(_bp, _bsx, 3);
      });
   }
}

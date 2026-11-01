package mrmd.mokelsbossfightsaphyraup.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class DarkPolishedBloodStairsBlock extends StairBlock {
   public DarkPolishedBloodStairsBlock() {
      super(
         () -> Blocks.AIR.defaultBlockState(),
         Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.DEEPSLATE_BRICKS)
            .strength(-1.0F, 3600000.0F)
            .pushReaction(PushReaction.IGNORE)
      );
   }

   public float getExplosionResistance() {
      return 1000.0F;
   }

   public boolean isRandomlyTicking(BlockState state) {
      return false;
   }
}

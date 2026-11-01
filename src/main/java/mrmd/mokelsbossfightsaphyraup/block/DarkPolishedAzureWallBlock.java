package mrmd.mokelsbossfightsaphyraup.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class DarkPolishedAzureWallBlock extends WallBlock {
   public DarkPolishedAzureWallBlock() {
      super(
         Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.DEEPSLATE_BRICKS)
            .strength(-1.0F, 3600000.0F)
            .pushReaction(PushReaction.IGNORE)
            .forceSolidOn()
      );
   }
}

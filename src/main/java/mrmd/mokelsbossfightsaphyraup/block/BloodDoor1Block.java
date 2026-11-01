package mrmd.mokelsbossfightsaphyraup.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class BloodDoor1Block extends DoorBlock {
   public BloodDoor1Block() {
      super(
         Properties.of()
            .ignitedByLava()
            .instrument(NoteBlockInstrument.BASS)
            .sound(SoundType.DEEPSLATE_BRICKS)
            .strength(-1.0F, 3600000.0F)
            .pushReaction(PushReaction.IGNORE),
         BlockSetType.OAK
      );
   }
}

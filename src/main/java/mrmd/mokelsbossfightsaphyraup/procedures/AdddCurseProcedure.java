package mrmd.mokelsbossfightsaphyraup.procedures;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModItems;
import mrmd.mokelsbossfightsaphyraup.network.MokelsBossfightSaphyraModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AdddCurseProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (MokelsBossfightSaphyraModItems.ADD_CURSE.get() == itemstack.getItem()) {
            if (entity.isShiftKeyDown()) {
               double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                           MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                        )
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Rotting
                  + 10.0;
               entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.Rotting = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }
            } else if (!entity.isShiftKeyDown()) {
               double _setval = ((MokelsBossfightSaphyraModVariables.PlayerVariables)entity.getCapability(
                           MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null
                        )
                        .orElse(new MokelsBossfightSaphyraModVariables.PlayerVariables()))
                     .Grief
                  + 10.0;
               entity.getCapability(MokelsBossfightSaphyraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.Grief = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelx.playLocalSound(
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mokels_bossfight_saphyra:rule_spell")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }
            }
         }
      }
   }
}

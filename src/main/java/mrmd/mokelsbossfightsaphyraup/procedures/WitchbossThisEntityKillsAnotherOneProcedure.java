package mrmd.mokelsbossfightsaphyraup.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WitchbossThisEntityKillsAnotherOneProcedure {
   public static void execute(LevelAccessor world, Entity sourceentity) {
      if (sourceentity != null) {
         if ((sourceentity instanceof ServerPlayer || sourceentity instanceof Player) && world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "/stopsound @a music"
               );
         }
      }
   }
}

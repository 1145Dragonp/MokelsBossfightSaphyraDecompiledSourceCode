package mrmd.mokelsbossfightsaphyraup.configuration;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class StaminaBarConfiguration {
   public static final Builder BUILDER = new Builder();
   public static final ConfigValue<Boolean> STAMINABAR = BUILDER.comment("Stamina Bar Config").define("Enable Stamina Bar", true);
   public static final ForgeConfigSpec SPEC = BUILDER.build();

   static {
      BUILDER.push("Stamina Bar Config");
      BUILDER.pop();
   }
}

package mrmd.mokelsbossfightsaphyraup.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MokelsBossfightSaphyraModPaintings {
   public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, "mokels_bossfight_saphyra");
   public static final RegistryObject<PaintingVariant> SAPHYRA_BY_ALLAN_72A = REGISTRY.register("saphyra_by_allan_72a", () -> new PaintingVariant(64, 32));
}

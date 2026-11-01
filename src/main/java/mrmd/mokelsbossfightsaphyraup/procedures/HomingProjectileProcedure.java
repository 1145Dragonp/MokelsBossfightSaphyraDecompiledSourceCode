package mrmd.mokelsbossfightsaphyraup.procedures;

import java.util.Comparator;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HomingProjectileProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().putDouble("Despawn", immediatesourceentity.getPersistentData().getDouble("Despawn") + 1.0);
         if (!immediatesourceentity.getPersistentData().getBoolean("Grav")) {
            immediatesourceentity.getPersistentData().putBoolean("Grav", true);
            immediatesourceentity.setNoGravity(true);
         }

         if (immediatesourceentity.getPersistentData().getDouble("Despawn") == 80.0) {
            immediatesourceentity.setNoGravity(false);
         }

         if (immediatesourceentity.getPersistentData().getDouble("Despawn") == 200.0 && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         if (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null) != null
            && world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null) != entity
            && immediatesourceentity.getPersistentData().getDouble("Home") < 25.0) {
            immediatesourceentity.getPersistentData().putDouble("Home", immediatesourceentity.getPersistentData().getDouble("Home") + 1.0);
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getLookAngle().x
                     + (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - immediatesourceentity.getX()) * 0.075,
                  immediatesourceentity.getLookAngle().y
                     + (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY() - immediatesourceentity.getY()) * 0.075,
                  immediatesourceentity.getLookAngle().z
                     + (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - immediatesourceentity.getZ()) * 0.075
               )
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFIRE_PARTICLE.get(), x, y, z, 1, 0.05, 0.05, 0.05, 0.01);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)MokelsBossfightSaphyraModParticleTypes.REDFLAME_PARTICLE.get(), x, y, z, 2, 0.05, 0.05, 0.05, 0.01);
         }
      }
   }
}

package mrmd.mokelsbossfightsaphyraup.entity;

import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModEntities;
import mrmd.mokelsbossfightsaphyraup.procedures.MirrorBladeProjectileProjectileHitsBlockProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.MirrorBladeProjectileWhileProjectileFlyingTickProcedure;
import mrmd.mokelsbossfightsaphyraup.procedures.WitchBossProjectileProjectileHitsLivingEntityProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class MirrorBladeProjectileEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

   public MirrorBladeProjectileEntity(SpawnEntity packet, Level world) {
      super((EntityType)MokelsBossfightSaphyraModEntities.MIRROR_BLADE_PROJECTILE.get(), world);
   }

   public MirrorBladeProjectileEntity(EntityType<? extends MirrorBladeProjectileEntity> type, Level world) {
      super(type, world);
   }

   public MirrorBladeProjectileEntity(EntityType<? extends MirrorBladeProjectileEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public MirrorBladeProjectileEntity(EntityType<? extends MirrorBladeProjectileEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   public void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      WitchBossProjectileProjectileHitsLivingEntityProcedure.execute(this.level(), this);
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      MirrorBladeProjectileProjectileHitsBlockProcedure.execute(this);
   }

   public void tick() {
      super.tick();
      MirrorBladeProjectileWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (this.inGround) {
         this.discard();
      }
   }

   public static MirrorBladeProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 5.0, 1);
   }

   public static MirrorBladeProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 1.0F, 5.0, 1);
   }

   public static MirrorBladeProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      MirrorBladeProjectileEntity entityarrow = new MirrorBladeProjectileEntity(
         (EntityType<? extends MirrorBladeProjectileEntity>)MokelsBossfightSaphyraModEntities.MIRROR_BLADE_PROJECTILE.get(), entity, world
      );
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static MirrorBladeProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
      MirrorBladeProjectileEntity entityarrow = new MirrorBladeProjectileEntity(
         (EntityType<? extends MirrorBladeProjectileEntity>)MokelsBossfightSaphyraModEntities.MIRROR_BLADE_PROJECTILE.get(), entity, entity.level()
      );
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(5.0);
      entityarrow.setKnockback(1);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      return entityarrow;
   }
}

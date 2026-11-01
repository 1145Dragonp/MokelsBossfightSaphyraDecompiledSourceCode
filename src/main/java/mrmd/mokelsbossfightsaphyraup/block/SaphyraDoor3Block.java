package mrmd.mokelsbossfightsaphyraup.block;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlockEntities;
import mrmd.mokelsbossfightsaphyraup.init.MokelsBossfightSaphyraModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SaphyraDoor3Block extends BaseEntityBlock implements SimpleWaterloggedBlock, EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
   public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

   public SaphyraDoor3Block() {
      super(
         Properties.of()
            .sound(SoundType.METAL)
            .strength(-1.0F, 3600000.0F)
            .noOcclusion()
            .pushReaction(PushReaction.IGNORE)
            .isRedstoneConductor((bs, br, bp) -> false)
      );
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED, false));
   }

   public RenderShape getRenderShape(BlockState state) {
      return RenderShape.ENTITYBLOCK_ANIMATED;
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
      return ((BlockEntityType)MokelsBossfightSaphyraModBlockEntities.SAPHYRA_DOOR_3.get()).create(blockPos, blockState);
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return state.getFluidState().isEmpty();
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return switch ((Direction)state.getValue(FACING)) {
         case NORTH -> Shapes.or(
         box(28.0, 0.0, 4.0, 33.0, 16.0, 10.0),
         new VoxelShape[]{
            box(-17.0, 0.0, 4.0, -12.0, 16.0, 10.0),
            box(28.0, 16.0, 4.0, 33.0, 32.0, 10.0),
            box(-17.0, 16.0, 4.0, -12.0, 32.0, 10.0),
            box(28.0, 32.0, 4.0, 33.0, 48.0, 10.0),
            box(-17.0, 32.0, 4.0, -12.0, 48.0, 10.0),
            box(28.0, 48.0, 4.0, 33.0, 64.0, 10.0),
            box(-17.0, 48.0, 4.0, -12.0, 64.0, 10.0)
         }
      );
         case EAST -> Shapes.or(
         box(6.0, 0.0, 28.0, 12.0, 16.0, 33.0),
         new VoxelShape[]{
            box(6.0, 0.0, -17.0, 12.0, 16.0, -12.0),
            box(6.0, 16.0, 28.0, 12.0, 32.0, 33.0),
            box(6.0, 16.0, -17.0, 12.0, 32.0, -12.0),
            box(6.0, 32.0, 28.0, 12.0, 48.0, 33.0),
            box(6.0, 32.0, -17.0, 12.0, 48.0, -12.0),
            box(6.0, 48.0, 28.0, 12.0, 64.0, 33.0),
            box(6.0, 48.0, -17.0, 12.0, 64.0, -12.0)
         }
      );
         case WEST -> Shapes.or(
         box(4.0, 0.0, -17.0, 10.0, 16.0, -12.0),
         new VoxelShape[]{
            box(4.0, 0.0, 28.0, 10.0, 16.0, 33.0),
            box(4.0, 16.0, -17.0, 10.0, 32.0, -12.0),
            box(4.0, 16.0, 28.0, 10.0, 32.0, 33.0),
            box(4.0, 32.0, -17.0, 10.0, 48.0, -12.0),
            box(4.0, 32.0, 28.0, 10.0, 48.0, 33.0),
            box(4.0, 48.0, -17.0, 10.0, 64.0, -12.0),
            box(4.0, 48.0, 28.0, 10.0, 64.0, 33.0)
         }
      );
         default -> Shapes.or(
         box(-17.0, 0.0, 6.0, -12.0, 16.0, 12.0),
         new VoxelShape[]{
            box(28.0, 0.0, 6.0, 33.0, 16.0, 12.0),
            box(-17.0, 16.0, 6.0, -12.0, 32.0, 12.0),
            box(28.0, 16.0, 6.0, 33.0, 32.0, 12.0),
            box(-17.0, 32.0, 6.0, -12.0, 48.0, 12.0),
            box(28.0, 32.0, 6.0, 33.0, 48.0, 12.0),
            box(-17.0, 48.0, 6.0, -12.0, 64.0, 12.0),
            box(28.0, 48.0, 6.0, 33.0, 64.0, 12.0)
         }
      );
      };
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(new Property[]{ANIMATION, FACING, WATERLOGGED});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
      return (BlockState)((BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())).setValue(WATERLOGGED, flag);
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public FluidState getFluidState(BlockState state) {
      return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
   }

   public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
      if ((Boolean)state.getValue(WATERLOGGED)) {
         world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
      }

      return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
   }

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack((ItemLike)MokelsBossfightSaphyraModBlocks.BOSS_DOOR_1.get());
   }

   public List<ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.getDrops(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
   }
}

package mcmodder.nutritiousfeast.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class JarBlock extends Block {
    public JarBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(4, 0, 4, 12, 11, 12),
            Block.createCuboidShape(5, 11, 5, 11, 12, 11),
            BooleanBiFunction.OR
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.offset(Direction.DOWN), Direction.DOWN.getOpposite());
    }
}

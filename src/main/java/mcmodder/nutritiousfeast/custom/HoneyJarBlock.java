package mcmodder.nutritiousfeast.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import mcmodder.nutritiousfeast.block.ModBlocks;

public class HoneyJarBlock extends JarBlock {
    public static final int MAX_TIMES_EATEN = 4;
    public static final IntProperty TIMES_EATEN = IntProperty.of("times_eaten", 0, 4);

    public HoneyJarBlock(Settings settings) {
        super(settings);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIMES_EATEN);
    }

    /*public BlockState getPlacementState(ItemPlacementContext ctx) {
        ItemStack stack = ctx.getStack();
        if (stack.hasNbt()) {
            NbtCompound tag = stack.getNbt();
            if (stack.hasNbt() && stack.getNbt().contains("times_eaten", NbtType.INT)) {
                int timesEaten = tag.getInt("times_eaten");
                return this.getDefaultState().with(TIMES_EATEN, timesEaten);
            }
        }
        return this.getDefaultState();
    }*/

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //if (!player.canConsume(false)) {return ActionResult.PASS;}
        if (!world.isClient) {
            player.removeStatusEffect(StatusEffects.POISON);
            world.playSound(null, pos, SoundEvents.BLOCK_HONEY_BLOCK_BREAK, SoundCategory.AMBIENT, 1f, 1f);
        }
        player.getHungerManager().add(6, 1.2f);
        int i = state.get(TIMES_EATEN);
        world.emitGameEvent((Entity)player, GameEvent.EAT, pos);
        if (i < 4) {
            world.setBlockState(pos, (BlockState)state.with(TIMES_EATEN, i + 1), Block.NOTIFY_ALL);
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_DESTROY, pos);
            world.setBlockState(pos, ModBlocks.EMPTY_JAR.getDefaultState());
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_PLACE, pos);
        }
        return ActionResult.SUCCESS;
    }
}

package net.exotreus.finaltutorial.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VolatiteLampBlock extends Block {
    public static final BooleanProperty ENABLED = BooleanProperty.of("enabled");

    public VolatiteLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(ENABLED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockState newState = state.cycle(ENABLED);
            world.setBlockState(pos, newState);

            if (newState.get(ENABLED)) {
                world.playSound(null, pos, SoundEvents.BLOCK_COPPER_BULB_TURN_ON, SoundCategory.BLOCKS, 1f, 1f);
            } else {
                world.playSound(null, pos, SoundEvents.BLOCK_COPPER_BULB_TURN_OFF, SoundCategory.BLOCKS, 1f, 1f);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }
}

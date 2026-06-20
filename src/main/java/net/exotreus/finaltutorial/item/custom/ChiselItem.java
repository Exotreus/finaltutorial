package net.exotreus.finaltutorial.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ChiselItem extends Item {

    private static final List<List<Block>> CHISEL_CYCLES = List.of(
            // stone
            List.of(Blocks.STONE, Blocks.SMOOTH_STONE, Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
            List.of(Blocks.STONE_STAIRS, Blocks.STONE_BRICK_STAIRS),
            List.of(Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.STONE_BRICK_SLAB),

            // sandstone
            List.of(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.CUT_SANDSTONE),
            List.of(Blocks.SANDSTONE_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE_SLAB),
            List.of(Blocks.SANDSTONE_STAIRS, Blocks.SMOOTH_SANDSTONE_STAIRS),

            // red sandstone
            List.of(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE),
            List.of(Blocks.RED_SANDSTONE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE_SLAB),
            List.of(Blocks.RED_SANDSTONE_STAIRS, Blocks.SMOOTH_RED_SANDSTONE_STAIRS),

            // end stone
            List.of(Blocks.END_STONE, Blocks.END_STONE_BRICKS),

            // tuff
            List.of(Blocks.TUFF, Blocks.CHISELED_TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS),
            List.of(Blocks.TUFF_SLAB, Blocks.POLISHED_TUFF_SLAB, Blocks.TUFF_BRICK_SLAB),
            List.of(Blocks.TUFF_STAIRS, Blocks.POLISHED_TUFF_STAIRS, Blocks.TUFF_BRICK_STAIRS),
            List.of(Blocks.TUFF_WALL, Blocks.POLISHED_TUFF_WALL, Blocks.TUFF_BRICK_WALL),

            // resin (ADD LATER)
//            List.of(Blocks.RESIN_BLOCK, Blocks.RESIN_BRICKS, Blocks.CHISELED_RESIN_BRICKS),

            // blackstone
            List.of(Blocks.POLISHED_BLACKSTONE, Blocks.CHISELED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
            List.of(Blocks.BLACKSTONE_STAIRS, Blocks.POLISHED_BLACKSTONE_STAIRS, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS),
            List.of(Blocks.BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB),
            List.of(Blocks.BLACKSTONE_WALL, Blocks.POLISHED_BLACKSTONE_WALL, Blocks.POLISHED_BLACKSTONE_BRICK_WALL),

            // prismarine
            List.of(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
            List.of(Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_BRICK_STAIRS),
            List.of(Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_BRICK_SLAB),

            // mud
            List.of(Blocks.PACKED_MUD, Blocks.MUD_BRICKS),

            // deepslate
            List.of(Blocks.DEEPSLATE, Blocks.CHISELED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES),
            List.of(Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_TILE_STAIRS),
            List.of(Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_TILE_SLAB),
            List.of(Blocks.POLISHED_DEEPSLATE_WALL, Blocks.DEEPSLATE_BRICK_WALL, Blocks.DEEPSLATE_TILE_WALL),

            // nether bricks
            List.of(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS),

            // quartz
            List.of(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_PILLAR, Blocks.SMOOTH_QUARTZ),
            List.of(Blocks.QUARTZ_STAIRS, Blocks.SMOOTH_QUARTZ_STAIRS),
            List.of(Blocks.QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ_SLAB),

            // copper
            List.of(Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER, Blocks.CUT_COPPER),
            List.of(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CHISELED_COPPER, Blocks.EXPOSED_CUT_COPPER),
            List.of(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CHISELED_COPPER, Blocks.WEATHERED_CUT_COPPER),
            List.of(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER, Blocks.OXIDIZED_CUT_COPPER),
            List.of(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CHISELED_COPPER, Blocks.WAXED_CUT_COPPER),
            List.of(Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER),
            List.of(Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER),
            List.of(Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER),

            // granite
            List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
            List.of(Blocks.GRANITE_SLAB, Blocks.POLISHED_GRANITE_SLAB),
            List.of(Blocks.GRANITE_STAIRS, Blocks.POLISHED_GRANITE_STAIRS),

            // diorite
            List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
            List.of(Blocks.DIORITE_SLAB, Blocks.POLISHED_DIORITE_SLAB),
            List.of(Blocks.DIORITE_STAIRS, Blocks.POLISHED_DIORITE_STAIRS),

            // andesite
            List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE),
            List.of(Blocks.ANDESITE_SLAB, Blocks.POLISHED_ANDESITE_SLAB),
            List.of(Blocks.ANDESITE_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS)
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState oldState = world.getBlockState(pos);
        Block clickedBlock = oldState.getBlock();

        for (List<Block> cycle : CHISEL_CYCLES) {
            if (cycle.contains(clickedBlock)) {

                if (world instanceof ServerWorld serverWorld) {
                    int currentIndex = cycle.indexOf(clickedBlock);
                    int nextIndex = (currentIndex + 1) % cycle.size();
                    Block nextBlock = cycle.get(nextIndex);

                    BlockState newState = nextBlock.getDefaultState();
                    newState = copyBlockStateProperties(oldState, newState);

                    world.setBlockState(pos, newState);

                    net.minecraft.sound.BlockSoundGroup soundGroup = newState.getSoundGroup();
                    world.playSound(null, pos,
                            soundGroup.getPlaceSound(),
                            SoundCategory.BLOCKS,
                            1.0F, 1.0F);
                    world.playSound(null, pos,
                            SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                            SoundCategory.PLAYERS,
                            0.75F, 1.5f);

                    Vec3d hitPos = context.getHitPos();

                    BlockStateParticleEffect particleEffect =
                            new BlockStateParticleEffect(ParticleTypes.BLOCK, oldState);

                    serverWorld.spawnParticles(
                            particleEffect,
                            hitPos.getX(), hitPos.getY(), hitPos.getZ(),
                            5,
                            0.1, 0.1, 0.1,
                            0.05
                    );

                    EquipmentSlot activeSlot = context.getHand() == Hand.MAIN_HAND
                            ? EquipmentSlot.MAINHAND
                            : EquipmentSlot.OFFHAND;

                    if (context.getPlayer() instanceof ServerPlayerEntity serverPlayer) {
                        context.getStack().damage(1, serverWorld, serverPlayer,
                                item -> serverPlayer.sendEquipmentBreakStatus(item, activeSlot));
                    }
                }

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private BlockState copyBlockStateProperties(BlockState oldState, BlockState newState) {
        for (Property property : oldState.getProperties()) {
            if (newState.contains(property)) {
                newState = newState.with(property, oldState.get(property));
            }
        }
        return newState;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient() && miner instanceof ServerPlayerEntity player) {
            EquipmentSlot activeSlot = player.getActiveHand() == Hand.MAIN_HAND
                    ? EquipmentSlot.MAINHAND
                    : EquipmentSlot.OFFHAND;

            stack.damage(2, (ServerWorld) world, player,
                    item -> player.sendEquipmentBreakStatus(item, activeSlot));
        }

        return true;
    }
}
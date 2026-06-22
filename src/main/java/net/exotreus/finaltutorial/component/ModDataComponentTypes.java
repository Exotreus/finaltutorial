package net.exotreus.finaltutorial.component;

import com.mojang.serialization.Codec;
import net.exotreus.finaltutorial.FinalTutorial;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES =
            register("coordinates", builder -> builder.codec(BlockPos.CODEC));

    public static final ComponentType<Integer> GROUP_DAMAGE =
            register("group_damage", builder -> builder.codec(Codec.INT));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(FinalTutorial.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        FinalTutorial.LOGGER.info("Registering Mod Component Types for " + FinalTutorial.MOD_ID);
    }
}

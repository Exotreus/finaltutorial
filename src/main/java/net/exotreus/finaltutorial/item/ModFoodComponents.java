package net.exotreus.finaltutorial.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent GUARDIAN_HEART = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400, 0), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.5F)
            .build();
}
package mcmodder.nutritiousfeast.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent BLUEBERRY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent CHOCOLATE_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent CARROT_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent GLOW_BERRY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 140, 0), 1f).build();
    public static final FoodComponent ILLUMINATING_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 340, 0), 1f).build();
    public static final FoodComponent CHORUS_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).alwaysEdible().build();
    public static final FoodComponent HONEY_BREAD = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f).build();
    public static final FoodComponent HONEY_COOKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent POTATO_SOUP = new FoodComponent.Builder().nutrition(6).saturationModifier(0.72f).build();
    public static final FoodComponent FUNGUS_STEW = new FoodComponent.Builder().nutrition(6).saturationModifier(0.72f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 240, 0), 1f).build();
    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).build();
}

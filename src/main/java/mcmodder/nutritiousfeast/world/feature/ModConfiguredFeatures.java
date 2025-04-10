package mcmodder.nutritiousfeast.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import mcmodder.nutritiousfeast.NutritiousFeast;
import mcmodder.nutritiousfeast.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> ILLUMINATING_FLOWER = registerKey("illuminating_flower");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUEBERRY_BUSH = registerKey("blueberry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, ILLUMINATING_FLOWER, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ILLUMINATING_FLOWER)))));
        register(context, BLUEBERRY_BUSH, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(10, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(Properties.AGE_3, 3))))));
    }

        public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(NutritiousFeast.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}

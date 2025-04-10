package mcmodder.nutritiousfeast.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import mcmodder.nutritiousfeast.NutritiousFeast;
import mcmodder.nutritiousfeast.custom.*;

public class ModBlocks {

    public static final Block ILLUMINATING_FLOWER = registerBlock("illuminating_flower",
            new FlowerBlock(StatusEffects.GLOWING, 40, FabricBlockSettings.copyOf(Blocks.DANDELION).noCollision().emissiveLighting((state, world, pos) -> true).breakInstantly().sounds(BlockSoundGroup.GRASS)), "NATURAL");
    public static final Block POTTED_ILLUMINATING_FLOWER = registerBlockWithoutItem("potted_illuminating_flower",
            new FlowerPotBlock(ModBlocks.ILLUMINATING_FLOWER, FabricBlockSettings.copy(Blocks.POTTED_DANDELION)));

    public static final Block EMPTY_JAR = registerBlock("empty_jar",
            new JarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), "BUILDING_BLOCKS");
    public static final Block HONEY_JAR = registerBlock("honey_jar",
            new HoneyJarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), "FOOD_AND_DRINK");
    public static final Block COOKIE_JAR = registerBlock("cookie_jar",
            new CookieJarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), "FOOD_AND_DRINK");
    public static final Block SWEET_BERRY_JAM_JAR = registerBlock("sweet_berry_jam_jar",
            new SweetBerryJamJarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), "FOOD_AND_DRINK");
    public static final Block BLUEBERRY_JAM_JAR = registerBlock("blueberry_jam_jar",
            new BlueberryJamJarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), "FOOD_AND_DRINK");
    public static final Block BLUEBERRY_BUSH = registerBlockWithoutItem("blueberry_bush",
            new BlueberryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH).noCollision().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(NutritiousFeast.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, String groupType) {
        registerBlockItem(name, block, groupType);
        return Registry.register(Registries.BLOCK, new Identifier(NutritiousFeast.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, String groupType) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NutritiousFeast.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
        if (groupType == "FOOD_AND_DRINK") {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
                entries.add(item);
            });
        } else if (groupType == "BUILDING_BLOCKS") {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
                entries.add(item);
        });
        } else if (groupType == "NATURAL") {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                entries.add(item);
            });
        }
        return item;
    }

    public static void registerBlocks() {
        NutritiousFeast.LOGGER.info("Registering blocks");
    }
}

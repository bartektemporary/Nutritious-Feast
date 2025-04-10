package mcmodder.nutritiousfeast.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import mcmodder.nutritiousfeast.NutritiousFeast;
import mcmodder.nutritiousfeast.block.ModBlocks;
import mcmodder.nutritiousfeast.custom.ChorusPieItem;

public class ModItems {
    public static final Item APPLE_PIE = registerItem("apple_pie",
            new Item(new Item.Settings().food(ModFoodComponents.APPLE_PIE)));
    public static final Item SWEET_BERRY_PIE = registerItem("sweet_berry_pie",
            new Item(new Item.Settings().food(ModFoodComponents.SWEET_BERRY_PIE)));
    public static final Item BLUEBERRY_PIE = registerItem("blueberry_pie",
            new Item(new Item.Settings().food(ModFoodComponents.BLUEBERRY_PIE)));
    public static final Item CHOCOLATE_PIE = registerItem("chocolate_pie",
            new Item(new Item.Settings().food(ModFoodComponents.CHOCOLATE_PIE)));
    public static final Item CARROT_PIE = registerItem("carrot_pie",
            new Item(new Item.Settings().food(ModFoodComponents.CARROT_PIE)));
    public static final Item GLOW_BERRY_PIE = registerItem("glow_berry_pie",
            new Item(new Item.Settings().food(ModFoodComponents.GLOW_BERRY_PIE)));
    public static final Item ILLUMINATING_PIE = registerItem("illuminating_pie",
            new Item(new Item.Settings().food(ModFoodComponents.ILLUMINATING_PIE)));
    public static final Item CHORUS_PIE = registerItem("chorus_pie",
            new ChorusPieItem(new Item.Settings().food(ModFoodComponents.CHORUS_PIE)));
    public static final Item HONEY_BREAD = registerItem("honey_bread",
            new Item(new Item.Settings().food(ModFoodComponents.HONEY_BREAD)));
    public static final Item HONEY_COOKIE = registerItem("honey_cookie",
            new Item(new Item.Settings().food(ModFoodComponents.HONEY_COOKIE)));
    public static final Item POTATO_SOUP = registerItem("potato_soup",
            new Item(new Item.Settings().food(ModFoodComponents.POTATO_SOUP)));
    public static final Item FUNGUS_STEW = registerItem("fungus_stew",
            new Item(new Item.Settings().food(ModFoodComponents.FUNGUS_STEW)));

    public static final Item ILLUMINATING_SUGAR = registerItem("illuminating_sugar",
            new Item(new Item.Settings()));
    public static final Item BLUEBERRIES = registerItem("blueberries",
            (Item) new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLUEBERRIES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NutritiousFeast.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(APPLE_PIE);
            entries.add(SWEET_BERRY_PIE);
            entries.add(BLUEBERRY_PIE);
            entries.add(CHOCOLATE_PIE);
            entries.add(CARROT_PIE);
            entries.add(GLOW_BERRY_PIE);
            entries.add(ILLUMINATING_PIE);
            entries.add(CHORUS_PIE);
            entries.add(HONEY_BREAD);
            entries.add(HONEY_COOKIE);
            entries.add(POTATO_SOUP);
            entries.add(FUNGUS_STEW);
            entries.add(BLUEBERRIES);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ILLUMINATING_SUGAR);
        });
    }

    public static void registerModItems() {
        NutritiousFeast.LOGGER.info("Registered Mod Items");

        addItemsToItemGroups();
    }

}

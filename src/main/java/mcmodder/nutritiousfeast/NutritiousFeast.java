package mcmodder.nutritiousfeast;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mcmodder.nutritiousfeast.block.ModBlocks;
import mcmodder.nutritiousfeast.item.ModItems;
import mcmodder.nutritiousfeast.world.gen.ModWorldGen;

public class NutritiousFeast implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "nutritious-feast";
	public static final Logger LOGGER = LoggerFactory.getLogger("nutritious-feast");

	@Override
	public void onInitialize() {
		ModWorldGen.generateWorldGen();
		ModItems.registerModItems();
		ModBlocks.registerBlocks();
	}
}
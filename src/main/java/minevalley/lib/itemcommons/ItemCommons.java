package minevalley.lib.itemcommons;

import minevalley.lib.itemcommons.technology.*;
import minevalley.lib.itemcommons.technology.engines.CombustionEngineItem;
import minevalley.lib.itemcommons.technology.engines.CylinderItem;
import minevalley.lib.itemcommons.technology.engines.ElectricMotorItem;
import minevalley.lib.itemcommons.technology.engines.SparkPlugItem;
import minevalley.lib.itemcommons.technology.vehicles.*;

@SuppressWarnings("unused")
public final class ItemCommons {

    /**
     * Initiates all crafting recipes of the ItemCommons module.
     * <p>
     * <b>Note:</b> This method will be called once by the core plugin after all modules have been enabled. You should not call this method yourself.
     */
    public static void initiateCraftingRecipes() {
        initiateTechnologyCraftingRecipes();
    }

    private static void initiateTechnologyCraftingRecipes() {
        initiateEnginesCraftingRecipes();
        initiateVehiclesCraftingRecipes();
        BatteryItem.registerRecipes();
        CopperCoilItem.registerRecipes();
        LightBulbItem.registerRecipe();
        ScrewItem.registerRecipe();
        SteelRodItem.registerRecipe();
        TankItem.registerRecipes();
    }

    private static void initiateEnginesCraftingRecipes() {
        CombustionEngineItem.registerRecipes();
        CylinderItem.registerRecipe();
        ElectricMotorItem.registerRecipes();
        SparkPlugItem.registerRecipe();
    }

    private static void initiateVehiclesCraftingRecipes() {
        AirbagItem.registerRecipe();
        BlueLightItem.registerRecipe();
        CarRimItem.registerRecipe();
        CarWheelItem.registerRecipes();
        HeadlightsItem.registerRecipe();
        HornItem.registerRecipe();
        SeatItem.registerRecipes();
        SteeringWheelItem.registerRecipe();
    }
}

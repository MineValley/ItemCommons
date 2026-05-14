package eu.minevalley.itemcommons;

import eu.minevalley.core.api.Core;
import eu.minevalley.itemcommons.technology.*;
import eu.minevalley.itemcommons.technology.engines.CombustionEngineItem;
import eu.minevalley.itemcommons.technology.engines.CylinderItem;
import eu.minevalley.itemcommons.technology.engines.ElectricMotorItem;
import eu.minevalley.itemcommons.technology.engines.SparkPlugItem;
import eu.minevalley.itemcommons.technology.vehicles.*;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public final class ItemCommons {

    private static Core core;

    @Nonnull
    @Contract(pure = true)
    public static Core core() {
        return core;
    }

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

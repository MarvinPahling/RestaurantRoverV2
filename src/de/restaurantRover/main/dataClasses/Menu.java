package de.restaurantRover.main.dataClasses;

import de.restaurantRover.utils.FileUtilities;

public class Menu {

    public static Item[] items = new Item[0];

    public static void loadMenuFromFile(String csvFilePath) {
        items = FileUtilities.readItemsFromCsv(csvFilePath);
    }



}

package de.restaurantRover.main.dataClasses;

public class Settings {
    static int tableCount = 8;

    public static int getTableCount(){
        return tableCount;
    }

    public static void setTableCount(int tableCount) {
        Settings.tableCount = tableCount;
    }

    public static final String pathToInternalDara = "src/de/restaurantRover/internalData";
    public static final String pathToBar = "src/de/restaurantRover/internalData/Bar";
    public static final String pathToKitchen = "src/de/restaurantRover/internalData/Kitchen";

    public static final String pathToMenu = "src/de/restaurantRover/Menu/CurrentMenu/menu.csv";
}

package de.restaurantRover.main.dataClasses;

public class Settings {
    static int tableCount = 8;

    public static int getTableCount(){
        return tableCount;
    }

    public static void setTableCount(int tableCount) {
        Settings.tableCount = tableCount;
    }

    public static final String pathToTemp = "Restaurant_Rover/temp";
    public static final String pathToBar = "Restaurant_Rover/temp/Bar";
    public static final String pathToKitchen = "Restaurant_Rover/temp/Kitchen";

    public static final String pathToMenu = "Restaurant_Rover/Menu/menu.csv";
}

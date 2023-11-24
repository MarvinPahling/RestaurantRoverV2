package de.restaurantRover.main.dataClasses;

public class TabelManager {

    public static Table[] tables;

    public TabelManager() {
        tables = new Table[Settings.getTableCount()];
        for (int i = 0; i < Settings.getTableCount(); i++) {
            tables[i] = new Table(i);
        }
    }
}

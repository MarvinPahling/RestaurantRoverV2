package de.restaurantRover.main.dataClasses;

public class Table {

    int tableNumber;
    Item[] orderdItems;
    Item[] selectedItems;
    float bill;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}

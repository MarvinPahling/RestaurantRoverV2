package de.restaurantRover.main.dataClasses;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public int tableNumber;
    public ArrayList<Item> selectedItems;
   public ArrayList<Item> orderdItems;
   public float bill;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.selectedItems = new ArrayList<Item>();
        this.orderdItems = new ArrayList<Item>();
    }


    public void printSelectedItems(){

        System.out.println("Selected Items:");
        if (selectedItems != null) {
            for (Item item : selectedItems) {
                System.out.println(item.name);
            }
        }

    }

    public void printOrderedItems(){
        System.out.println("Ordered Items:");
        if(orderdItems != null){
            for (Item item : orderdItems) {
                System.out.println(item.name);
            }
        }

    }
}

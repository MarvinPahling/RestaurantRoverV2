package de.restaurantRover.main.Screens;

import de.restaurantRover.main.dataClasses.Table;
import de.restaurantRover.main.dataClasses.TableManager;

import java.util.Scanner;

public class TableSelectionScreen {

    public static void run(int tableNumber){

        TableManager manager = new TableManager();
        manager.init();

        System.out.println(String.format("Wählen sie eine Tischnummer zwischen 1 und %d aus:", tableNumber));
        Scanner s = new Scanner(System.in);
        int eingabe = s.nextInt();
        s.close();

        if (eingabe > tableNumber || eingabe < 1) {
            System.out.println("Bitte geben Sie eine gültige Tischnummer ein!");
            run(tableNumber);
        } else {

            TableManager.tables[eingabe - 1] = new Table(eingabe);
            OrderScreen.print_ordered_items(eingabe);
        }
    }
}

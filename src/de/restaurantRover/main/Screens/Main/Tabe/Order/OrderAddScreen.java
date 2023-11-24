package de.restaurantRover.main.Screens.Main.Tabe.Order;

import de.restaurantRover.main.dataClasses.*;
import de.restaurantRover.utils.ConsoleUtilities;
import de.restaurantRover.utils.FileUtilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class OrderAddScreen {
    public static void run(int Table) {
        System.out.println("OderAddScreen");
        ConsoleUtilities.PrintMenu(Menu.items);

        System.out.println("Bitte geben sie eine Nummer ein");

        Scanner s = new Scanner(System.in);
        int Eingabe = s.nextInt();


        if((Eingabe > 0 && Eingabe < Menu.items.length)){

            TabelManager.tables[Table - 1].selectedItems.add(Menu.items[Eingabe]);

        }
        OrderScreen.run(Table);
    }
}

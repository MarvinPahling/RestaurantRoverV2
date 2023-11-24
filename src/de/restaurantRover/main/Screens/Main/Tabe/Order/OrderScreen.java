package de.restaurantRover.main.Screens.Main.Tabe.Order;

import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.main.dataClasses.Settings;
import de.restaurantRover.main.dataClasses.Table;
import de.restaurantRover.main.enums.Place;
import de.restaurantRover.utils.ConsoleUtilities;
import de.restaurantRover.main.dataClasses.TabelManager;
import de.restaurantRover.utils.FileUtilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OrderScreen {

   public static void run(int tableNumber){
       Table self = TabelManager.tables[tableNumber - 1];
       if(self == null){
           self = new Table(tableNumber);
       }
       ConsoleUtilities.clear();

       Scanner s = new Scanner(System.in);


       System.out.println(String.format("Tisch %d", tableNumber));
       ConsoleUtilities.printMinusLine();
       ConsoleUtilities.printEmptyLine(2);

       System.out.println("Bestellte Posten:");
       self.printOrderedItems();
       ConsoleUtilities.printEmptyLine(2);

       System.out.println("Ausgewählte Posten:");
       self.printSelectedItems();
       ConsoleUtilities.printEmptyLine(2);
       ConsoleUtilities.printMinusLine();


         System.out.println("Bitte wählen Sie eine Option aus:");
         System.out.println("1. Essen/Getränke hinzufügen");
         System.out.println("2. Bestellung aufgeben");


         System.out.println("3. Bezahlung");

            int eingabe = s.nextInt();

            switch (eingabe) {
                case 1:
                    OrderAddScreen.run(tableNumber);
                    break;
                case 2:
                    Item[] items = self.selectedItems.toArray(new Item[0]);
                    Item[] bar = new Item[items.length];
                    Item[] kitchen = new Item[items.length];
                    int c1 = 0;
                    int c2 = 0;
                    for (Item item : items){
                        if(item.getPlace().equals(Place.BAR)){
                            bar[c1] = item;
                            c1++;
                        }
                        if(item.getPlace().equals(Place.KITCHEN)){
                            kitchen[c2] = item;
                            c2++;
                        }
                    }

                    bar = Arrays.copyOfRange(bar, 0, c1);
                    kitchen = Arrays.copyOfRange(kitchen, 0, c2);

                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    String formattedDateTime = currentDateTime.format(formatter);

                    FileUtilities.writeItemsToCsv(bar, Settings.pathToBar + String.format("/Tisch%d_%s.csv", tableNumber, formattedDateTime));
                    FileUtilities.writeItemsToCsv(kitchen, Settings.pathToKitchen + String.format("/Tisch%d_%s.csv", tableNumber, formattedDateTime));

                    self.orderdItems.addAll(self.selectedItems);

                    self.selectedItems.clear();

                    OrderScreen.run(tableNumber);
                case 3:
                    //OrderPay.run(tableNumber);
                    break;
                default:
                    System.out.println("Bitte geben Sie eine gültige Option ein!");
                    run(tableNumber);
                    break;
            }




   }

}



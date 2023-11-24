package de.restaurantRover.main.Screens;

import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.main.dataClasses.Settings;
import de.restaurantRover.utils.FileUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class OrderAddScreen {
    public static void run(int Table) {
        String Eingabe = "";

        Item[] itemsBar = new Item[100]; // vorlaeufige Groeße des Arrays
        int iBar = 0;

        Item[] itemsKitchen = new Item[100]; // vorlaeufige Groeße des Arrays
        int ikitchen = 0;


        do {
            for (int i = 0; i < 100; i++) {
                System.out.println(" ");
            }

            //Ausgabe der bis jetzt hinzugefügen Items
            System.out.print("Ihre neuen Bestellungen:\n");
            System.out.print("Getraenke:\n");
            for (int j = 0; (j < itemsBar.length) && (itemsBar[j] != null); j++) {
                System.out.println(" " + itemsBar[j].getName());
            }
            System.out.print("\nEssen:\n");
            for (int j = 0; (j < itemsKitchen.length) && (itemsKitchen[j] != null); j++) {
                System.out.println(" " + itemsKitchen[j].getName());
            }

            Scanner s = new Scanner(System.in);




            System.out.print("\n \nWas moechten sie als naechstes tun?\n E = Essen ordern \n G = Getraenke ordern\n A = Order abschicken \n C = Cancel \n");

            Eingabe = s.next();
            s.close();


            switch (Eingabe) {
                case "E":
                    OrderAddEssenScreen.run(itemsKitchen);
                    break;
                case "G":
                    OrderAddGetraenkeScreen.run(itemsBar);
                    break;
                case "A":

                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    String formattedDateTime = currentDateTime.format(formatter);
                {

                    String BarPath = Settings.pathToBar + "/Table" + Table + "BarOrder" + formattedDateTime + ".csv"/*"Restaurant_Rover\\temp\\Table" + Integer.toString(Table) + "BarOrder" + formattedDateTime + ".csv"*/;  // Replace with the source file path

                    //4"Restaurant_Rover/temp"
                    int lengthBarorder = 0;

                    for (int i = 0; i < itemsBar.length; i++) {
                        if (itemsBar[i] == null) {
                            Item[] realItems = Arrays.copyOfRange(itemsBar, 0, i);
                            lengthBarorder = realItems.length;
                            FileUtilities.writeItemsToCsv(realItems, BarPath);
                            break;
                        }
                    }

                    Item[] TableItems = FileUtilities.readItemsFromCsv("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");
                    Item[] Table_x = new Item[TableItems.length + lengthBarorder];

                    int BarIndex = 0;

                    for (int i = 0; i < Table_x.length; i++) {
                        if (TableItems.length != 0 && i < TableItems.length) {
                            Table_x[i] = TableItems[i];
                        } else if (BarIndex < itemsBar.length && itemsBar[BarIndex] != null) {
                            Table_x[i] = itemsBar[BarIndex];
                            BarIndex++;
                        }
                    }
                    //Ist gut moeglich dass hier wenn das Cancel gefixt ist und mehrere Orders aufgegeben werden die Table Datei vor einem weiteren beschreiben erst noch geleert werden muss
                    String TablePath = "Restaurant_Rover/temp/currentTables/Table" + Table + ".csv";

                    for (int i = 0; i <= Table_x.length; i++) {
                        if (i == (Table_x.length)) {
                            Item[] realItems = Arrays.copyOfRange(Table_x, 0, i);
                            FileUtilities.writeItemsToCsv(realItems, TablePath);
                            break;
                        }
                    }
                }

                /////////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////////
                {
                    String KitchenPath = "Restaurant_Rover/temp/Kitchen/Table" + Table + "KitchenOrder" + formattedDateTime + ".csv";  // Replace with the source file path

                    int lengthKitchenorder = 0;

                    for (int i = 0; i < itemsKitchen.length; i++) {
                        if (itemsKitchen[i] == null) {
                            Item[] realItems = Arrays.copyOfRange(itemsKitchen, 0, i);
                            lengthKitchenorder = realItems.length;
                            FileUtilities.writeItemsToCsv(realItems, KitchenPath);
                            break;
                        }
                    }

                    Item[] TableItems = FileUtilities.readItemsFromCsv("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");
                    Item[] Table_y = new Item[TableItems.length + lengthKitchenorder];

                    int KitchenIndex = 0;

                    for (int i = 0; i < Table_y.length; i++) {
                        if (TableItems.length != 0 && i < TableItems.length) {
                            Table_y[i] = TableItems[i];
                        } else if (KitchenIndex < itemsKitchen.length && itemsKitchen[KitchenIndex] != null) {
                            Table_y[i] = itemsKitchen[KitchenIndex];
                            KitchenIndex++;
                        }
                    }
                    //Ist gut moeglich dass hier wenn das Cancel gefixt ist und mehrere Orders aufgegeben werden die Table Datei vor einem weiteren beschreiben erst noch geleert werden muss
                    String TablePath = "Restaurant_Rover/temp/currentTables/Table" + Table + ".csv";

                    for (int i = 0; i <= Table_y.length; i++) {
                        if (i == (Table_y.length)) {
                            Item[] realItems = Arrays.copyOfRange(Table_y, 0, i);
                            FileUtilities.writeItemsToCsv(realItems, TablePath);

                        }
                    }
                }
                OrderScreen.print_ordered_items(Table);
                break;
                case "C":
                    OrderScreen.print_ordered_items(Table);
                    break;
                default:
                    System.out.print("Ungueltige Eingabe");
                    break;
            }



        } while (true);
    }
}

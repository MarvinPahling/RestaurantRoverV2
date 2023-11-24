package de.restaurantRover.main.Screens.Main.Tabe;

import de.restaurantRover.main.Screens.Main.Tabe.Order.OrderScreen;
import de.restaurantRover.main.dataClasses.Settings;
import de.restaurantRover.main.dataClasses.TabelManager;
import de.restaurantRover.main.dataClasses.Table;


import java.util.Scanner;

public class TableSelectionScreen {

    public static void run(int tableNumber){


        TabelManager TableManager = new TabelManager();
        TabelManager.tables = new Table[Settings.getTableCount()];
        System.out.println(String.format("Wählen sie eine Tischnummer zwischen 1 und %d aus:", tableNumber));
        Scanner s = new Scanner(System.in);
        int eingabe = s.nextInt();


        if(eingabe > 0 && eingabe <= tableNumber){

            TableManager.tables[eingabe - 1] = new Table(eingabe);
            OrderScreen.run(eingabe);
        }else{
            while (eingabe > tableNumber || eingabe < 1) {
                System.out.println("Bitte geben Sie eine gültige Tischnummer ein!");
                eingabe = s.nextInt();
            }
            s.close();
            TableManager.tables[eingabe - 1] = new Table(eingabe);
            OrderScreen.run(eingabe);
        }


        }
    }


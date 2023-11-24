package de.restaurantRover.main.Screens;

import de.restaurantRover.main.dataClasses.Settings;

import java.util.Scanner;

public class MainScreen {

    public static void run(){

        for(int i=0;i<100;i++){             //Seiten refresh
            System.out.println(" ");
        }


        System.out.println("Willkommen im Restaurant Rover!");
        System.out.println("Bitte wählen Sie eine der folgenden Optionen aus:");
        System.out.println("1. Admin-Menü");
        System.out.println("2. Bar-Menü");
        System.out.println("3. Küchen-Menü");
        System.out.println("4. Tisch-Menü");

        Scanner s = new Scanner(System.in);
        String Eingabe = s.next();

        switch (Eingabe) {
            case "1":
                AdminScreen admin = new AdminScreen();
                admin.run();
                break;
            case "2":
                BarScreen bar = new BarScreen();
                bar.run();
                break;
            case "3":
                KitchenScreen kitchen = new KitchenScreen();
                kitchen.run();
                break;
            case "4":
                TableSelectionScreen tableSelection = new TableSelectionScreen();
                tableSelection.run(Settings.getTableCount());
                break;
            default:
                System.out.println("Bitte geben Sie eine gültige Option ein!");
                run();
                break;
        }





    }
}

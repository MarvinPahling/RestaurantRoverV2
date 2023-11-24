package de.restaurantRover.main.Screens.Main.Admin;

import de.restaurantRover.main.Screens.Main.MainScreen;
import de.restaurantRover.main.dataClasses.AccessData;
import de.restaurantRover.main.dataClasses.Menu;
import de.restaurantRover.main.dataClasses.Settings;
import de.restaurantRover.utils.FileUtilities;

import java.util.Scanner;

public class AdminScreen {
    public static void run(){
        System.out.println("AdminScreen");
        System.out.println("Bitte geben Sie das Passwort ein:");
        Scanner s = new Scanner(System.in);
        String eingabe = s.next();

        // Passwortabfrage mit 3 Versuchen
        int counter = 0;
        while (!eingabe.equals(AccessData.getPassword())) {
            System.out.println("Bitte geben Sie das Passwort ein:");
            eingabe = s.next();
            counter++;
            if (counter == 3) {
                System.out.println("Zu viele Fehlversuche!");
                System.exit(0);
            }
        }

        System.out.println("Bitte wählen Sie eine der folgenden Optionen aus:");
        System.out.println("1. Tischnummer ändern");
        System.out.println("2. Speisekarte einlesen");
        System.out.println("3. Aktuelle Speisekarte speichern");
        System.out.println("4. Zurück zum Hauptmenü");

        String Eingabe = s.next();
        switch (Eingabe) {
            case "1":
                System.out.println("Bitte geben Sie die neue Tischnummer ein:");
                int neueTischnummer = s.nextInt();
                if (neueTischnummer < 0){
                    while (neueTischnummer < 0){
                        System.out.println("Bitte geben Sie eine gültige Tischnummer ein:");
                        neueTischnummer = s.nextInt();
                    }
                }
                System.out.println(String.format("Die Tischnummer wurde auf %s geändert.", neueTischnummer));
                Settings.setTableCount(neueTischnummer);
                run();
                break;
            case "2":
                Menu.items = FileUtilities.readItemsFromCsv("Restaurant_Rover/de.restaurantRover.Menu/menu.csv");
                run();
                break;
            case "3":
                FileUtilities.writeItemsToCsv(Menu.items, "Restaurant_Rover/de.restaurantRover.Menu/CurrentMenu/menu.csv");
                run();
                break;
            case "4":
                MainScreen mainScreen = new MainScreen();
                mainScreen.run();
                break;

            default:
                System.out.println("Bitte geben Sie eine gültige Option ein!");
                run();
                break;
        }
    }
}

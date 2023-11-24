package de.restaurantRover.main.Screens;

import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.main.dataClasses.Settings;
import de.restaurantRover.utils.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class OrderPay {
    public static void run(int Table) {
        Item[] items = null;
        double Summe = 0;
        String Eingabe = "";

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);

        //if exist "temp_path"+"table_"+Integer.toString(Table)+".csv"{
        // Replace with the actual file path

        File file = new File("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");



        items = FileUtilities.readItemsFromCsv("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");


        if (items != null) {
            do {
                for (int i = 0; i < 5; i++) {
                    System.out.println(" ");
                }

                System.out.print("Ihre bisherigen Bestellungen:\n");

                for (int j = 0; j < items.length; j++) {
                    System.out.println(" " + items[j].getName() + "       " + Float.toString(items[j].getPreis()));
                    Summe += items[j].getPreis();
                }

                Summe = Math.round(Summe * 100) / 100.0;
                System.out.println("\n Ihre Rechnungssumme betraegt:  " + Summe +"€");


                Scanner s = new Scanner(System.in);

                System.out.print("\n \nMoechten Sie Bar oder mit Karte bezahlen? \n B = Bar \n K = Karte \n");
                Eingabe = s.next();
                if (("B".equals(Eingabe)) || ("K".equals(Eingabe))) {
                    System.out.println("\n Vielen Dank fuer Ihren Besuch!");

                    Path sourcePath = Paths.get("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");  // Replace with the source file path
                    Path destinationPath = Paths.get("Restaurant_Rover/temp/Admin/Table_" + Table + formattedDateTime + ".csv");  // Replace with the destination folder path

                    try {
                        // Move the file to the destination folder
                        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Error moving the file: " + e.getMessage());
                    }

                    try {
                        Thread.sleep(5000);

                        MainScreen.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }




                    MainScreen.run();

                } else if (("xyz123".equals(Eingabe))) {

                    Path sourcePath = Paths.get("Restaurant_Rover/temp/currentTables/Table" + Table + ".csv");  // Replace with the source file path
                    Path destinationPath = Paths.get("Restaurant_Rover/temp/Admin/Table" + Table + formattedDateTime + "storno.csv");  // Replace with the destination folder path



                    try {
                        // Move the file to the destination folder
                        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Error moving the file: " + e.getMessage());
                    }
                    break;
                } else {
                    System.out.print("Ungueltige Eingabe");
                }

            } while (true);


        }
    }

}

package de.restaurantRover.main.Screens;

import de.restaurantRover.main.dataClasses.AccessData;
import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.utils.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OrderScreen {
    public static Item[] items = new Item[0];
    public static void print_ordered_items(int Table){

        String Eingabe = "";
        Item[] items = null;

                //if exist "temp_path"+"table_"+Integer.toString(Table)+".csv"{
        String filePath = "Restaurant_Rover/temp/currentTables/Table" + Table+".csv";
        // Replace with the actual file path

        File file = new File(filePath);

        if (!file.exists()) {
           //Leere Datei erzeugen;
            try{
                file.createNewFile();
            }
                catch(IOException e){
                System.err.println("Error creating the file: " + e.getMessage());
            }
        }

        //Dateiexistiert jetzt sicher
        //georderte Items fuer diesen Tisch ausgeben


        //do{
            for(int i=0; i<100; i++){
            System.out.println( " ");
            }

            items =  FileUtilities.readItemsFromCsv(filePath);

            System.out.print("Ihre bisherigen Bestellungen:\n");

            for(int j=0; j<items.length; j++){
            System.out.println( " "+items[j].getName() );
            }



            System.out.print("\n \nWas moechten sie als naechstes tun? \n B = Bestellen \n R = Rechnung \n");
            Scanner s = new Scanner(System.in);
            Eingabe = s.next();
            s.close();

            switch (Eingabe){
                case "B":
                    OrderAddScreen.run(Table);
                    break;
                case "R":
                    OrderPay.run(Table);
                    break;
                default:
                    System.out.print("Ungueltige Eingabe");
            }


        //}while (!Eingabe.equals(AccessData.backPassword));

       /*}while()
        //Abfrage moechten sie etwas bestellen?
        bei nein Abbruch Screen verlassen;
        bei Ja
            Leere Datei erzeugen;

        oeffne OrderAdd Screen





        //Hanna*/
        // List of all the things that have been ordered, if nothing has been ordered before shows text like
    }   // "what would you like to order?" and if something has been ordered show further options like
    // order more or pay or send order Kitchen and Bar
}



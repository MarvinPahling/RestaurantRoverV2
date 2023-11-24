package de.restaurantRover.utils;

import de.restaurantRover.main.dataClasses.Item;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import de.restaurantRover.main.enums.Category;
import de.restaurantRover.main.enums.Place;
import de.restaurantRover.main.enums.Veggie;

public class FileUtilities {

    //Hier kommt das Schreiben und lesen der CSV Datei rein


    /**
     * writes the given items to a csv file
     * @param itemList the items to write
     * @param csvFilePath the path to the csv file
     *
     *
     */
    public static void writeItemsToCsv(Item[] itemList, String csvFilePath) {
        try {
            FileWriter writer = new FileWriter(csvFilePath);

            // Schreibe die Spaltenüberschriften
            writer.append("Name");
            writer.append(";");
            writer.append("Preis");
            writer.append(";");
            writer.append("Kategorie");
            writer.append(";");
            writer.append("Veggie");
            writer.append(";");
            writer.append("Place");
            writer.append(";");
            writer.append("Beschreibung");
            writer.append("\n");


            // Schreibe die Datensätze
            for (Item item : itemList) {
                writer.append(item.getName());
                writer.append(";");
                writer.append(String.valueOf(item.getPreis()));
                writer.append(";");
                writer.append(item.getKategorie().toString());
                writer.append(";");
                writer.append(item.getVeggie().toString());
                writer.append(";");
                writer.append(item.getPlace().toString());
                writer.append(";");
                writer.append(item.getDescription());
                writer.append("\n");
            }

            // Schließe den Writer
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * reads the items from a csv file
     * @param csvFilePath the path to the csv file
     * @return the items
     */
    public static Item[] readItemsFromCsv(String csvFilePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));

            // Ignoriere die erste Zeile (Spaltenüberschriften)
            String line = reader.readLine();
            line = reader.readLine();

            Item[] items = new Item[100]; // vorläufige Größe des Arrays
            int i = 0;

            while (line != null) {
                String[] fields = line.split(";");
                String name = fields[0];
                float preis = Float.parseFloat(fields[1]);
                Category kategorie = Category.valueOf(fields[2]);
                Veggie veggie = Veggie.valueOf(fields[3]);
                Place place = Place.valueOf(fields[4]);
                String description = fields[5];

                // Erstelle ein neues Item-Objekt und füge es zum Array hinzu
                items[i] = new Item(name, preis, kategorie, veggie, place, description);
                i++;

                line = reader.readLine();
            }

            reader.close();

            // Verkleinere das Array auf die tatsächliche Größe
            Item[] realItems = Arrays.copyOfRange(items, 0, i);

            return realItems;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDescription(int startingIndex, String[] fields) {
    	String description = "";
    	for(int i = startingIndex; i < fields.length; i++) {
    		description += fields[i];
    		if(i != fields.length - 1) {
    			description += ",";
    		}
    	}
    	return description;
    }

}

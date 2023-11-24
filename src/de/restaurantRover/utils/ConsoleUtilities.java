package de.restaurantRover.utils;


import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.main.enums.Category;
import de.restaurantRover.main.enums.Veggie;

import java.util.ArrayList;

public class ConsoleUtilities {

   public static void printMinusLine(){
      System.out.println("--------------------------------------");
   }

   public static void clear(){
       System.out.print("\033[H\033[2J");
         System.out.flush();
   }

   public static void printEmptyLine(int count){
      for (int i = 0; i < count; i++) {
         System.out.println();
      }
   }

   public static void PrintMenu(Item[] menu){

      System.out.println("Menu");
      printEmptyLine(2);
      System.out.println(Category.STARTER.name());
      printMinusLine();
      Category lastCat = Category.STARTER;
      Category currentCat;
      for (int i = 0; i < menu.length; i++) {
         currentCat = menu[i].getKategorie();
         if(!currentCat.equals(lastCat)){
            printEmptyLine(2);
            System.out.println(currentCat.name());
            printMinusLine();
         }
         printItem(i, menu[i]);

         lastCat = currentCat;
      }
   }

   public static void PrintBill(ArrayList<Item> items){
      float bill = 0;

      System.out.println("Rechnung");
      ConsoleUtilities.printMinusLine();

      for(Item item : items){
         System.out.println(String.format("%s | %s", item.getName(), item.getPreis()));
         bill += item.getPreis();
      }
   }

   public static void printItem(int num, Item item){
      System.out.println(String.format("%d. %s %S | %s | %s", num, item.getName(),isVegi(item.getVeggie()), item.getDescription(), item.getPreis()));
   }

   public static String isVegi(Veggie v){
      switch (v){
         case VEGAN:
            return "(Vegan)";
         case VEGETARIAN:
            return "(Vegetarisch)";
          default:
            return "";
      }
   }




}

package de.restaurantRover.utils;



public class ConsoleUtilities {

    public static void printCentered(String s){
        int with = 120;

        int length = s.length();
        int spaces = (with - length) / 2;
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.println(s);
    }

    public static void clearScreen(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.flush();
    }
}

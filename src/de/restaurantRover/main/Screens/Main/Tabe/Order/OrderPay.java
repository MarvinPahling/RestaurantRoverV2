package de.restaurantRover.main.Screens.Main.Tabe.Order;

import de.restaurantRover.main.Screens.Main.MainScreen;
import de.restaurantRover.main.dataClasses.Item;
import de.restaurantRover.main.dataClasses.TabelManager;
import de.restaurantRover.utils.ConsoleUtilities;
import de.restaurantRover.utils.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrderPay {


    public static void run(int tableNumber) {

        ConsoleUtilities.PrintBill(TabelManager.tables[tableNumber - 1].orderdItems);


    }
}
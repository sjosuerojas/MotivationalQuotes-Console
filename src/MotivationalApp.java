import controllers.AppController;

import service.*;
import service.interfaces.QuoteProvider;
import ui.ConsoleUI;

import java.util.Scanner;

public class MotivationalApp {
    public static void main(String[] args) {
        QuoteProvider quoteProvider;
        try {
            quoteProvider = new FileQuoteProvider("quotes.txt");
        } catch (Exception e) {
            System.out.println("⚠ Could not load quotes from file. Using fallback quotes.\\n");
            quoteProvider = new InMemoryQuoteProvider();
        }

        ConsoleUI consoleUI = new ConsoleUI();
        Scanner scanner = new Scanner(System.in);

        AppController appController = new AppController(quoteProvider, consoleUI, scanner);
        appController.start();

        scanner.close();
    }
}

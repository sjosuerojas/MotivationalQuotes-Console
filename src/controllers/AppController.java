package controllers;

import service.interfaces.QuoteProvider;
import service.interfaces.QuoteWritableProvider;
import ui.ConsoleUI;

import java.util.Scanner;

public class AppController {
    private final QuoteProvider quoteProvider;
    private final ConsoleUI consoleUI;
    private final Scanner scanner;

    public AppController(QuoteProvider quoteProvider, ConsoleUI consoleUI, Scanner scanner) {
        this.quoteProvider = quoteProvider;
        this.consoleUI = consoleUI;
        this.scanner = scanner;
    }

    public void start() {
        consoleUI.showWelcome();
        boolean running = true;

        while(running) {
            consoleUI.showQuote(quoteProvider.getRandomQuote());
            consoleUI.showMenu();

            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> {}
                case "2" -> {
                    if (quoteProvider instanceof QuoteWritableProvider writable) {
                        String newQuote = consoleUI.promptForNewQuote();
                        writable.addQuote(newQuote);
                        System.out.println("✅ Quote added successfully!\n");
                    } else {
                        System.out.println("⚠️ Quote saving not supported in this mode.\n");
                    }
                }
                case "3", "exit", "q" -> {
                    running = false;
                    consoleUI.showExitMessage();
                }
                default -> consoleUI.showInvalidOption();
            }
        }
    }
}

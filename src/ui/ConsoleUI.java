package ui;

public class ConsoleUI {
    public void showWelcome() {
        System.out.println("🌟 Welcome to the Motivational Quotes Generator 🌟\n");
    }

    public void showQuote(String quote) {
        System.out.println("💬 Quote of the day:");
        System.out.println(quote + "\n");
    }

    public void showMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show another quote");
        System.out.println("2. Add a new quote");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public String promptForNewQuote() {
        System.out.print("\n📝 Enter your new motivational quote: ");
        return new java.util.Scanner(System.in).nextLine().trim();
    }

    public void showExitMessage() {
        System.out.println("\n👋 Thanks for using the generator. Stay motivated!");
    }

    public void showInvalidOption() {
        System.out.println("⚠️ Invalid option. Please try again.\n");
    }
}

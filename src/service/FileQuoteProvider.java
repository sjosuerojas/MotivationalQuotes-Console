package service;

import service.interfaces.QuoteWritableProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

public class FileQuoteProvider implements QuoteWritableProvider {

    private final Path filePath;
    private final List<String> quotes;
    private final Random random = new Random();

    public FileQuoteProvider(String fileName) throws IOException {
        this.filePath = Path.of(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        this.quotes = Files.readAllLines(filePath);

        if (quotes.isEmpty()) {
            quotes.add("✨ Start by adding a quote!");
        }
    }

    @Override
    public String getRandomQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    @Override
    public void addQuote(String quote) {
        if (quote == null || quote.isBlank()) return;

        try {
            Files.writeString(filePath, quote + System.lineSeparator(), StandardOpenOption.APPEND);
            quotes.add(quote);
        } catch (IOException e) {
            System.out.println("❌ Error saving quote: " + e.getMessage());
        }
    }
}

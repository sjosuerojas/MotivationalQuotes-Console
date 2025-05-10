package service;

import service.interfaces.QuoteProvider;

import java.util.List;
import java.util.Random;

public class InMemoryQuoteProvider implements QuoteProvider {
    private final List<String> quotes = List.of(
            "Success is the sum of small efforts repeated day in and day out.",
            "Believe in yourself and everything will be possible.",
            "Motivation gets you going, but discipline keeps you growing.",
            "Don't count the days, make the days count.",
            "Do today what others won’t, so you can live tomorrow how others can’t."
    );

    private final Random random = new Random();

    @Override
    public String getRandomQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }
}

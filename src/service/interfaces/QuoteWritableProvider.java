package service.interfaces;

public interface QuoteWritableProvider extends QuoteProvider {
    void addQuote(String quote);
}

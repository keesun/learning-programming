package whiteship.actor;

/**
 * @author: Keesun Baik
 */
public class StockInfo {
    public final String ticker;
    public final double value;
    public final double price;

    public StockInfo(final String tickerSymbol, final double theValue, final double thePrice) {
        ticker = tickerSymbol;
        value = theValue;
        price=thePrice;
    }

}

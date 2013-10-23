package whiteship.aync;

//YahooFinance.java

import org.springframework.web.client.RestTemplate;

public class YahooFinance {

    private static final String YAHOO_FINANCE_API = "http://download.finance.yahoo.com/d/quotes.csv?s=";
    private static final String API_PARAMS = "&f=nsl1op&e=.csv";

    public static double getPrice(final String ticker) {
        RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject(YAHOO_FINANCE_API + ticker + API_PARAMS, String.class);
        final String[] dataItems = data.split(",");
        return Double.parseDouble(dataItems[dataItems.length - 1]);
    }
}

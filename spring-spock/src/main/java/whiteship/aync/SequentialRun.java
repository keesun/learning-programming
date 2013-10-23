package whiteship.aync;

/**
 * @author: Keesun Baik
 */

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SequentialRun extends AbstractRun {

    protected Map<String, Object> computeFinancials() {
        String lowPricedTicker ="";
        double lowPrice = Integer.MAX_VALUE;
        String highPricedTicker ="";
        double highPrice = Integer.MIN_VALUE;
        double netAssetValue = 0;

        Map<Integer, Future> futureMap = new HashMap<Integer, Future>();

        for(int i = 0; i < Stocks.tickers.length; i++) {
            String ticker = Stocks.tickers[i];
            Future<ResponseEntity<String>> futurePrice = YahooFinance.getFuturePrice(ticker);
            futureMap.put(i, futurePrice);
        }

        for(Map.Entry<Integer, Future> entry : futureMap.entrySet()) {
            double price = getPriceFrom(entry.getValue());
            Integer index = entry.getKey();
            netAssetValue += (price * Stocks.shares[index]);
            if (price < lowPrice) {
                lowPrice = price;
                lowPricedTicker = Stocks.tickers[index];
            }
            if (price > highPrice) {
                highPrice = price;
                highPricedTicker = Stocks.tickers[index];
            }
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("HIGHTICKER", highPricedTicker);
        result.put("HIGHPRICE", highPrice);
        result.put("LOWTICKER", lowPricedTicker);
        result.put("LOWPRICE", lowPrice);
        result.put("NAV", netAssetValue);
        return result;
    }

    private double getPriceFrom(Future<ResponseEntity<String>> future) {
        ResponseEntity<String> stringResponse = null;
        try {
            stringResponse = future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String data = stringResponse.getBody();
        final String[] dataItems = data.split(",");
        return Double.parseDouble(dataItems[dataItems.length - 1]);
    }


    public static void main(String[] args) throws Exception {
        new SequentialRun().computeFinancialsAndPrint();
    }
}

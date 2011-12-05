package whiteship.actor;

/**
 * @author: nbp
 */

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import akka.actor.UntypedActor;

public class Accumulator extends UntypedActor {

    int numberOfTickers = -1;
    int numberOfStockInfoReceived = 0;
    String lowPricedTicker = "";
    double lowPrice = Integer.MAX_VALUE;
    String highPricedTicker = "";
    double highPrice = Integer.MIN_VALUE;
    double netAssetValue = 0;
    akka.dispatch.CompletableFuture<Object> futureResponse;

    public void onReceive(final Object message) {

        if (message instanceof FetchResult) {
            numberOfTickers = ((FetchResult) (message)).tickersCount;
            futureResponse = getContext().getSenderFuture().get();
        }

        if (message instanceof StockInfo) {
            numberOfStockInfoReceived++;
            StockInfo stockInfo = (StockInfo) message;
            netAssetValue += stockInfo.value;
            if (stockInfo.price < lowPrice) {
                lowPrice = stockInfo.price;
                lowPricedTicker = stockInfo.ticker;
            }
            if (stockInfo.price > highPrice) {
                highPrice = stockInfo.price;
                highPricedTicker = stockInfo.ticker;
            }

            if (numberOfStockInfoReceived == numberOfTickers) {
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("HIGHTICKER", highPricedTicker);
                result.put("HIGHPRICE", highPrice);
                result.put("LOWTICKER", lowPricedTicker);
                result.put("LOWPRICE", lowPrice);
                result.put("NAV", netAssetValue);
                futureResponse.completeWithResult(Collections.unmodifiableMap(result));
            }
        }
    }
}

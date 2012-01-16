package whiteship.stm;

/**
 * @author: Keesun Baik
 */

import java.util.Map;
import java.util.HashMap;

import clojure.lang.Ref;
import clojure.lang.LockingTransaction;
import whiteship.AbstractRun;
import whiteship.Stocks;
import whiteship.YahooFinance;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class STMRun extends AbstractRun {

    protected Map<String, Object> computeFinancials() {
        final Ref lowPricedTicker = new Ref("");
        final Ref lowPrice = new Ref(Integer.MAX_VALUE * 1.0);
        final Ref highPricedTicker = new Ref("");
        final Ref highPrice = new Ref(Integer.MIN_VALUE * 1.0);
        final Ref netAssetValue = new Ref(0.0);


        ExecutorService service = Executors.newFixedThreadPool(100);
        final CountDownLatch latch = new CountDownLatch(Stocks.tickers.length);
        try {

            for (int i = 0; i < Stocks.tickers.length; i++) {
                final int index = i;
                service.execute(new Runnable() {
                    public void run() {
                        try {
                            final double price = YahooFinance.getPrice(Stocks.tickers[index]);
                            LockingTransaction.runInTransaction(new Callable<Object>() {
                                public Object call() {
                                    double currentNAV = (Double) netAssetValue.deref();
                                    netAssetValue.set(currentNAV + price * Stocks.shares[index]);
                                    if (price < (Double) lowPrice.deref()) {
                                        lowPrice.set(price);
                                        lowPricedTicker.set(Stocks.tickers[index]);
                                    }

                                    if (price > (Double) highPrice.deref()) {
                                        highPrice.set(price);
                                        highPricedTicker.set(Stocks.tickers[index]);
                                    }
                                    return null;
                                }
                            });
                            latch.countDown();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }

            latch.await();
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("HIGHTICKER", (String) highPricedTicker.deref());
            result.put("HIGHPRICE", (Double) highPrice.deref());
            result.put("LOWTICKER", (String) lowPricedTicker.deref());
            result.put("LOWPRICE", (Double) lowPrice.deref());
            result.put("NAV", (Double) netAssetValue.deref());
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        new STMRun().computeFinancialsAndPrint();
    }
}

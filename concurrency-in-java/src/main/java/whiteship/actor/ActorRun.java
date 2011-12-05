package whiteship.actor;

/**
 * @author: nbp
 */

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import akka.actor.Actors;
import akka.actor.ActorRef;
import whiteship.AbstractRun;
import whiteship.Stocks;
import whiteship.YahooFinance;

public class ActorRun extends AbstractRun {

    protected Map<String, Object> computeFinancials() {
        final ActorRef accumulator = Actors.actorOf(Accumulator.class).start();
        ExecutorService service = Executors.newFixedThreadPool(100);
        try {
            for (int i = 0; i < Stocks.tickers.length; i++) {
                final int index = i;
                service.execute(new Runnable() {
                    public void run() {
                        double price = YahooFinance.getPrice(Stocks.tickers[index]);
                        accumulator.sendOneWay(new StockInfo(
                                Stocks.tickers[index], Stocks.shares[index] * price, price));
                    }
                });
            }
            Map<String, Object> result =
                    (Map<String, Object>) accumulator.sendRequestReply(
                            new FetchResult(Stocks.tickers.length));
            accumulator.stop();
            return result;
        } finally {
            service.shutdown();
        }

    }

    public static void main (String[]args){
        new ActorRun().computeFinancialsAndPrint();
    }

}

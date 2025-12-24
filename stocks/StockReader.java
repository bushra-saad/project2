//bushra abu saaad 325998870
//shams alzeadna 214840316
package stocks;

import java.util.Random;

//Reads stock from server

public class StockReader implements Runnable {

    private String name;
    private StockServer server;
    private Random rand = new Random();

    public StockReader(String name, StockServer server) {
        this.name = name;
        this.server = server;
    }

 // Reads 10 random stocks 
    @Override
    public void run() {
        Stock[] stocks = Stock.values();

        for (int i = 0; i < 10; i++) {
            Stock s = stocks[rand.nextInt(stocks.length)];
            int value = server.GetStock(s);

            System.out.println(
                "Name: " + name + ", " + s + " Stock: " + value + " USD"
            );

            try {
                Thread.sleep(1000 + rand.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//bushra abu saaad 325998870
//shams alzeadna 214840316
package stocks;
	import java.util.Random;

	//Periodically updates stocks 
	public class StockUpdateThread implements Runnable {

	    private StockServer server;
	    private Random rand = new Random();

	    public StockUpdateThread(StockServer server) {
	        this.server = server;
	    }

	    // Updates all stocks 10 times 
	    @Override
	    public void run() {
	        Stock[] stocks = Stock.values();

	        for (int i = 0; i < 10; i++) {
	            for (Stock s : stocks) {
	                int value = 100 + rand.nextInt(401);
	                server.UpdateStock(s, value);
	            }

	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


//bushra abu saaad 325998870
//shams alzeadna 214840316
package stocks;

public class Main {
    public static void main(String[] args) {

        // Shared stock server
        StockServer server = new StockServer();

        // Reader threads
        Thread reader1 = new Thread(new StockReader("Tami Tan", server));
        Thread reader2 = new Thread(new StockReader("Tim Saroli", server));
        Thread reader3 = new Thread(new StockReader("Sima Didas", server));

        // Update thread
        Thread updater = new Thread(new StockUpdateThread(server));

        //All threads Start 
        reader1.start();
        reader2.start();
        reader3.start();
        updater.start();
    }
}

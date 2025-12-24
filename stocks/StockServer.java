//bushra abu saaad 325998870
//shams alzeadna 214840316
package stocks;

//Shared stock server
public class StockServer {

    // Initial stock values
    private int microsoft = 215;
    private int apple = 180;
    private int google = 250;

   // Read stock safely
    public synchronized int GetStock(Stock stock) {
        switch (stock) {
            case MICROSOFT:
                return microsoft;
            case APPLE:
                return apple;
            case GOOGLE:
                return google;
            default:
                return -1;
        }
    }


 // Safe stock update
    public synchronized void UpdateStock(Stock stock, int value) {
        switch (stock) {
            case MICROSOFT:
                microsoft = value;
                break;
            case APPLE:
                apple = value;
                break;
            case GOOGLE:
                google = value;
                break;
        }
    }
}
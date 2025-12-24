//bushra abu saaad 325998870
//shams alzeadna 214840316
package Race;
public class Track {
    private int finishedRacers = 0;

    // הסינכרון מונע מצבים שבהם שני רצים קוראים את finishedRacers באותו הזמן
    public synchronized int incrementFinished() {
        finishedRacers++;
        return finishedRacers;
    }
}


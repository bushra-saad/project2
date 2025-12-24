//bushra abu saaad 325998870
//shams alzeadna 214840316
package XO;

public abstract class Player extends Thread {
    protected PlayerType type;
    protected Game game;

    public Player(PlayerType type, Game game) {
        this.type = type;
        this.game = game;
    }
}


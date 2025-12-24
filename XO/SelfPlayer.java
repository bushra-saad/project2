//bushra abu saaad 325998870
//shams alzeadna 214840316
package XO;

import java.util.List;
import java.util.Random;

public class SelfPlayer extends Player {

    private Random rand = new Random();

    public SelfPlayer(PlayerType type, Game game) {
        super(type, game);
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            if (game.getTurn() == type && !game.isFull()) {
                List<Cell> free = game.getFreeCells();
                if (!free.isEmpty()) {
                    Cell move = free.get(rand.nextInt(free.size()));
                    game.makeMove(move.getRow(), move.getCol(), type);
                    game.printBoard();

                    if (game.checkWin(type)) {
                        System.out.println(type + " wins!");
                        game.gameOver = true;
                        return;
                    }
                    game.switchTurn();
                }
            }

            if (game.isFull()) {
                System.out.println("Full Board!");
                game.gameOver = true;
            }
        }
    }
}

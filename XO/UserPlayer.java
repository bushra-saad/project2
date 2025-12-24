
//bushra abu saaad 325998870
//shams alzeadna 214840316
package XO;

import java.util.Scanner;

public class UserPlayer extends Player {

    private Scanner sc = new Scanner(System.in);

    public UserPlayer(PlayerType type, Game game) {
        super(type, game);
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {

            if (game.getTurn() == type && !game.isFull()) {
                boolean ok = false;
                while (!ok) {
                    System.out.println("Enter row (0-4) and col (0-4) for " + type + ":");
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    if (r >= 0 && r < 5 && c >= 0 && c < 5)
                        ok = game.makeMove(r, c, type);
                    if (!ok)
                        System.out.println("Invalid move, try again.");
                }

                game.printBoard();

                if (game.checkWin(type)) {
                    System.out.println(type + " wins!");
                    game.gameOver = true;
                    return;
                }
                game.switchTurn();
            }

            if (game.isFull()) {
                System.out.println("Full Board!");
                game.gameOver = true;
            }
        }
    }
}

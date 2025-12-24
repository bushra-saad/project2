//bushra abu saaad 325998870
//shams alzeadna 214840316
package XO;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    protected char[][] gameBoard = new char[5][5];
    protected PlayerType currentTurn = PlayerType.X;
    protected boolean gameOver = false;

    public Game() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                gameBoard[i][j] = ' ';
    }

    public void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < 4) System.out.print("|");
            }
            System.out.println();
        }
    }

    public PlayerType getTurn() {
        return currentTurn;
    }

    public void switchTurn() {
        currentTurn = (currentTurn == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }

    public List<Cell> getFreeCells() {
        List<Cell> free = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (gameBoard[i][j] == ' ')
                    free.add(new Cell(i, j));
        return free;
    }

    public boolean isFull() {
        return getFreeCells().isEmpty();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean makeMove(int r, int c, PlayerType type) {
        if (gameBoard[r][c] == ' ') {
            gameBoard[r][c] = (type == PlayerType.X) ? 'X' : 'O';
            return true;
        }
        return false;
    }

    public boolean checkWin(PlayerType type) {
        char p = (type == PlayerType.X) ? 'X' : 'O';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 1; j++) {
                if (gameBoard[i][j] == p && gameBoard[i][j + 1] == p &&
                    gameBoard[i][j + 2] == p && gameBoard[i][j + 3] == p)
                    return true;

                if (gameBoard[j][i] == p && gameBoard[j + 1][i] == p &&
                    gameBoard[j + 2][i] == p && gameBoard[j + 3][i] == p)
                    return true;
            }
        }

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (gameBoard[i][j] == p && gameBoard[i + 1][j + 1] == p &&
                    gameBoard[i + 2][j + 2] == p && gameBoard[i + 3][j + 3] == p)
                    return true;

                if (gameBoard[i + 3][j] == p && gameBoard[i + 2][j + 1] == p &&
                    gameBoard[i + 1][j + 2] == p && gameBoard[i][j + 3] == p)
                    return true;
            }
        }
        return false;
    }
}



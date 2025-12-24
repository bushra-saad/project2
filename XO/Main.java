//bushra abu saaad 325998870
//shams alzeadna 214840316
package XO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose mode: 1 = Self vs Self, 2 = User vs Self");
        int mode = sc.nextInt();

        Game game;
        Player p1, p2;

        if(mode == 1){
            game = new SelfGame();
            p1 = new SelfPlayer(PlayerType.X, game);
            p2 = new SelfPlayer(PlayerType.O, game);
        } else {
            game = new UserGame();
            p1 = new UserPlayer(PlayerType.X, game);
            p2 = new SelfPlayer(PlayerType.O, game);
        }

        p1.start();
        p2.start();
    }
}



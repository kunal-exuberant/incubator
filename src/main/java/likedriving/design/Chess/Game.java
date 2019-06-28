package likedriving.design.Chess;

import java.util.Arrays;

public class Game {

    void start() throws InterruptedException{
        Board.initializeTheBoard();
        Board.deployPieces();
        Board.printBoard();

        Player [] players = Players.getPlayers();

        Player player;
        int moveCounter = 1;

        do {
            player = players[(moveCounter + 1) % 2];
            player.play();
            if (moveCounter % 2 == 0) {
                Thread.sleep(500);
            }
            moveCounter++;
        }while(!hasTerminalConditionOccurred(player));
    }

    public static void main(String[] args) {
        try {
            new Game().start();
        }catch (InterruptedException e){
            System.out.println("Game thread interrupted "+ e);
        }
    }

    boolean hasTerminalConditionOccurred(Player player){
        if(player.isCheckMate(getOpponent(player))){
            System.out.println("CHECK MATE");
            System.out.println(player +" won the game");
            return true;
        }
        return false;
    }

    public static Player getOpponent(Player player){
        return Arrays.stream(Players.getPlayers())
              .filter(p -> !p.equals(player)).findFirst().get();
    }
}

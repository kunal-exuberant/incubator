package likedriving.design.Chess;

import org.junit.Test;

public class Game {

    void start(){
        Board.initializeTheBoard();
        Board.deployPieces();
        Board.printBoard();

        Player [] players = Players.getPlayers();
        players[0].play();

/*      while(!checkTerminalCondition()){
            players[0].play();
            System.out.println("Next move");

        }*/
    }


    @Test
    public void startTest(){
        start();
    }

    boolean checkTerminalCondition(Player player){

     /*   switch (){
            case CHECK_MATE:

                break;

            case DRAW:
                break;

            default:
        }*/
        return false;
    }
}

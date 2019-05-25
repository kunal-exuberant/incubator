package likedriving.design.Chess;

import org.junit.Test;

public class Game {

    private Board board;

    void start(){
        board = new Board();
        Player player = new Player(Color.WHITE);
        Player [] players = player.createPlayers();
        player.assignPieces(board);
        board.initializeTheBoard(players);
        players[0].play();

/*        while(!checkTerminalCondition()){

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

package likedriving.design.Chess;

public class Game {

    void start() throws InterruptedException{
        Board.initializeTheBoard();
        Board.deployPieces();
        Board.printBoard();

        Player [] players = Players.getPlayers();

        int moveCounter = 1;
        while(checkTerminalCondition()){
            players[(moveCounter+1) %2].play();
            if(moveCounter%2 == 0){
                Thread.sleep(3000);
            }
            moveCounter++;
        }
    }

    public static void main(String[] args) {
        try {
            new Game().start();
        }catch (InterruptedException e){
            System.out.println("Game thread interrupted "+ e);
        }
    }

    boolean checkTerminalCondition(){

     /*   switch (){
            case CHECK_MATE:

                break;

            case DRAW:
                break;

            default:
        }*/
        return true;
    }
}

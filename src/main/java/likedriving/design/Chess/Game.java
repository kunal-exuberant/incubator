package likedriving.design.Chess;

public class Game {

    private Piece [] pieces = new Piece[32];

    void start(){
        Player player1 = new Player(Color.WHITE);
        Player player2 = new Player(Color.BLACK);

        player1.play();

/*        while(!checkTerminalCondition()){

            System.out.println("Next move");

        }*/
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

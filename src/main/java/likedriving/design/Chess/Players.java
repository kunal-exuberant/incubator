package likedriving.design.Chess;
import org.junit.Test;

public class Players {

    private static Player [] players = new Player[2];

    public static Player[] getPlayers(){
        if(players[0] == null || players[1] == null) {
            players[0] = new Player(Color.WHITE);
            players[1] = new Player(Color.BLACK);
        }
        return players;
    }

    @Test
    public void printPlayerPosition(){
        Player [] players = getPlayers();
        System.out.println("\nPlayer 1 piece deployement\n");
        players[0].printMyPiecesPosition();
        System.out.println("\nPlayer 2 piece deployement\n");
        players[1].printMyPiecesPosition();
    }
}

package likedriving.design.Chess;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Player {
    private String id;
    Color color;

    Map<PieceType, List<Piece>> pieces = new HashMap<>();

    Player(Color color){
        this.color = color;
        assignPieces();
    }

    private void assignPieces(){
            pieces.put(PieceType.ROOK, Arrays.asList(new Rook(color), new Rook(color)));
            pieces.put(PieceType.KNIGHT, Arrays.asList(new Knight(color), new Knight(color)));
            pieces.put(PieceType.BISHOP, Arrays.asList(new Bishop(color), new Bishop(color)));
            pieces.put(PieceType.QUEEN, Arrays.asList(new Queen(color)));
            pieces.put(PieceType.KING, Arrays.asList(new King(color)));
            pieces.put(PieceType.PAWN, Arrays.asList(new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color),
                    new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color)));
    }

    public void printMyPiecesPosition(){

        for(Map.Entry<PieceType, List<Piece>> pieceEntry: pieces.entrySet()){
            for(Piece piece : pieceEntry.getValue()) {
                System.out.println(piece);
            }
        }

    }

    void play(){
        System.out.println("Playing ...");
    }

    @Test
    public void printPlayerPosition(){
        Player [] players = new Player[2];
        players[0] = new Player(Color.BLACK);
        players[1] = new Player(Color.WHITE);
        Board board = new Board();
        board.initializeTheBoard(players);

        System.out.println("Player 1 piece deployement\n");
        players[0].printMyPiecesPosition();
        System.out.println("Player 2 piece deployement\n");
        players[1].printMyPiecesPosition();

        ///board.printBoard();
    }
}

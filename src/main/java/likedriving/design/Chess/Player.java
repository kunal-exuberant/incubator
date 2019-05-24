package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

@Data
@NoArgsConstructor
public class Player {
    private String id;
    Color color;

    Player(Color color){
        this.color = color;
        assignPieces();
    }


    private Map<PieceType, List<Piece>> myPieces = new HashMap<>();
    //private Piece [] pieces = new Piece[32];

    private void assignPieces(){
        myPieces.put(PieceType.ROOK, Arrays.asList(new Rook(color), new Rook(color)));
        myPieces.put(PieceType.KNIGHT, Arrays.asList(new Knight(color), new Knight(color)));
        myPieces.put(PieceType.BISHOP, Arrays.asList(new Bishop(color), new Bishop(color)));
        myPieces.put(PieceType.QUEEN, Arrays.asList(new Queen(color)));
        myPieces.put(PieceType.KING, Arrays.asList(new King(color)));
        myPieces.put(PieceType.PAWN, Arrays.asList(new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color),
                new Pawn(color), new Pawn(color), new Pawn(color), new Pawn(color)));
    }

    public void printMyPiecesPosition(){

        for(Map.Entry<PieceType, List<Piece>> pieceEntry: myPieces.entrySet()){
            for(Piece piece : pieceEntry.getValue()) {
                System.out.println(piece);
            }
        }
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

    void play(){

        System.out.println("Playing ...");
        selectPiece().move();
    }

    public List<Piece> eligibleToMove(){

        List<Piece> eligibleAttackers = new ArrayList<>();
        for(Map.Entry<PieceType, List<Piece>> pieceList: myPieces.entrySet()){
            for(Piece piece: pieceList.getValue()){
                if(piece.canAttack()){
                    eligibleAttackers.add(piece);
                }
            }
        }
        return eligibleAttackers;
    }

    // Randomly select one piece out of many pieces to move
    public Piece selectPiece(){
        List<Piece> eligiblePieces = this.eligibleToMove();
        Random random = new Random();
        return eligiblePieces.get(random.nextInt(eligiblePieces.size()));
    }
}

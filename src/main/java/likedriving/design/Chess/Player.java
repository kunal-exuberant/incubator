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
    private Color color;
    private Board board;
    private Player [] players = new Player[2];

    Player(Color color){
        this.color = color;
    }

    Player(Color color, Board board){
        this.color = color;
        this.board = board;
    }


    private Map<PieceType, List<Piece>> myPieces = new HashMap<>();
    //private Piece [] pieces = new Piece[32];

    public void assignPieces(Board board){
        myPieces.put(PieceType.ROOK, Arrays.asList(new Rook(color, board), new Rook(color, board)));
        myPieces.put(PieceType.KNIGHT, Arrays.asList(new Knight(color, board), new Knight(color, board)));
        myPieces.put(PieceType.BISHOP, Arrays.asList(new Bishop(color, board), new Bishop(color, board)));
        myPieces.put(PieceType.QUEEN, Arrays.asList(new Queen(color, board)));
        myPieces.put(PieceType.KING, Arrays.asList(new King(color, board)));
        myPieces.put(PieceType.PAWN, Arrays.asList(new Pawn(color, board), new Pawn(color, board), new Pawn(color, board), new Pawn(color, board),
                new Pawn(color, board), new Pawn(color, board), new Pawn(color, board), new Pawn(color, board)));
    }

    public void printMyPiecesPosition(){

        for(Map.Entry<PieceType, List<Piece>> pieceEntry: myPieces.entrySet()){
            for(Piece piece : pieceEntry.getValue()) {
                System.out.println(piece);
            }
        }
    }

    public Player[] createPlayers(){
        if(players[0] != null && players[1] != null) {
            return players;
        }
        else {
            players[0] = new Player(Color.WHITE, board);
            players[1] = new Player(Color.BLACK, board);
            return players;
        }
    }

    @Test
    public void printPlayerPosition(){
        Board board = new Board();
        Player [] players = createPlayers();
        board.initializeTheBoard(createPlayers());

        System.out.println("\nPlayer 1 piece deployement\n");
        players[0].printMyPiecesPosition();
        System.out.println("\nPlayer 2 piece deployement\n");
        players[1].printMyPiecesPosition();

        board.printBoard();
    }

    void play(){

        System.out.println("Playing ...");
        selectPiece().move();
    }

    public List<Piece> eligibleToMove(){

        List<Piece> eligibleAttackers = new ArrayList<>();
        for(Map.Entry<PieceType, List<Piece>> pieceList: myPieces.entrySet()){
            for(Piece piece: pieceList.getValue()){
                if(piece.canAttack(board)){
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

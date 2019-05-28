package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.Piece;
import likedriving.design.Chess.Pieces.PieceKey;
import likedriving.design.Chess.Pieces.PieceStore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@NoArgsConstructor
public class Player {
    private String id;
    private Color color;
    private Player [] players = new Player[2];

    public Player(Color color){
        this.color = color;
    }

    public List<Piece> getMyPieces(){
        List<Piece> myPieces = new ArrayList<>();
        for (Map.Entry<PieceKey, List<Piece>> pieceEntry : PieceStore.getPieceMap().entrySet()) {
            if (pieceEntry.getKey().getColor() == getColor()) {
                for (Piece piece : pieceEntry.getValue()) {
                    myPieces.add(piece);
                }
            }
        }
        return myPieces;
    }

    public void printMyPiecesPosition() {
        for (Piece piece : getMyPieces()) {
            System.out.println(piece);
        }
    }

    void play(){
        System.out.println("Playing ...");
        selectPiece().move();
    }

    public List<Piece> eligibleToMove(){
        List<Piece> eligibleAttackers = new ArrayList<>();
            for(Piece piece: getMyPieces()){
                if(piece.canAttack()){
                    eligibleAttackers.add(piece);
                }
            }
        return eligibleAttackers;
    }

    // Randomly select one piece out of many pieces to move
    public Piece selectPiece(){
        List<Piece> eligiblePieces = eligibleToMove();
        Random random = new Random();
        return eligiblePieces.get(random.nextInt(eligiblePieces.size()));
    }
}

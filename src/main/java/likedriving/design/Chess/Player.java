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
        List<Piece> myCapturedPieces = new ArrayList<>();
        for (Map.Entry<PieceKey, List<Piece>> pieceEntry : PieceStore.getPieceMap().entrySet()) {
            if (pieceEntry.getKey().getColor() == getColor()) {
                for (Piece piece : pieceEntry.getValue()) {
                    if(!piece.isCaptured()) {
                        myPieces.add(piece);
                    }else {
                        myCapturedPieces.add(piece);
                    }

                }
            }
        }
        if(myCapturedPieces.size() > 0) {
            System.out.print("My " + myCapturedPieces.size() + " pieces captured: ");
            myCapturedPieces.forEach(p -> System.out.print(p.getPieceType() + "-" + p.getId()+", "));
        }
        return myPieces;
    }

    public void printMyPiecesPosition() {
        for (Piece piece : getMyPieces()) {
            System.out.println(piece);
        }
    }

    void play(){
        System.out.println("\n\n"+color +" is playing ...");
        //System.out.println("Lost: "+ (16 - getMyPieces().size()) + " pieces");
        Piece selectedPiece = selectPiece();
        if(selectedPiece != null){
            System.out.print("\n"+selectedPiece.getPieceType() + "-"+selectedPiece.getId()+" "+" is attacking");
            System.out.print(" from " + selectedPiece.getCurrentPosition());
            selectedPiece.move();
        }else{
            System.out.println("No piece selected to attack");
        }
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
        try {
            Random random = new Random();
            return eligiblePieces.get(random.nextInt(eligiblePieces.size()));
        }
        catch (IllegalArgumentException e){
            if(eligiblePieces.size() == 0) {
                System.out.println(color +" has no pieces to move");
            }else {
                System.out.println("Unable to select eligible pieces");
            }
            return null;
        }
    }
}

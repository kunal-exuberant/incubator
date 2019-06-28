package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.Piece;
import likedriving.design.Chess.Pieces.PieceKey;
import likedriving.design.Chess.Pieces.PieceStore;
import likedriving.design.Chess.Pieces.PieceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Player {
    private String id;
    private Color color;

    public Player(Color color){
        this.color = color;
    }

    public boolean isCheckMate(Player opponent){
        if(isMyKingBeUnderThreat(opponent)){
            List<Piece> myPieces = getMyPieces().stream()
                    .filter(piece -> piece.canAttack()).collect(Collectors.toList());

            for(Piece piece: myPieces){
                for(Cell newCell: piece.getPossibleMoves()){
                    Board.storeLastState();
                    if(!newCell.isAvailable()) {
                        Utils.logPieceStatus(newCell.getPiecePlaced());
                    }
                    piece.logUpdatedPosition(newCell);
                    if(!isMyKingBeUnderThreat(opponent)){
                        System.out.println("King is saved, Not a checkmate");
                        return false;
                    }
                    else {
                        System.out.println("King is still under threat, reverting to old position, " +
                                "will try other moves");
                        Board.undoLastMove();
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean isMyKingBeUnderThreat(Player opponent){
        if(getMyKing().isPresent()) {
            return opponentCanCapture(opponent, getMyKing().get().getCurrentPosition());
        }
        System.out.println("Illegal Game: King not present in the game, should have been terminated");
        return false;
    }

    private Optional<Piece> getMyKing(){
        return getMyPieces().stream().filter(piece -> piece.getPieceType() == PieceType.KING).findFirst();
    }

    private boolean opponentCanCapture(Player opponent, Position myKingsPosition){
        List<Piece> opponentPieces = opponent.getMyPieces();
        for(Piece piece: opponentPieces) {
            if(piece.canMoveTo(myKingsPosition)){
                return true;
            }
        }
        return false;
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

        while (true) {
            Piece selectedPiece = selectPiece();
            if (selectedPiece != null) {
                System.out.print("\n" + selectedPiece.getPieceType() + "-" + selectedPiece.getId() + " " + " is attacking");
                System.out.print(" from " + selectedPiece.getCurrentPosition());

                Board.storeLastState();
                selectedPiece.move();

                if (isMyKingBeUnderThreat(Game.getOpponent(this))) {
                    System.out.println("King is still under threat, reverting my move, " +
                            "will try other moves");
                    Board.undoLastMove();
                }
                else {
                    System.out.println("Piece moved");
                    break;
                }
            } else {
                System.out.println("No piece selected to attack");
                break;
            }
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

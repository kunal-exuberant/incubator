package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;
import likedriving.design.Chess.Navigation;

import static likedriving.design.Chess.Utils.logPieceStatus;

public class King extends Piece{

    private Cell nextCell = null;
    private Cell previousCell =  null;
    private Cell leftCell =  null;
    private Cell rightCell =  null;

    private Cell diagonalLeftCell = null;
    private Cell diagonalRightCell =  null;
    private Cell diagonalLeftBackCell =  null;
    private Cell diagonalRightBackCell =  null;

    public King(Color color){
        super(PieceType.KING, color);
    }

    @Override
    protected Direction[] myMoveOrder(){
        Direction [] directions = {Direction.NEXT, Direction.DIAGONAL_LEFT, Direction.LEFT, Direction.RIGHT, Direction.DIAGONAL_RIGHT,
                Direction.DIAGONAL_LEFT_BACK,Direction.DIAGONAL_RIGHT_BACK, Direction.PREVIOUS};
        return directions;
    }

    @Override
    public boolean canAttack() {
        nextCell = Navigation.next(getCurrentPosition(), getDirectionOfAttack());
        previousCell = Navigation.previous(getCurrentPosition(), getDirectionOfAttack());
        leftCell = Navigation.left(getCurrentPosition(), getDirectionOfAttack());
        rightCell = Navigation.right(getCurrentPosition(), getDirectionOfAttack());

        diagonalLeftCell = Navigation.diagonalLeft(getCurrentPosition(), getDirectionOfAttack());
        diagonalRightCell = Navigation.diagonalRight(getCurrentPosition(), getDirectionOfAttack());
        diagonalLeftBackCell = Navigation.diagonalLeftBack(getCurrentPosition(), getDirectionOfAttack());
        diagonalRightBackCell = Navigation.diagonalRightBack(getCurrentPosition(), getDirectionOfAttack());

        return canAttackHere(nextCell) || canAttackHere(diagonalLeftCell) ||
                canAttackHere(previousCell) || canAttackHere(diagonalRightCell) || canAttackHere(diagonalLeftBackCell) ||
                canAttackHere(leftCell) || canAttackHere(rightCell) || canAttackHere(diagonalRightBackCell);

    }

    @Override
    public void move() {
        Cell tempCell = null;
        boolean ownPiece = false;

        Cell updatedCell = null;

        for(int i=0; i<myMoveOrder().length; i++){
            tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], getCurrentPosition());
            if(tempCell != null) {
                if (canCapture(tempCell)) {
                    if (tempCell.isAvailable()) {
                        updatedCell = tempCell;
                    } else {
                        ownPiece = true;
                        break;
                    }
                }
                if (!ownPiece && tempCell != null && !tempCell.isAvailable()) {
                    Piece capturedPiece = tempCell.getPiecePlaced();
                    logUpdatedPosition(tempCell);
                    logPieceStatus(capturedPiece);
                    break;
                }
                else{
                    if(i == myMoveOrder().length -1 && updatedCell!= null){
                        logUpdatedPosition(updatedCell);
                    }
                    else {
                        System.out.println("Should capture last known position which was different from my current position");
                    }
                }
            }
            else {
                if(i == myMoveOrder().length -1 && updatedCell != null){
                    logUpdatedPosition(updatedCell);
                }
                else {
                    System.out.println("Location not found on board");
                }
            }
        }
    }
}

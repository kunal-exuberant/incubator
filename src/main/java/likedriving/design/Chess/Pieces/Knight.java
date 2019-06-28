package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;
import likedriving.design.Chess.Navigation;

import static likedriving.design.Chess.Utils.logPieceStatus;

public class Knight extends Piece{

    private Cell jumpUpLeftCell = null;
    private Cell jumpUpRightCell = null;
    private Cell jumpLeftUpCell = null;
    private Cell jumpRightUpCell = null;
    private Cell jumpLeftDownCell = null;
    private Cell jumpRightDownCell = null;
    private Cell jumpDownLeftCell = null;
    private Cell jumpDownRightCell = null;

    public Knight(Color color){
        super(PieceType.KNIGHT, color);
    }

    @Override
    protected Direction[] myMoveOrder(){
        Direction [] directions = {Direction.JUMP_UP_LEFT, Direction.JUMP_UP_RIGHT, Direction.JUMP_LEFT_UP, Direction.JUMP_RIGHT_UP,
                Direction.JUMP_LEFT_DOWN, Direction.JUMP_RIGHT_DOWN, Direction.JUMP_DOWN_LEFT, Direction.JUMP_DOWN_RIGHT};
        return directions;
    }

    @Override
    public boolean canAttack() {
        jumpUpLeftCell = Navigation.jumpUpLeftPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpUpRightCell = Navigation.jumpUpRightPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpLeftUpCell = Navigation.jumpLeftUpPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpRightUpCell = Navigation.jumpRightUpPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpLeftDownCell = Navigation.jumpLeftDownPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpRightDownCell = Navigation.jumpRightDownPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpDownLeftCell = Navigation.jumpDownLeftPosition(getCurrentPosition(), getDirectionOfAttack());
        jumpDownRightCell = Navigation.jumpDownRightPosition(getCurrentPosition(), getDirectionOfAttack());
        return canAttackHere(jumpUpLeftCell) || canAttackHere(jumpUpRightCell) || canAttackHere(jumpLeftUpCell)
                || canAttackHere(jumpRightUpCell) || canAttackHere(jumpLeftDownCell) || canAttackHere(jumpRightDownCell)
                || canAttackHere(jumpDownLeftCell) || canAttackHere(jumpDownRightCell);
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

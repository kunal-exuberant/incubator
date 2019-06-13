package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;
import likedriving.design.Chess.Navigation;

public class Bishop extends Piece{

    private Cell diagonalLeftCell = null;
    private Cell diagonalRightCell =  null;
    private Cell diagonalLeftBackCell =  null;
    private Cell diagonalRightBackCell =  null;

    public Bishop(Color color){
        super(PieceType.BISHOP, color);
    }

    @Override
    protected Direction[] myMoveOrder() {
        Direction [] directions = {Direction.DIAGONAL_LEFT, Direction.DIAGONAL_RIGHT,
                Direction.DIAGONAL_LEFT_BACK, Direction.DIAGONAL_RIGHT_BACK};
        return directions;
    }

    @Override
    public boolean canAttack() {
        //return false;
        diagonalLeftCell = Navigation.diagonalLeft(getCurrentPosition(), getDirectionOfAttack());
        diagonalRightCell = Navigation.diagonalRight(getCurrentPosition(), getDirectionOfAttack());
        diagonalLeftBackCell = Navigation.diagonalLeftBack(getCurrentPosition(), getDirectionOfAttack());
        diagonalRightBackCell = Navigation.diagonalRightBack(getCurrentPosition(), getDirectionOfAttack());
        return canAttackHere(diagonalLeftCell) || canAttackHere(diagonalRightCell) || canAttackHere(diagonalLeftBackCell) || canAttackHere(diagonalRightBackCell);
    }
}

package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;
import likedriving.design.Chess.Navigation;

public class Queen extends Piece{

    private Cell nextCell = null;
    private Cell previousCell =  null;
    private Cell leftCell =  null;
    private Cell rightCell =  null;

    private Cell diagonalLeftCell = null;
    private Cell diagonalRightCell =  null;
    private Cell diagonalLeftBackCell =  null;
    private Cell diagonalRightBackCell =  null;

    public Queen(Color color){
        super(PieceType.QUEEN, color);
    }

    @Override
    protected Direction[] myMoveOrder() {
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
}

package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;

public class Queen extends Piece{

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
        return false;
    }

    @Override
    public void move() {

    }
}

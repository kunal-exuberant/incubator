package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;

public class King extends Piece{

    public King(Color color){
        super(PieceType.KING, color);
    }

    @Override
    protected Direction[] myMoveOrder(){
        Direction [] directions = {Direction.NEXT, Direction.LEFT, Direction.RIGHT, Direction.PREVIOUS};
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

package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;

public class Knight extends Piece{

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
        return false;
    }

    @Override
    public void move() {

    }
}

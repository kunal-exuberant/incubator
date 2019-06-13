package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;

public class Bishop extends Piece{

    public Bishop(Color color){
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

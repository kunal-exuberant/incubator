package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;

public class Knight extends Piece{

    public Knight(Color color){
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

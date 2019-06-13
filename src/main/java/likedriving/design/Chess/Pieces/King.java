package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;

public class King extends Piece{

    public King(Color color){
        super(PieceType.KING, color);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;

public class Queen extends Piece{

    public Queen(Color color){
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

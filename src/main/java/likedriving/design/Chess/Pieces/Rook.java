package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

public class Rook extends Piece{

    public Rook(Color color){
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

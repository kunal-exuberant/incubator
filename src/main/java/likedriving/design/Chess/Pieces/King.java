package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;

public class King extends Piece{

    public King(Color color){
        super(PieceType.KING, color);
    }

    @Override
    public boolean canMoveTo(Position nextPosition) {
        return false;
    }

    @Override
    public void computePossibleNextPositions(Position position) {

    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void move() {

    }
}

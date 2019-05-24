package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;

public class Queen extends Piece{

    public Queen(Color color){
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean canMoveTo(Position nextPosition) {
        return false;
    }

    @Override
    public void computePossibleNextPositions(Position position) {

    }
}
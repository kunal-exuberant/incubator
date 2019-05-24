package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Board;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;

public class Bishop extends Piece{

    public Bishop(Color color, Board board){
        super(PieceType.BISHOP, color, board);
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
}

package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Board;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;

public class King extends Piece{

    public King(Color color, Board board){
        super(PieceType.KING, color, board);
    }

    @Override
    public boolean canMoveTo(Position nextPosition) {
        return false;
    }

    @Override
    public void computePossibleNextPositions(Position position) {

    }

    @Override
    public boolean canAttack(Board board) {
        return false;
    }

    @Override
    public void move() {

    }
}

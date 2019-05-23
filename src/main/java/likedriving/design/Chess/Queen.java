package likedriving.design.Chess;

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

package likedriving.design.Chess;

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
}

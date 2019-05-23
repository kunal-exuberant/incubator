package likedriving.design.Chess;

public class Knight extends Piece{

    public Knight(Color color){
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean canMoveTo(Position nextPosition) {
        return false;
    }

    @Override
    public void computePossibleNextPositions(Position position) {

    }
}

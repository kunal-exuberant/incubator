package likedriving.design.Chess;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean canMoveTo(Position nextPosition) {
        Board board = new Board();
        Cell nextCell = board.getCell(nextPosition);
        Position currentPosition = this.getCurrentPosition();
        if(isMyPiecePresent(nextCell)){
            return false;
        }
        else if(nextCell.isAvailable() && nextPosition.getY() == currentPosition.getY()+1
                && nextPosition.getX() == nextPosition.getX()){
            return true;
        }
        return true;
    }

    @Override
    public void computePossibleNextPositions(Position position) {

    }
}

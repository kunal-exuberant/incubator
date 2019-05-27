package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

public class Rook extends Piece{

    public Rook(Color color){
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean canMoveTo(Position nextPosition){

        Board board = new Board();

        Cell nextCell = board.getCell(nextPosition);

        Position currentPosition = this.getCurrentPosition();

        if(!(nextPosition.getX() == currentPosition.getY() || nextPosition.getY() == currentPosition.getX())){
            return false;
        }
        else if(!nextCell.isAvailable() && nextCell.getPiecePlaced().getColor() == this.getColor()){
            return false;
        }
        return true;
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

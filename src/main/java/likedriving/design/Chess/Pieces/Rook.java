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
    public boolean canAttack() {

/*        if (Navigation.next(getCurrentPosition(), getDirectionOfAttack()) != null
                && getNavigation().next().isAvailable() || isOpponent(getNavigation().next().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().previous() != null
                && getNavigation().previous().isAvailable() || isOpponent(getNavigation().previous().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().left() != null
                && getNavigation().left().isAvailable() || isOpponent(getNavigation().left().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().right() != null
                && getNavigation().right().isAvailable() || isOpponent(getNavigation().right().getPiecePlaced())) {
            return true;
        }else {
            //Use Logger to log the error
            System.out.println("Error in deciding can attack, bz this pieces has reached a position from where it cannot move.");
            return false;
        }*/
        return false;
    }

    @Override
    public void move() {
        Cell newCell = null;
        Piece capturedPiece = null;

        Cell tempCell = Navigation.next(getCurrentPosition(), getDirectionOfAttack());

        if(tempCell != null) {

            Cell nextCell = Navigation.next(tempCell.getPosition(), getDirectionOfAttack());

            while (tempCell.isAvailable() && nextCell != null) {
                tempCell = nextCell;
                nextCell = Navigation.next(nextCell.getPosition(), getDirectionOfAttack());
            }

            if (!tempCell.isAvailable() && isOpponent(tempCell.getPiecePlaced())) {
                newCell = tempCell;
            }else if(!isOpponent(tempCell.getPiecePlaced())){
                //newCell =
            }
        }

/*                && getNavigation().next().isAvailable() || isOpponent(getNavigation().next().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().previous() != null
                && getNavigation().previous().isAvailable() || isOpponent(getNavigation().previous().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().left() != null
                && getNavigation().left().isAvailable() || isOpponent(getNavigation().left().getPiecePlaced())) {
            return true;
        }
        else if (getNavigation().right() != null
                && getNavigation().right().isAvailable() || isOpponent(getNavigation().right().getPiecePlaced())) {
            return true;
        }else {
            //Use Logger to log the error
            System.out.println("Error in deciding can attack, bz this pieces has reached a position from where it cannot move.");
            return false;
        }*/
    }
}

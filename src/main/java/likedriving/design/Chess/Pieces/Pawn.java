package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

import java.util.Optional;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean canAttack() {

        if (getNavigation().nextPosition().isAvailable()) {
            return true;
        }
        else if (isOpponent((getNavigation().nextLeftPosition()).getPiecePlaced())){
            return true;
        }
        else if (isOpponent((getNavigation().nextRightPosition()).getPiecePlaced())) {
            return true;
        }
        else {
            //Use Logger to log the error
            System.out.println("Error case in deciding can attack");
        }
        return false;
    }

    @Override
    public void move() {
        System.out.println(this.getPieceType()+" "+"is moving unit distance");
        Cell newCell = null;
        Piece capturedPiece;


            if ((getNavigation().nextLeftPosition()).getPiecePlaced() != null
                    && isOpponent(getNavigation().nextLeftPosition().getPiecePlaced())) {
                newCell = getNavigation().nextLeftPosition();
            } else if ((getNavigation().nextRightPosition()).getPiecePlaced() != null
                    && isOpponent((getNavigation().nextRightPosition()).getPiecePlaced())) {
                newCell = getNavigation().nextRightPosition();
            } else if (getNavigation().nextPosition().isAvailable()) {
                newCell = getNavigation().nextPosition();
            } else {
                System.out.println("Error case in deciding can attack");
            }

            if (Optional.ofNullable(newCell).isPresent()) {
                this.setCurrentCell(newCell);
                newCell.setPiecePlaced(this);
                // Add the logic of Captured piece if moved to an opponent cell
            }
        }
}
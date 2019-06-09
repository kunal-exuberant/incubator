package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

import java.util.Optional;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(PieceType.PAWN, color);
    }

    @Override
    public Direction[] myMoveOrder() {
        Direction [] directions = {Direction.NEXT, Direction.LEFT, Direction.RIGHT, Direction.PREVIOUS};
        return directions;
    }

    @Override
    public boolean canAttack() {

        if (Navigation.next(getCurrentPosition(), getDirectionOfAttack()) != null && Navigation.next(getCurrentPosition(), getDirectionOfAttack()).isAvailable()) {
            return true;
        }
        else if (Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack())!= null && isOpponent((Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack())).getPiecePlaced())){
            return true;
        }
        else if (Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack()) != null && isOpponent((Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack())).getPiecePlaced())) {
            return true;
        }
        else {
            //Use Logger to log the error
            System.out.println("Error in deciding can attack, bz this pieces has reached a position from where it cannot move.");
            return false;
        }
    }

    @Override
    public void move() {
        //System.out.println(this.getPieceType()+ ": "+ this.getId() +" "+"is moving unit distance");
        Cell newCell = null;
        Piece capturedPiece = null;

        if (Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack()) != null && (Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack())).getPiecePlaced() != null
                && isOpponent(Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack()).getPiecePlaced())) {
            newCell = Navigation.nextLeftPosition(getCurrentPosition(), getDirectionOfAttack());
            capturedPiece = newCell.getPiecePlaced();
        }
        else if (Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack()) != null && (Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack())).getPiecePlaced() != null
                && isOpponent((Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack())).getPiecePlaced())) {
            newCell = Navigation.nextRightPosition(getCurrentPosition(), getDirectionOfAttack());
            capturedPiece = newCell.getPiecePlaced();
        }
        else if (Navigation.next(getCurrentPosition(), getDirectionOfAttack()) != null && Navigation.next(getCurrentPosition(), getDirectionOfAttack()).isAvailable()) {
            newCell = Navigation.next(getCurrentPosition(), getDirectionOfAttack());
        } else {
            System.out.println("Error case in deciding can attack");
        }

        if (Optional.ofNullable(newCell).isPresent()) {
            System.out.print("to "+newCell.getPosition());
            Board.getCell(this.getCurrentPosition()).setPiecePlaced(null);
            Board.getCell(this.getCurrentPosition()).setAvailable(true);

            this.setCurrentPosition(newCell.getPosition());
            newCell.setPiecePlaced(this);
            // Add the logic of Captured piece if moved to an opponent cell
        }
        if(capturedPiece != null){
            capturedPiece.setCaptured(true);
            System.out.println(" and has captured "+ capturedPiece.getPieceType()+"-"+capturedPiece.getId());
        }
    }
}
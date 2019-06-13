package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

import java.util.Optional;

public class Pawn extends Piece{

    private Cell next = null;
    private Cell diagonalLeft = null;
    private Cell diagonalRight = null;

    public Pawn(Color color){
        super(PieceType.PAWN, color);
    }

    @Override
    public Direction[] myMoveOrder() {
        Direction [] directions = {Direction.DIAGONAL_LEFT, Direction.DIAGONAL_RIGHT}; //Not adding Direction.NEXT
        return directions;
    }

    @Override
    protected boolean canAttackHere(Cell cell){
        return cell != null && isOpponent(cell.getPiecePlaced());
    }

    protected boolean canMoveHere(Cell cell){
        return cell != null && cell.isAvailable();
    }

    @Override
    public boolean canAttack() {

        next = Navigation.next(getCurrentPosition(), getDirectionOfAttack());
        diagonalLeft = Navigation.diagonalLeft(getCurrentPosition(), getDirectionOfAttack());
        diagonalRight = Navigation.diagonalRight(getCurrentPosition(), getDirectionOfAttack());
        return canMoveHere(next) || canAttackHere(diagonalLeft) || canAttackHere(diagonalRight);
    }

    @Override
    public void move() {
        //System.out.println(this.getPieceType()+ ": "+ this.getId() +" "+"is moving unit distance");
        Cell newCell = null;
        Piece capturedPiece = null;

        for(int i=0; i< myMoveOrder().length; i++) {

            Cell tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], getCurrentPosition());

            if (tempCell != null && isOpponent(tempCell.getPiecePlaced())) {
                newCell = tempCell;
                capturedPiece = newCell.getPiecePlaced();
                break;
            }
        }

        if(newCell == null) {
            Cell tempCell = navigateOneStepInMyDirection(Direction.NEXT, getCurrentPosition());
            if(tempCell != null && tempCell.isAvailable()){
                newCell = tempCell;
            }else {
                System.out.println("Error case in deciding can attack");
            }
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
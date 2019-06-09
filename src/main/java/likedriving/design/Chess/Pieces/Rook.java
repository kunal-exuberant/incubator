package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Direction;
import likedriving.design.Chess.Navigation;

public class Rook extends Piece{

    private Cell nextCell = null;
    private Cell previousCell =  null;
    private Cell leftCell =  null;
    private Cell rightCell =  null;

    public Rook(Color color){
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean canAttack() {
        nextCell = Navigation.next(getCurrentPosition(), getDirectionOfAttack());
        previousCell = Navigation.previous(getCurrentPosition(), getDirectionOfAttack());
        leftCell = Navigation.left(getCurrentPosition(), getDirectionOfAttack());
        rightCell = Navigation.right(getCurrentPosition(), getDirectionOfAttack());
        return canAttackHere(nextCell) || canAttackHere(previousCell) || canAttackHere(leftCell) || canAttackHere(rightCell);
      }

    @Override
    protected Direction [] myMoveOrder(){
        Direction [] directions = {Direction.NEXT, Direction.LEFT, Direction.RIGHT, Direction.PREVIOUS};
        return directions;
    }
}

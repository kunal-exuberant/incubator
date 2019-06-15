package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;

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

    public boolean canMoveTo(Position position){

        if(getCurrentPosition().getY() != position.getY()
                && getCurrentPosition().getX() != position.getX()){
            return false;
        }

        boolean reached = false;
        if (getCurrentPosition().getX() == position.getX()) {

            Direction [] possibleDirections = {Direction.LEFT, Direction.RIGHT};
            reached = reachedPosition(position, possibleDirections);
        }
        else if(getCurrentPosition().getY() == position.getY()){
            Direction [] possibleDirections = {Direction.NEXT, Direction.PREVIOUS};
            reached = reachedPosition(position, possibleDirections);
        }else {
            System.out.println("unexpected case: (can move to)");
        }
        return reached;
    }

    private boolean reachedPosition(Position position, Direction [] possibleDirections){

        for(Direction direction: possibleDirections) {

            System.out.println("Both are on same horizontal line");
            Cell tempCell = navigateOneStepInMyDirection(direction, getCurrentPosition());
            while (tempCell != null && tempCell.isAvailable()
                    && !tempCell.getPosition().equals(position)) {
                tempCell = navigateOneStepInMyDirection(direction, tempCell.getPosition());
            }
            if (tempCell != null && tempCell.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}

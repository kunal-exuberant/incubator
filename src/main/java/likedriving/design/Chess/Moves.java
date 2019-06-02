package likedriving.design.Chess;

public interface Moves {



    Cell nextRightPosition(Position currentPosition, DirectionOfAttack direction);

    Cell nextLeftPosition(Position currentPosition, DirectionOfAttack direction);


    Cell next(Position currentPosition, DirectionOfAttack direction);
    Cell previous(Position currentPosition, DirectionOfAttack direction);

    Cell left(Position currentPosition, DirectionOfAttack direction);
    Cell right(Position currentPosition, DirectionOfAttack direction);

/*


    Cell diagonalLeft(Position currentPosition, DirectionOfAttack direction));
    Cell diagonalRight(Position currentPosition, DirectionOfAttack direction));

    Cell diagonalLeftBack(Position currentPosition, DirectionOfAttack direction));
    Cell diagonalRightBack(Position currentPosition, DirectionOfAttack direction));


    //With jump
    Cell jumpUptLeft(Position currentPosition, DirectionOfAttack direction));
    Cell jumpUpRight(Position currentPosition, DirectionOfAttack direction));
    Cell jumpDownLeft(Position currentPosition, DirectionOfAttack direction));
    Cell jumpDownRight(Position currentPosition, DirectionOfAttack direction));

    Cell jumpLeftUp(Position currentPosition, DirectionOfAttack direction));
    Cell jumpLeftDown(Position currentPosition, DirectionOfAttack direction));

    Cell jumpRightUp(Position currentPosition, DirectionOfAttack direction));
    Cell jumpRightDown(Position currentPosition, DirectionOfAttack direction));*/


}

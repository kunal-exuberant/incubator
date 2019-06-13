package likedriving.design.Chess;
import java.util.logging.Logger;

public class Navigation{

    public static Cell next(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY());
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY());
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell previous(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY());
            case DECREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY());
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell left(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX(), currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX(), currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell diagonalLeft(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell diagonalLeftBack(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell diagonalRightBack(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell diagonalRight(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell right(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX(), currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX(), currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell nextRightPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell nextLeftPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpUpLeftPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+2, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-2, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpUpRightPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+2, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-2, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpDownLeftPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-2, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+2, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpDownRightPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-2, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+2, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpLeftUpPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()-2);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()+2);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpRightUpPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()+2);
            case DECREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()-2);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpLeftDownPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()-2);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()+2);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    public static Cell jumpRightDownPosition(Position currentPosition, DirectionOfAttack direction) {

        switch (direction) {
            case INCREASING:
                return Board.getCell(currentPosition.getX()-1, currentPosition.getY()+2);
            case DECREASING:
                return Board.getCell(currentPosition.getX()+1, currentPosition.getY()-2);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }


}

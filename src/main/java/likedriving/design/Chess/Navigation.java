package likedriving.design.Chess;
import likedriving.design.Chess.Pieces.Piece;

import java.util.logging.Logger;

public class Navigation implements Moves{

    private Piece piece;

    public Navigation(Piece piece){
        this.piece = piece;
    }

    @Override
    public Cell nextPosition() {
        Position currentPosition = piece.getCurrentPosition();

        switch (piece.getDirectionOfAttack()) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY());
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY());
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    @Override
    public Cell nextRightPosition() {
        Position currentPosition = piece.getCurrentPosition();

        switch (piece.getDirectionOfAttack()) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY()+1);
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY()-1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }

    @Override
    public Cell nextLeftPosition() {
        Position currentPosition = piece.getCurrentPosition();

        switch (piece.getDirectionOfAttack()) {
            case INCREASING:
                return Board.getCell(currentPosition.getX() + 1, currentPosition.getY()-1);
            case DECREASING:
                return Board.getCell(currentPosition.getX() - 1, currentPosition.getY()+1);
            default:
                Logger.getLogger(Navigation.class.getName()).severe("Direction of attack other than increasing or decresing");
                throw new IllegalArgumentException("Direction of attack other than increasing or decresing");
        }
    }


}

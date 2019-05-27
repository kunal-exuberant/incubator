package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Piece {

    private static byte pieceId = 0;

    private byte id;

    private Color color;

    private DirectionOfAttack directionOfAttack;

    private PieceType pieceType;

    private Position currentPosition;

    private Board board;

    private List<Position> possibleNextPositions = new ArrayList<>();

    public Piece(PieceType pieceType, Color color){
        this.id = pieceId++;
        this.pieceType = pieceType;
        this.color = color;
        this.directionOfAttack = DirectionOfAttack.INCREASING;
        if(color == Color.BLACK) this.directionOfAttack = DirectionOfAttack.DECREASING;
    }

    @Override
    public boolean equals(Object piece){
        if(this.id == ((Piece)piece).getId()){
            return true;
        }
        return false;
    }

    public void setPosition(Position currentPosition){
        this.currentPosition = currentPosition;
    }

    public abstract boolean canMoveTo(Position nextPosition);

    public abstract void computePossibleNextPositions(Position position);

    public boolean isMyPiecePresent(Cell nextCell){
        if(!nextCell.isAvailable() && nextCell.getPiecePlaced().getColor() == this.getColor()) {
            return false;
        }
        return true;
    }

    public boolean isOpponent(Piece piece){
        return this.getColor() != piece.getColor();
    }

    public abstract boolean canAttack(Board board);

    public abstract void move();

}

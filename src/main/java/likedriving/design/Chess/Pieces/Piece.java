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

    private Cell currentCell;

    private Navigation navigation = new Navigation(this);

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

    public boolean isMyPiecePresent(Cell nextCell){
        if(!nextCell.isAvailable() && nextCell.getPiecePlaced().getColor() == this.getColor()) {
            return false;
        }
        return true;
    }

    public boolean isOpponent(Piece piece){
        return this.getColor() != piece.getColor();
    }

    public abstract boolean canAttack();

    public abstract void move();

}

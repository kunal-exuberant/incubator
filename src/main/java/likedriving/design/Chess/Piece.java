package likedriving.design.Chess;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Piece {

    private static byte pieceId = 0;

    private byte id;

    private Color color;

    private PieceType pieceType;

    private Position currentPosition;

    private List<Position> possibleNextPositions = new ArrayList<>();

    public Piece(PieceType pieceType, Color color){
        this.id = pieceId++;
        this.pieceType = pieceType;
        this.color = color;
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

}

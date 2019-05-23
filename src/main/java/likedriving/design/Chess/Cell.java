package likedriving.design.Chess;

import lombok.Data;

@Data
public class Cell {
    private Position position;
    private boolean isAvailable;
    private Piece piecePlaced;

    public Cell(Position position){
        this.position = position;
        this.isAvailable = true;
        this.piecePlaced = null;
    }
}

package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.Piece;
import lombok.Data;

@Data
public class Cell {
    private Color color;
    private Position position;
    private boolean isAvailable;
    private Piece piecePlaced;

    public Cell(Position position, Color color){
        this.position = position;
        this.color = color;
        this.isAvailable = true;
        this.piecePlaced = null;
    }
}

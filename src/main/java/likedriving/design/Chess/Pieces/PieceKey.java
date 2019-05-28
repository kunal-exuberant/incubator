package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PieceKey extends Object{
    private Color color;
    private PieceType pieceType;

    @Override
    public boolean equals(Object pieceKey){
        return ((PieceKey)pieceKey).getColor() == this.getColor()
                && ((PieceKey)pieceKey).getPieceType() == this.pieceType;
    }

    @Override
    public int hashCode(){
        return this.getPieceType().hashCode() +  this.getColor().hashCode();
    }
}

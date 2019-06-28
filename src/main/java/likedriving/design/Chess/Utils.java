package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.Piece;

public class Utils {

    public static void logPieceStatus(Piece capturedPiece){
        capturedPiece.setCaptured(true);
        System.out.print(" and has captured "+capturedPiece.getPieceType()+"-"+capturedPiece.getId());
    }
}

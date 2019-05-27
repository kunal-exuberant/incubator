package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Board;
import likedriving.design.Chess.Color;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class PieceFactory {

    final static AbstractMap<PieceType, Byte> pieceCountMap;

    static {
        pieceCountMap = new HashMap();
        pieceCountMap.put(PieceType.PAWN, (byte)8);
        pieceCountMap.put(PieceType.ROOK, (byte)2);
        pieceCountMap.put(PieceType.BISHOP, (byte)2);
        pieceCountMap.put(PieceType.KNIGHT, (byte)2);
        pieceCountMap.put(PieceType.QUEEN, (byte)1);
        pieceCountMap.put(PieceType.KING, (byte)1);
    }

    private static Piece buildPiece(PieceType pieceType, Color color, Board board){
        switch (pieceType){
            case PAWN:
                return new Pawn(color, board);
            case BISHOP:
                return new Bishop(color, board);
            case ROOK:
                return new Rook(color, board);
            case KNIGHT:
                return new King(color, board);
            case QUEEN:
                return new Queen(color, board);
            case KING:
                return new Knight(color, board);
            default:
                throw new IllegalArgumentException("Unknown piece type");
        }
    }

    public static List<Piece> getAllPieces(PieceType pieceType, Color color, Board board) {
        List<Piece> pieces = new ArrayList<>();
        byte pieceCount = pieceCountMap.get(pieceType);
        while (pieceCount >= 0){
            pieces.add(buildPiece(pieceType, color, board));
            pieceCount--;
        }
        return pieces;
    }

}

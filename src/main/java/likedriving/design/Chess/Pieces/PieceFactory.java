package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;

import java.util.*;

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

    private static Piece buildPiece(PieceType pieceType, Color color){
        switch (pieceType){
            case PAWN:
                return new Pawn(color);
            case BISHOP:
                return new Bishop(color);
            case ROOK:
                return new Rook(color);
            case KNIGHT:
                return new Knight(color);
            case QUEEN:
                return new Queen(color);
            case KING:
                return new King(color);
            default:
                throw new IllegalArgumentException("Unknown piece type");
        }
    }

    public static Piece [] getAllPieces() {
        Piece [] pieces = new Piece[32];

            int i=0;
            for(Color color: Color.values()) {
                for (PieceType pieceType : PieceType.values()) {
                    byte pieceCount = pieceCountMap.get(pieceType);
                    while (pieceCount >= 0) {
                        pieces[i] = buildPiece(pieceType, Color.values()[i%2]);
                        pieceCount--;
                    }
                    i++;
                }
            }
        return pieces;
    }

    public static Map<PieceKey, List<Piece>> getPieceMap() {
        Map<PieceKey, List<Piece>> pieceMap = new LinkedHashMap<>();

        for(Color color: Color.values()) {
            for (PieceType pieceType : PieceType.values()) {
                byte pieceCount = pieceCountMap.get(pieceType);
                List<Piece> pieces = new ArrayList<>();
                while (pieceCount > 0) {
                    pieces.add(buildPiece(pieceType, color));
                    pieceCount--;
                }
                pieceMap.put(new PieceKey(color, pieceType), pieces);
            }
        }
        return pieceMap;
    }
}

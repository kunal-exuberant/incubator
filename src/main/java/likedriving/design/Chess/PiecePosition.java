package likedriving.design.Chess;

import likedriving.design.Chess.Pieces.Piece;
import likedriving.design.Chess.Pieces.PieceKey;
import likedriving.design.Chess.Pieces.PieceType;

import java.util.*;

public class PiecePosition {
    private static Map<PieceKey, List<Position>> piecePosition = null;

    static {
        piecePosition = new HashMap<>();
        piecePosition.put(new PieceKey(Color.WHITE, PieceType.ROOK),
                Arrays.asList(new Position((byte)0,(byte)0), new Position((byte)0,(byte)7)));
        piecePosition.put(new PieceKey(Color.BLACK, PieceType.ROOK),
                Arrays.asList(new Position((byte)7,(byte)0), new Position((byte)7,(byte)7)));

        piecePosition.put(new PieceKey(Color.WHITE, PieceType.KNIGHT),
                Arrays.asList(new Position((byte)0,(byte)1), new Position((byte)0,(byte)6)));
        piecePosition.put(new PieceKey(Color.BLACK, PieceType.KNIGHT),
                Arrays.asList(new Position((byte)7,(byte)1), new Position((byte)7,(byte)6)));

        piecePosition.put(new PieceKey(Color.WHITE, PieceType.BISHOP),
                Arrays.asList(new Position((byte)0,(byte)2), new Position((byte)0,(byte)5)));
        piecePosition.put(new PieceKey(Color.BLACK, PieceType.BISHOP),
                Arrays.asList(new Position((byte)7,(byte)2), new Position((byte)7,(byte)5)));

        piecePosition.put(new PieceKey(Color.WHITE, PieceType.KING),
                Arrays.asList(new Position((byte)0,(byte)3)));

        piecePosition.put(new PieceKey(Color.BLACK, PieceType.KING),
                Arrays.asList(new Position((byte)7,(byte)4)));

        piecePosition.put(new PieceKey(Color.WHITE, PieceType.QUEEN),
                Arrays.asList(new Position((byte)0,(byte)4)));

        piecePosition.put(new PieceKey(Color.BLACK, PieceType.QUEEN),
                Arrays.asList(new Position((byte)7,(byte)3)));

        piecePosition.put(new PieceKey(Color.BLACK, PieceType.PAWN),
                Arrays.asList(new Position((byte)1,(byte)0),
                        new Position((byte)1,(byte)1),
                        new Position((byte)1,(byte)2),
                        new Position((byte)1,(byte)3),
                        new Position((byte)1,(byte)4),
                        new Position((byte)1,(byte)5),
                        new Position((byte)1,(byte)6),
                        new Position((byte)1,(byte)7)));

        piecePosition.put(new PieceKey(Color.WHITE, PieceType.PAWN),
                Arrays.asList(new Position((byte)6,(byte)0),
                        new Position((byte)6,(byte)1),
                        new Position((byte)6,(byte)2),
                        new Position((byte)6,(byte)3),
                        new Position((byte)6,(byte)4),
                        new Position((byte)6,(byte)5),
                        new Position((byte)6,(byte)6),
                        new Position((byte)6,(byte)7)));
    }

    public static List<Position> get(Color color, PieceType pieceType){
        return piecePosition.get(new PieceKey(color, pieceType));
    }

    public static Iterator<Position> getPosition(Piece piece){
        return PiecePosition.get(piece.getColor(), piece.getPieceType()).iterator();
    }
}

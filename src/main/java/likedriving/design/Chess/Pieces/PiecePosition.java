package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;
import org.junit.Test;

import java.util.*;

public class PiecePosition {
    private static Map<PieceKey, List<Position>> piecePosition = null;

    static {
        piecePosition = new LinkedHashMap<>();
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

    public static List<Position> get(Piece piece){
        return piecePosition.get(new PieceKey(piece.getColor(), piece.getPieceType()));
    }

    public static Iterator<Position> getPosition(Piece piece){
        return PiecePosition.get(piece.getColor(), piece.getPieceType()).iterator();
    }

    @Test
    public void piecePositionTest(){
        for(Map.Entry pp :piecePosition.entrySet()){
            System.out.println(pp.getKey());
        }
        System.out.println(piecePosition.get(new PieceKey(Color.BLACK, PieceType.PAWN)));
        System.out.println(piecePosition.get(new PieceKey(Color.WHITE, PieceType.PAWN)));
        System.out.println(piecePosition.get(new PieceKey(Color.BLACK, PieceType.KING)));
        System.out.println(piecePosition.get(new PieceKey(Color.WHITE, PieceType.KING)));
        System.out.println(piecePosition.get(new PieceKey(Color.BLACK, PieceType.QUEEN)));
        System.out.println(piecePosition.get(new PieceKey(Color.WHITE, PieceType.BISHOP)));
    }
}

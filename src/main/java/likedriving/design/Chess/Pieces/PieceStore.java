package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Color;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PieceStore {
    private static Piece [] pieces = null;
    private static Map<PieceKey, List<Piece>> pieceMap = null;
    public static Piece[] getPieces(){
        if(pieces == null){
            pieces = new Piece[32];
            pieces = PieceFactory.getAllPieces();
        }
        return pieces;
    }

    public static Map<PieceKey, List<Piece>> getPieceMap(){
        if(pieceMap == null){
            pieceMap = PieceFactory.getPieceMap();
        }
        return pieceMap;
    }

    public static List<Piece> get(Color color, PieceType pieceType){
        getPieceMap();
        return pieceMap.get(new PieceKey(color, pieceType));
    }

    @Test
    public void piecePositionTest(){
        getPieceMap();
        for(Map.Entry pp :pieceMap.entrySet()){
            System.out.println(pp.getValue());
        }
    }
}

package likedriving.design.Chess;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.google.inject.Singleton;
import likedriving.design.Chess.Pieces.Piece;
import likedriving.design.Chess.Pieces.PiecePosition;
import likedriving.design.Chess.Pieces.PieceStore;
import likedriving.design.Chess.Pieces.PieceType;
import lombok.Data;
import org.junit.Test;

import java.util.Iterator;

@Data
@Singleton
public class Board {

    private static Cell [][] board = new Cell[8][8];

    public static Cell getCell(Position position){
        return board[position.getX()][position.getY()];
    }

    public static Cell getCell(byte x, byte y){
        return board[x][y];
    }

    public static Piece getPiece(byte x, byte y){
       return getCell(x,y).getPiecePlaced();
    }

    public static void initializeTheBoard() {
        for (byte i = 0; i < 8; i++) {
            for (byte j = 0; j < 8; j++) {
                board[i][j] = new Cell(new Position((byte) i, (byte) j), Color.values()[(i+j)%2]);
            }
        }
    }

    private static Iterator<Cell> getIterator(){
         return new ArrayIterator(board);
    }

    public static void deployPieces(){
        for(Color color: Color.values()){
            for(PieceType pieceType: PieceType.values()){
                for(Piece piece: PieceStore.get(color, pieceType)){
                    for(Position position : PiecePosition.get(piece)) {
                        piece.setCurrentPosition(position);
                        board[position.getX()][position.getY()].setPiecePlaced(piece);
                    }
                }
            }
        }
    }

    public static void printBoard(){
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

    @Test
    public void printBoardTest(){
        initializeTheBoard();
        printBoard();
        deployPieces();
        System.out.println("piece placed at this location: "+getPiece((byte)0,(byte)5));
        System.out.println("Color of this cell "+getCell((byte)0,(byte)0).getColor());
        System.out.println("Color of this cell "+getCell((byte)0,(byte)1).getColor());
    }
}

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
import java.util.List;

@Data
@Singleton
public class Board {

    private static Cell [][] lastState;

    private static Cell [][] board = new Cell[Constants.EIGHT][Constants.EIGHT];

    public static Cell getCell(Position position){
        return board[position.getX()][position.getY()];
    }

    public static void undoLastMove(){
        if(lastState == null){
            System.out.println("Last state not available");
            return;
        }
        board = lastState;
        lastState = null;
    }

    public static void storeLastState(){
        lastState = board;
    }

    public static boolean exists(int x, int y){
        return x >=0 && x < Constants.EIGHT && y >=0 && y<Constants.EIGHT;
    };

    public static Cell getCell(int x, int y){
        try{
            if(exists(x,y)){
                return board[x][y];
            }
            throw new IllegalArgumentException("which does not exist on the board");
        }catch (IllegalArgumentException e) {
            //System.out.println("Position is at: "+x+" "+y+" "+e.getMessage());
            return null;
        }
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
        List<Position> piecePositionList = null;
        for(Color color: Color.values()) {
            for (PieceType pieceType : PieceType.values()) {
                List<Piece> pieces = PieceStore.get(color, pieceType);
                piecePositionList = PiecePosition.get(pieces.get(0));
                    setPosition(pieces, piecePositionList);
            }
        }
    }

    private static void setPosition(List<Piece> pieceList, List<Position> positionList){

        for(int i=0; i<pieceList.size(); i++){
            for(int j=i; j<positionList.size(); j++){
                System.out.println("^^^"+pieceList.get(i));
                pieceList.get(i).setCurrentPosition(positionList.get(j));
                board[positionList.get(j).getX()][positionList.get(j).getY()].setPiecePlaced(pieceList.get(i));
                board[positionList.get(j).getX()][positionList.get(j).getY()].setAvailable(false);
                break;
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
        System.out.println("piece placed at this location: "+getPiece((byte)0,(byte)6));
        System.out.println("piece placed at this location: "+getPiece((byte)0,(byte)1));
        System.out.println("piece placed at this location: "+getPiece((byte)7,(byte)6));
        System.out.println("piece placed at this location: "+getPiece((byte)7,(byte)1));
        System.out.println("Color of this cell "+getCell((byte)0,(byte)0).getColor());
        System.out.println("Color of this cell "+getCell((byte)0,(byte)1).getColor());
    }
}

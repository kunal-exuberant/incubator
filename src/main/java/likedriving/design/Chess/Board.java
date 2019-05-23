package likedriving.design.Chess;

import lombok.Data;
import org.junit.Test;

@Data
public class Board {

    private Cell [] [] board = new Cell[8][8];

    public Cell getCell(Position position){
        return board[position.getX()][position.getY()];
    }

    public void initializeTheBoard(Player[] players){
        Piece piece;
        for(byte i=0; i<8; i++){
            for(byte j=0; j<8;j++) {
                board[i][j] = new Cell(new Position((byte) i, (byte) j));
                Color color = Color.BLACK;
                Player player = players[0];
                if(i == 0 || i == 1) {
                    color = color.WHITE;
                    player = players[1];
                }
                if(i ==0 || i == 7){
                    board[i][j].setAvailable(false);
                    if(j == 0) {
                        piece = player.getPieces().get(PieceType.ROOK).get(0);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 7) {
                        piece = player.getPieces().get(PieceType.ROOK).get(1);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 1) {
                        piece = player.getPieces().get(PieceType.KNIGHT).get(0);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 6) {
                        piece = player.getPieces().get(PieceType.KNIGHT).get(1);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 2) {
                        piece = player.getPieces().get(PieceType.BISHOP).get(0);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 5) {
                        piece = player.getPieces().get(PieceType.BISHOP).get(1);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 3) {
                        piece = player.getPieces().get(PieceType.QUEEN).get(0);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                    else if(j == 4) {
                        piece = player.getPieces().get(PieceType.KING).get(0);
                        piece.setCurrentPosition(new Position(i,j));
                        board[i][j].setPiecePlaced(piece);
                    }
                }
                else if(i ==1 || i == 6){
                    board[i][j].setAvailable(false);
                    piece = player.getPieces().get(PieceType.PAWN).get(j);
                    piece.setCurrentPosition(new Position(i,j));
                    board[i][j].setPiecePlaced(piece);
                }
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

    @Test
    public void printBoardTest(){
        Player [] players = new Player[2];
        players[0] = new Player(Color.BLACK);
        players[1] = new Player(Color.WHITE);
        initializeTheBoard(players);
        printBoard();
    }
}
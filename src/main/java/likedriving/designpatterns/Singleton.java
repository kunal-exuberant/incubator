/*
package likedriving.designpatterns;

import likedriving.design.Chess.Board;
import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Pieces.Pawn;
import likedriving.design.Chess.Pieces.Piece;
import likedriving.design.Chess.Pieces.PieceType;
import likedriving.design.Chess.Position;

    package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.Board;
import likedriving.design.Chess.Cell;
import likedriving.design.Chess.Color;
import likedriving.design.Chess.Position;
import java.util.Optional;

import java.util.Optional;

public class Singleton {






    public class Pawn extends Piece {

        private Pawn(Color color){
            super(PieceType.PAWN, color);
        }

        private static likedriving.design.Chess.Pieces.Pawn pawn = null;

        static Piece getInstance(Color color){
            if(pawn == null){
                pawn = new likedriving.design.Chess.Pieces.Pawn(color);
            }
            return pawn;
        }

        @Override
        public boolean canMoveTo(Position nextPosition) {
            Board board = new Board();
            Cell nextCell = board.getCell(nextPosition);
            Position currentPosition = this.getCurrentPosition();
            if(isMyPiecePresent(nextCell)){
                return false;
            }
            else if(nextCell.isAvailable() && nextPosition.getY() == currentPosition.getY()+1
                    && nextPosition.getX() == nextPosition.getX()){
                return true;
            }
            return true;
        }

        @Override
        public void computePossibleNextPositions(Position position) {

        }

        @Override
        public boolean canAttack(Board board) {

            switch (this.getDirectionOfAttack()) {
                case INCREASING:
                    if (this.getBoard().getCell(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() + 1)).isAvailable()) {
                        return true;
                    }
                    else if (this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() + 1)))
                            || this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() + 1)))) {
                        return true;
                    }
                    else {
                        System.out.println("Error case in deciding can attack");
                    }
                    break;

                case DECREASING:
                    if (this.getBoard().getCell(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() - 1)).isAvailable()) {
                        return true;
                    }
                    else if (this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() - 1)))
                            || this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() - 1)))) {
                        return true;
                    }
                    else{
                        System.out.println("Error case in deciding can attack");
                    }
                    break;
            }
            System.out.println("Error case in deciding can attack");
            return false;
        }

        @Override
        public void move() {
            System.out.println(this.getPieceType()+" "+"is moving unit distance");
            Position newPosition = null;
            Piece capturedPiece;

            switch (this.getDirectionOfAttack()) {
                case INCREASING:
                    if (this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() + 1)))){
                        capturedPiece = this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() + 1));
                        newPosition = new Position((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() + 1));
                    }
                    else if(this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() + 1)))) {
                        capturedPiece = this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() + 1));
                        newPosition = new Position((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() + 1));
                    }
                    else if (this.getBoard().getCell(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() + 1)).isAvailable()) {
                        newPosition = new Position(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() + 1));
                    }
                    else {
                        System.out.println("Error case in deciding can attack");
                    }
                    break;

                case DECREASING:
                    if (this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() - 1)))) {
                        capturedPiece = this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() - 1));
                        newPosition = new Position((byte) (this.getCurrentPosition().getX() - 1), (byte) (this.getCurrentPosition().getY() - 1));
                    }
                    else if(this.isOpponent(this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() - 1)))){
                        capturedPiece = this.getBoard().getPiece((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() - 1));
                        newPosition = new Position((byte) (this.getCurrentPosition().getX() + 1), (byte) (this.getCurrentPosition().getY() - 1));
                    }
                    else if (this.getBoard().getCell(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() - 1)).isAvailable()) {
                        newPosition = new Position(this.getCurrentPosition().getX(), (byte) (this.getCurrentPosition().getY() - 1));
                    }
                    else{
                        System.out.println("Error case in deciding can attack");
                    }
                    break;
            }
            if(Optional.ofNullable(newPosition).isPresent()) {
                this.setCurrentPosition(newPosition);
                this.getBoard().getCell(newPosition).setPiecePlaced(this);
            }
        }
    }
}
*/

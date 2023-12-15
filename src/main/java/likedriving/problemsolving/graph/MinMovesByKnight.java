package likedriving.problemsolving.graph;

import java.util.*;

/*
Given a chess board. Find the minimum number of moves that a knight needs to make to reach target T.

5,4
source - 2,2
target - 0,0
moves = 3

--
nodes -> 2,2
m = 0, 1
v -> 2,2
 */
public class MinMovesByKnight {

    public static int minMoves(int [][] arr, int sx, int sy, int dx, int dy, int m, int n){
        int [] possibleXMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int [] possibleYMoves = {-1, 1, -2, 2, -2, 2, -1, 1};

        Set<Cell> visited = new HashSet<>();
        Queue<Cell> nodes = new LinkedList<>();
        Cell source = new Cell(sx, sy, 0);
        nodes.offer(source);
        visited.add(source);
        while (!nodes.isEmpty()){
            Cell tuple = nodes.poll();
            if(tuple.getX() == dx && tuple.getY() == dy){
                return tuple.getMoves();
            }
            System.out.println(tuple.x +", "+tuple.y+", "+tuple.moves);
            for (int i = 0; i < 8; i++) {
                if((possibleXMoves[i] + tuple.getX() >= 0 && possibleXMoves[i] + tuple.getX() < m)
                        && possibleYMoves[i] + tuple.getY() >= 0 && possibleYMoves[i] + tuple.getY() < n) {
                    Cell neighbour = new Cell(possibleXMoves[i] + tuple.getX(), possibleYMoves[i]+ tuple.getY(), tuple.getMoves());
                    if(!visited.contains(neighbour)) {
                        neighbour.setMoves(neighbour.getMoves()+1);
                        nodes.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int m = 4, n = 4;
        int arr [][] = new int[m][n];
        System.out.println(minMoves(arr, 0,0, 2,2, m, n));
    }

    static class Cell{
        int x;
        int y;
        int moves;
        Cell(int x, int y, int moves){
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getMoves() {
            return moves;
        }

        public void setMoves(int moves){
            this.moves = moves;
        }
    }

}

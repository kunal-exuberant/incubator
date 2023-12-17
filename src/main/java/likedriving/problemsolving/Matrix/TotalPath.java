package likedriving.problemsolving.Matrix;
/*
Calculate total paths to reach the end of the matrix from the first.
 */
public class TotalPath{

    public static int totalPaths(int [] [] M, int row, int col){
        if(row == M.length -1 && col == M[0].length-1){
            return 1;
        }

            if(row > M.length-1 || col > M[0].length-1) return 0;

        return totalPaths(M, row, col+1) + totalPaths(M, row+1, col);
    }

    public static void main(String[] args) {
        int [][] M = {{1,1,1}, {1,1,1}, {1,1,1}};
        System.out.println(totalPaths(M, 0,0));
        //System.out.println(new TotalPath().calculatePath(3,3));

        //System.out.println(new TotalPath().calculatePathRecursive(3,3));
    }

    private int calculatePath(int row, int col){

        int [][] pathStore = new int[row][col];

        for(int i=0; i<row; i++){
            pathStore[i][0] = 1;
        }

        for(int j=0; j<col; j++){
            pathStore[0][j] = 1;
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                pathStore[i][j] = pathStore[i-1][j] + pathStore[i][j-1];
            }
        }
        return pathStore[row-1][col-1];
    }

    private int calculatePathRecursive(int row, int col){
        if(row ==1 || col == 1){
            return 1;
        }
        return calculatePathRecursive(row, col-1) + calculatePath(row-1, col);
    }
}
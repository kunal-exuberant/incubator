package likedriving.problemsolving;

import jnr.ffi.annotations.In;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.Arrays;

public class DynamicProgramming {

    public static void main(String[] args) {
        int [] coins = {2, 5, 10, 1};
        int amount = 27;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int [] [] M = new int[amount+1][coins.length+1];

        if(coins.length ==0) return -1;
        if(amount == 0) return 0;

        for(int i=0; i<=amount; i++){
            for(int j=0; j<=coins.length; j++){
                if(i==0){
                    M[i][j] = 0;
                }
                else{
                    M[i][j] = -1;
                }
            }
        }

        for(int i=1; i<=amount; i++){
            for(int j=1; j<=coins.length; j++){
                int min = M[i][j-1];

                if(i % coins[j-1] == 0){
                    min = i / coins[j-1];
                }
                for (int k = 0; k <= i; k++) {
                    if(M[k][j] != -1 && M[i - k][j] != -1) {
                        min = Math.min(M[k][j] + M[i - k][j], min);
                    }
                }
                M[i][j] = min;
            }
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }

        return M[amount][coins.length];
    }
}

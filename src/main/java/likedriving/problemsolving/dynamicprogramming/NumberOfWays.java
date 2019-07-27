package likedriving.problemsolving.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

class NumberOfWays {

    private static int [] ways = null;

    public static int climbStairs(int n) {

        if(ways == null){
            ways = new int[n];
            Stream.of(n).forEach(
            e-> {
                    ways[e-1] = 0;
                });
        }

        if(n <= 1) return 1;
        
        if(ways[n-1] != 0) return ways[n-1];
         ways[n-1] = climbStairs(n-2)+climbStairs(n-1);
         return ways[n-1];
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals("number of stairs are not equal",climbStairs(42), 10);

    }
    public void psvm(){
    }
}
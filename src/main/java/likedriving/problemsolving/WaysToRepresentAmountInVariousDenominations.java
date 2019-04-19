package likedriving.problemsolving;


import org.junit.Assert;
import org.junit.Test;

/* Given an amount, return the number of ways
 * to represent it in all available denominations
 */
public class WaysToRepresentAmountInVariousDenominations {

    private static int [] D = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static int getNumberOfWays(int A, int index){

        int W = 0;
        if(D[index] == 1){
            return 1;
        }

        int m = 1;
        while (D[index] * m <= A) m++;


        for (int j = 0; j < m; j++) {
            W += getNumberOfWays(A - j * D[index], index + 1);
        }

        return W;
    }

    @Test
    public void getNumberOfWaysTest(){
        Assert.assertEquals(getNumberOfWays(1, 0),1);
        Assert.assertEquals(getNumberOfWays(2, 0),2);
        Assert.assertEquals(getNumberOfWays(3, 0),2);
        Assert.assertEquals(getNumberOfWays(4, 0),3);
        Assert.assertEquals(getNumberOfWays(5, 0),4);
        Assert.assertEquals(getNumberOfWays(6, 0),5);
        Assert.assertEquals(getNumberOfWays(7, 0),6);
        Assert.assertEquals(getNumberOfWays(1100, 0),4);
    }
}

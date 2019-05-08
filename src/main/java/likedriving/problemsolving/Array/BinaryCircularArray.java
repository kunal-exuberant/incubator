package likedriving.problemsolving.Array;

import org.junit.Assert;
import org.junit.Test;

/*
* To traverse a circular array one way is 2*N time and use i%N to calculate the index
*/
public class BinaryCircularArray {

    public int countConsecutiveOnes(int [] a){

        int N = a.length;

        int index = 0, count = 0, maxCount = 0;

        for(int i=0; i< 2*N; i++){

            index = i % N;
            System.out.println(a[index]);
            if(a[index] == 1){
                count++;
            }
            else{
                count = 0;
            }
            maxCount = count > maxCount ?  count: maxCount;
        }
        return maxCount;
    }

    @Test
    public void countConsecutiveOnesTest(){
        int [] a = {1,1,0,0,1,1,0,1};
        Assert.assertEquals(countConsecutiveOnes(a), 3);
    }
}

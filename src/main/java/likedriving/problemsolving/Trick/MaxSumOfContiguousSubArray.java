package likedriving.problemsolving.Trick;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class MaxSumOfContiguousSubArray {

    private static int getMaxSum(int [] A, int k){

        int [] sum = new int[A.length+1];

        if(A.length < 2){
            return A[0];
        }

        sum[0] = 0;
        sum[1] = A[0];

        for(int i=2; i< A.length+1; i++){
            sum[i] = sum[i-1] + A[i-1];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=A.length; i>=0; i--){
            for(int j=0; j<i; j++){
                int diffSum = sum[i] - sum[j];
                if(priorityQueue.size() < k)
                priorityQueue.add(diffSum);
                else
                    if(priorityQueue.peek() < diffSum){
                        priorityQueue.poll();
                        priorityQueue.add(diffSum);
                    }
            }
        }
        return priorityQueue.peek();
    }

    @Test
    public void getMaxSumTest(){
        int[] A = {1, 3, 2, 5, 4};
        int [] sum = {0,1,4,6,11,15};
        Assert.assertEquals(getMaxSum(A, 1), 15);
        Assert.assertEquals(getMaxSum(A, 2), 14);
        Assert.assertEquals(getMaxSum(A, 3), 11);
        Assert.assertEquals(getMaxSum(A, 4), 11);
        Assert.assertEquals(getMaxSum(A, 5), 10);
        Assert.assertEquals(getMaxSum(A, 6), 9);
        Assert.assertEquals(getMaxSum(A, 7), 7);
        Assert.assertEquals(getMaxSum(A, 8), 6);
        Assert.assertEquals(getMaxSum(A, 9), 5);
        Assert.assertEquals(getMaxSum(A, 10), 5);
        Assert.assertEquals(getMaxSum(A, 11), 4);
    }
}
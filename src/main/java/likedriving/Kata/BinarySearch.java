package likedriving.Kata;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {


    public int chop1(int x, int [] arr){

        if(arr.length < 1) return -1;

        int start = 0;
        int end = arr.length -1;

        while(end >= start){

            int mid = (start + end) /2;

            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }


    public int recursiveChop(int x, int [] arr, int start, int end){

        if(arr.length < 1) return -1;
        if(end >= start){
            int mid = (start + end) /2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                return recursiveChop(x, arr, start, mid-1);
            }
            else{
                return recursiveChop(x, arr, mid+1, end);
            }
        }
        return -1;
    }

    public int chop(int x, int [] arr){

        if(arr.length < 1) return -1;

        int start = 0;
        int end = arr.length -1;

       return recursiveChop(x, arr, start, end);
    }


    @Test
    public void iterativeTest(){

        Assert.assertEquals(-1, chop(3, new int[]{}));
        Assert.assertEquals(-1, chop(3, new int[]{1}));
        Assert.assertEquals(0,  chop(1, new int[]{1}));

        Assert.assertEquals(0,  chop(1, new int[]{1, 3, 5}));
        Assert.assertEquals(1,  chop(3, new int[]{1, 3, 5}));
        Assert.assertEquals(2,  chop(5, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(0, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(2, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(4, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(6, new int[]{1, 3, 5}));

        Assert.assertEquals(0,  chop(1, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(1,  chop(3, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(2,  chop(5, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(3,  chop(7, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));

    }

}

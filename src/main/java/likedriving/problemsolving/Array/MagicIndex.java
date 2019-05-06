package likedriving.problemsolving.Array;

import org.junit.Assert;
import org.junit.Test;

public class MagicIndex {

    int mid = -1;
    public int getMagicIndex(int [] arr, int start, int end){
        if(start <= end) {
            mid = (start + end)/2;

            if(arr[mid] == mid){
                return mid;
            }
            else if(arr[mid] > mid){
                start = mid +1;
                return getMagicIndex(arr, start, end);
            }
            else{
                end = mid - 1;
                return getMagicIndex(arr, start, end);
            }
        }
        return mid;
    }

    @Test
    public void getMagicNumber(){
        int [] arr = {-1,0,1,2,3,4,5};
        Assert.assertEquals(getMagicIndex(arr, 0, -1), 1);
    }

}
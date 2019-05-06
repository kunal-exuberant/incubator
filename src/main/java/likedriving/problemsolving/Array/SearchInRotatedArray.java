package likedriving.problemsolving.Array;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedArray {

    private static int [] A = {10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5};

    private static int [] B = {10, 10, 10, 10, 10, 11, 12, 13, 14, 15, 1};

    private static int [] C = {15, 14, 13, 12, 11, 10, 6, 6, 6, 6, 6};

    public int searchInRotateArray(int [] A, int key, int start, int end) throws Exception{

        if(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == key){
                return mid;
            }
            else if(key < A[mid]){
                if(A[mid] > A[start] && key >= A[start]){
                    return searchInRotateArray(A, key, start, mid-1);
                }
                else if(A[end] < A[mid]){
                    return searchInRotateArray(A, key, mid+1, end);
                }
                else{
                    return searchInRotateArray(A, key, start, mid-1);
                }

            }
            else if(key > A[mid]){
                if(A[mid] < A[end] && key <= A[end]){
                    return searchInRotateArray(A, key, mid+1, end);
                }
                else if(A[start] > A[mid]){
                    return searchInRotateArray(A, key, start, mid-1);
                }
                else {
                    return searchInRotateArray(A, key, mid+1, end);
                }
            }
            else {
                throw new Exception("Unhandled case");
            }
        }
        return -1;
    }

    @Test
    public void searchInRotatedArrayTest() throws Exception{
        Assert.assertEquals(searchInRotateArray(A, 12, 0, 10),2);
        Assert.assertEquals(searchInRotateArray(A, 1, 0, 10),6);
        Assert.assertEquals(searchInRotateArray(A, 4, 0, 10),9);
        Assert.assertEquals(searchInRotateArray(A, 11, 0, 10),1);
        Assert.assertEquals(searchInRotateArray(A, 5, 0, 10),10);
        Assert.assertEquals(searchInRotateArray(A, 10, 0, 10),0);


        Assert.assertEquals(searchInRotateArray(B, 10, 0, 10),2);
        Assert.assertEquals(searchInRotateArray(B, 1, 0, 10),10);
        Assert.assertEquals(searchInRotateArray(B, 14, 0, 10),8);
        Assert.assertEquals(searchInRotateArray(B, 13, 0, 10),7);
        Assert.assertEquals(searchInRotateArray(B, 5, 0, 10),-1);
        Assert.assertEquals(searchInRotateArray(B, 12, 0, 10),6);


        Assert.assertEquals(searchInRotateArray(C, 15, 0, 10),0);
        Assert.assertEquals(searchInRotateArray(C, 10, 0, 10),5);
    }
}

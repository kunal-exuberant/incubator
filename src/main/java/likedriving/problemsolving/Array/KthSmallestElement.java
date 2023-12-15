package likedriving.problemsolving.Array;
import java.util.Arrays;
/*
Find the kth smallest element in array
    1,
  4,   2,
6, 5, 8, 10

In a binary tree, last index non leaf node = Floor[n/2 - 1]

 */
public class KthSmallestElement {

    public static int kthSmallestUsingSort(int [] arr, int k){
        if(k <= 0 || k > arr.length) return -1;
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static int kthSmallestUsingHeap(int [] arr, int k){
        if(k <= 0 || k > arr.length) return -1;
        minHeapify(arr);
        return arr[k-1];
    }

    private static void minHeapify(int[] arr) {
        int n = arr.length/2-1; //last index of non leaf node

        while(n >= 0){
            int left = 2*n+1;
            int right = 2*n+2;

            int temp = n;
            if(arr[left] < arr[n] && arr[left] < arr[right]){
                temp = left;
            }

            if(arr[right] < arr[n] && arr[right] < arr[left]){
                temp = right;
            }

            swap(arr, temp, n);
            n--;
        }
    }

    private static void swap(int [] arr, int temp, int n){
        if(temp != n){
            int x = arr[temp];
            arr[temp] = arr[n];
            arr[n] = x;
        }
    }

    public static void main(String[] args) {
        int arr [] = {2, 5, 2, 5, 1, 8, 10};
        minHeapify(arr);
        System.out.println(kthSmallestUsingHeap(arr, 1));
        System.out.println(kthSmallestUsingHeap(arr, 2));
        System.out.println(kthSmallestUsingHeap(arr, 3));
        System.out.println(kthSmallestUsingHeap(arr, 4));
        System.out.println(kthSmallestUsingHeap(arr, 5));
        System.out.println(kthSmallestUsingHeap(arr, 6));
        System.out.println(kthSmallestUsingHeap(arr, 7));
        System.out.println(kthSmallestUsingHeap(arr, 8));
    }
}


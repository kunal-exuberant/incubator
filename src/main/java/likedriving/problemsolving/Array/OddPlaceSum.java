package likedriving.problemsolving.Array;
/*
Find the sum of elements at odd places in array
 */
public class OddPlaceSum {
    public static int sum(int [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i%2 ==0){
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr [] = {2, 5, 2, 5, 1, 8, 10};
        System.out.println(sum(arr));
    }
}

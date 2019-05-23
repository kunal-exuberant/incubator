package likedriving.problemsolving.Array;

import java.util.Scanner;

public class SwapAlternateElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            int N = sc.nextInt();
            int [] A = new int[N];
            int j=0;
            while(j < N){
                A[j] = sc.nextInt();
                j++;
            }

           for(int i=0; i<N-2;i++){
                int temp = A[i];
                A[i] = A[i+2];
                A[i+2] = temp;
           }

           for(int x: A){
               System.out.println(x);
           }

           T--;
        }
    }

}

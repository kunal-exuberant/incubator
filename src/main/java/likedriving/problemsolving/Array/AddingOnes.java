package likedriving.problemsolving.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
You start with an array A of size N. Also, A[i] = 0 for i = 1 to N.
You will be given K positive integers. Let j be one of these integers,
you have to add 1 to all A[i], for i >= j.
Your task is to print the array A after all these K updates are done.

    https://practice.geeksforgeeks.org/problems/adding-ones/0

*/
public class AddingOnes {

        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while(T > 0){
                int N = sc.nextInt();
                int K = sc.nextInt();
                int [] A = new int[K];
                int j=0;
                while(j < K){
                    A[j] = sc.nextInt();
                    j++;
                }
                Arrays.sort(A);
                Map<Integer, Integer> fMap = new HashMap<>();
                for(int i=0; i<N; i++){
                    fMap.put(i, 0);
                }

                for(int x: A){
                    if(fMap.containsKey(x-1)){
                        fMap.put(x-1,fMap.get(x-1)+1);
                    }
                    else{
                        fMap.put(x-1,1);
                    }
                }

                int [] B = new int[N];
                B[0] = fMap.get(0);
                for(int i=1; i<N; i++){
                    B[i] = B[i-1] + fMap.get(i);
                }
                for(int y: B){
                    System.out.print(y+" ");
                }
                System.out.println();
                T--;
            }
        }
}

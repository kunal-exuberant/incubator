package likedriving.problemsolving.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestFibonacci {

    public static void main (String[] args) {
        //code
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

            int a=0, b=1, c;
            Map<Integer, Boolean> fMap = new HashMap<>();
            fMap.put(a, true);
            fMap.put(b, true);
            while(a+b < 1000){
                c = a + b;
                fMap.put(c, true);
                a = b;
                b = c;
            }
            for(int i=0; i<N; i++){
                if(fMap.containsKey(A[i])){
                    System.out.print(A[i]+" ");
                }
            }
            System.out.println();

            T--;
        }
    }
}
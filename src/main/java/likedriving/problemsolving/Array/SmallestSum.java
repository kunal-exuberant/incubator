package likedriving.problemsolving.Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SmallestSum {
    public static void main (String[] args) {
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

            Arrays.sort(A);
            List<Integer> list = new ArrayList<>();
            for(int x: A){
                if(x!=0){
                    list.add(x);
                }
            }

            BigInteger first = BigInteger.valueOf(0);
            BigInteger second = BigInteger.valueOf(0);

            for(int i=0; i<list.size(); i++){
                if(i % 2 ==0){
                    first = first.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(list.get(i)));
                }else{
                    second = second.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(list.get(i)));
                }
            }

            System.out.println(first.add(second)+"");
            T--;
        }

    }
}

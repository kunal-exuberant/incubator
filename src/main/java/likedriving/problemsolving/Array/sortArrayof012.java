/*
public class sortArrayof012 {

    */
/*package whatever //do not write package name here *//*


import java.util.*;
import java.lang.*;
import java.io.*;

    class GFG {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for(int i=0; i<T; i++){
                sc.nextLine();
                int N = sc.nextInt();
                sc.nextLine();
                int[] A = new int[N];
                for(int j = 0; j<N; j++){
                    A[j] = sc.nextInt();
                }
                sortArray(A, N);
            }
        }

        private static void sortArray(int [] A, int N){

            int count1 = 0, count0 = 0, count2 = 0;
            for(int i=0; i<N; i++){
                if(A[i] == 0) count0++;
                if(A[i] == 1) count1++;
            }

            int i=0;
            while(i<N){
                if(i< count0) {
                    System.out.print(0+" ");
                }
                else if(i< count0+count1){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(2+" ");
                }
                i++;
            }
            System.out.println();
        }
    }
}
*/

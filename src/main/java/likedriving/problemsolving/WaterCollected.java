package likedriving.problemsolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WaterCollected {

    private static int calculateWaterCollected(int [] A){

        if (A.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int [] B = new int [A.length];
        B[0] = A[0];

        for(int i=1; i< A.length; i++){
            if(A[i] < B[i-1]){
                B[i] = B[i-1];
            }
            else{
                B[i] = A[i];
            }
        }

/*
        A = [4, 2, 6, 8, 1];

        B = [0, 0, 2, 3, 3];

        for(int i=1; i<A.length; i++){
            if((getMaximum(A, i-1) - getMaximum(A, i+1)) > 0) {
                map.put(i, getMaximum(A, i - 1) - getMaximum(A, i + 1));
            }
        }

        int WaterColleted = 0;
        for(int entry: map.keySet()){
            waterCollected += map.get(entry);
        }

        return waterCollected;*/
return  0;
    }

    private int getMaximum(int [] A, int i){

        Stack<Integer> maxStack = new Stack<>();

        if(A[i] >= A[maxStack.peek()] ){
            maxStack.push(i);
        }

        return maxStack.pop();

    }

}

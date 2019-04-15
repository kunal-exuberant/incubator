package likedriving.AbstractProblemSolving;

/*
    Given two eggs, have to figure out worst case number to test to perform
    to find N, which the floor number, such that floor >= N, egg will always break
    floor<N egg will not drop.

    Given number of floors, which is totalFloors
    and breaking floor, breakingFloorN

    By analysis we figured out that if there are 100 floors,
    then throwing first egg from at floor interval of 14 is most optimal
    to reduce the number of attempts to arrive at the breaking floor.
 */

import org.junit.Assert;
import org.junit.Test;

public class BrokenEggProblem {

    private static int interval = 14;

    private static  int breakingFloorN = 96;

    private static int totalFloors = 100;

    private static boolean wouldBreak(int floor){
        return floor >= breakingFloorN;
    }

    private static int [] count1stEggAttempts(){

        int floor = interval, attemptCount = 0;

        while(floor+interval < totalFloors && !wouldBreak(floor)){
            floor = floor + interval;
            attemptCount++;
        }
        return new int[] {attemptCount, floor};
    }

    private static int count2ndEggAttempts(int firstEggBreakFloor){

        int floor = firstEggBreakFloor, attemptCount = 0;
        while(floor != breakingFloorN && floor < totalFloors){
            attemptCount++;
            floor--;
        }
        return attemptCount;
    }

    private static int countTotalAttempts(){
        int[] firstEgg = count1stEggAttempts();
        return firstEgg[0] + count2ndEggAttempts(firstEgg[1]);
    }

    @Test
    public void testBreakingCount(){
        Assert.assertEquals(countTotalAttempts(), 8);
    }

}

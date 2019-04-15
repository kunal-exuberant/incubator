package likedriving.problemsolving;

import org.junit.Assert;
import org.junit.Test;

public class LongestSequenceWithOneFlip {


    private static int getLongestSequence(int num){

        StringBuilder binaryStr = convertToBinary(num);

        int prev = -1, prevOfPrev = -1, maxLength = 0;

        for(int i=0; i<binaryStr.length(); i++){

            if(binaryStr.charAt(i) == '0'){

                if(prevOfPrev == -1 && prev == -1){
                    prev = i;
                }
                else if(prevOfPrev == -1){
                    prevOfPrev = prev;
                    prev = i;
                    if(i > maxLength) maxLength = i;
                }
                else{
                    if(i-prevOfPrev-1 > maxLength) maxLength = i-prevOfPrev-1;
                    prevOfPrev = prev;
                    prev = i;

                }
            }
            if (i - prevOfPrev - 1 > maxLength) maxLength = i - prevOfPrev - 1;
        }
        return maxLength;
    }

    @Test
    public void getLengthTest(){
        Assert.assertEquals(new StringBuilder().length(), 0);
        Assert.assertEquals(new StringBuilder()+"x", "x");
        Assert.assertNotEquals(new StringBuilder(), (""));
        //Assert.assertEquals(getLongestSequence(4), "10");
        //Assert.assertEquals(1<<1,3);
        //Assert.assertEquals(convertToBinary(5), new StringBuilder().append("101"));
        Assert.assertEquals(getLongestSequence(20), 3);

    }

    private static StringBuilder convertToBinary(int num){

        StringBuilder binaryStr = new StringBuilder();
        while(num  > 0){
            binaryStr.append(num%2);
            num = num/2;
        }
        return binaryStr;
    }

    private static int getMultiplier(int num){

        int multiplier = 1;
        while(num > 0){
            multiplier = multiplier << 1;
            num = num / 2;
        }
        return multiplier;
    }
}
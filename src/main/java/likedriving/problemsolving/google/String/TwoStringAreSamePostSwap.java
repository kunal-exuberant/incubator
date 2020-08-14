package likedriving.problemsolving.google.String;

import org.junit.Assert;
import org.junit.Test;

/*
    Problem: check if two strings can become same after single swapping one string

    Approach: Example -
    abcde
    aecdb
 */
public class TwoStringAreSamePostSwap {

    public boolean swapTest(String s1, String s2){

        if(s1.length() != s2.length()) return false;

        int [] diffIndex = new int[2];

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        int j=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1Chars[i] != s2Chars[i]){
                if(j<2) {
                    diffIndex[j] = i;
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        if(j!=2){
            return false;
        }
        if(s2Chars[diffIndex[0]] != s1Chars[diffIndex[1]] ||
        s2Chars[diffIndex[1]] != s1Chars[diffIndex[0]]){
            return false;
        }
        return true;
    }

    @Test
    public void swapTestTest(){
        Assert.assertEquals(swapTest("abcde", "aecdb"), true);
        Assert.assertEquals(swapTest("abcde", "aecde"), false);
        Assert.assertEquals(swapTest("abcde", "aecd"), false);
    }

}

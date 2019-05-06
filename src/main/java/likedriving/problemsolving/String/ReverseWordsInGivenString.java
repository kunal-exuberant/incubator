package likedriving.problemsolving.String;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInGivenString {

/*
*  String s = "Sun rises in the east";
*  Step 1: String s1 = "nuS sesir ni eht tsae";
*  Step 2: String s2 = "east the in rises Sun";
*/

    private static char WHITESPACE = ' ';
    // Approach - Reverse each for the words and then reverse the string
    public char [] reverseWordsInAGivenString(char [] s){


        int firstCharPos = -1;
        int lastCharPos = -1;

        for(int i=0; i<s.length; i++){
            if(firstCharPos == -1 && s[i] != WHITESPACE){
                firstCharPos = i;
            }

            if(firstCharPos != -1 && (i+1 == s.length || s[i+1] == WHITESPACE)){
                lastCharPos = i;
            }

            if(firstCharPos != -1 && lastCharPos != -1){
                reverseString(s, firstCharPos, lastCharPos);
                firstCharPos = -1;
                lastCharPos = -1;
            }
        }

        return reverseString(s, 0, s.length-1);

    }


    @Test
    public void reverseWordsInAGivenStringTest(){

        Assert.assertArrayEquals(reverseWordsInAGivenString("abc def".toCharArray()), "def abc".toCharArray());

    }


    // a
    // ab
    // abc
    // abcd
    // abcde
    private char [] reverseString(char [] s, int firstCharPos, int lastCharPos){

        while(firstCharPos < lastCharPos){
            char temp = s[firstCharPos];
            s[firstCharPos] = s[lastCharPos];
            s[lastCharPos] = temp;

            firstCharPos++;
            lastCharPos--;
        }
        return s;
    }

    @Test
    public void reverseStringTest(){

        Assert.assertArrayEquals(reverseString("abcde".toCharArray(), 0, 4), "edcba".toCharArray());

    }


}

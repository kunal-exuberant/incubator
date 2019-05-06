package likedriving.problemsolving.String;

import org.junit.Assert;
import org.junit.Test;

public class SwapFirstLastCharacter {

    private static char WHITESPACE = ' ';

    public static char [] swapFirstLastCharacter(char [] s){

        int firstCharIndex = -1, lastCharIndex = -1;

        for(int i=0; i< s.length; i++){
            if(firstCharIndex == -1 && s[i] != WHITESPACE){
                firstCharIndex = i;
            }
            if(firstCharIndex != -1 && (i+1 == s.length || s[i+1] == WHITESPACE)){
                lastCharIndex = i;
            }
            if(firstCharIndex != -1 && lastCharIndex != -1 ){

                char tempChar = s[lastCharIndex];
                s[lastCharIndex] = s[firstCharIndex];
                s[firstCharIndex] = tempChar;


                firstCharIndex = -1;
                lastCharIndex = -1;

            }
        }
        return s;
    }

    @Test
    public void swapFirstLastCharacterTest(){
        String str = "Sun rises in the east";
        String swappedStr = "nuS siser ni eht tase";
        char [] s = swapFirstLastCharacter(str.toCharArray());
        Assert.assertArrayEquals(s, swappedStr.toCharArray());
    }
}
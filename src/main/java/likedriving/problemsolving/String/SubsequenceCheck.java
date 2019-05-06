package likedriving.problemsolving.String;

import org.junit.Assert;
import org.junit.Test;

public class SubsequenceCheck {

    public boolean isSubsequence(String s1, String s2){

        char [] str1 = s1.toCharArray();

        char [] str2 = s2.toCharArray();

        int index1 = 0, index2 = 0;

        while(true){
            if(str1[index1] == str2[index2]) {
                index1++;
                index2++;
            }else{
                index2++;
            }

            if(index1 == str1.length) return true;
            if(index2 == str2.length) return false;
        }

    }

    @Test
    public void isSubsequenceTest(){
        Assert.assertEquals(isSubsequence("abc", "axbrtscz"), true);
    }


}

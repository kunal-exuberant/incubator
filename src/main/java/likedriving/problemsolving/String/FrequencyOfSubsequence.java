package likedriving.problemsolving.String;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class FrequencyOfSubsequence {

    String str1 = "abc abxc cbax abc";
    String str2 =  "abc";

    public int getFrequencyOfSubsequence(String str1, String str2){

        char [] s1 = str1.toCharArray();
        char [] s2 = str2.toCharArray();

        Stack<Character> charStack1 = new Stack<>();
        Stack<Character> charStack2 = new Stack<>();

        for(char x: s1){
            charStack1.push(x);
        }

        int frequency =0;

        while (!charStack1.empty()){
            for(int i=s2.length-1; i>=0; ){

                char c = charStack1.pop();

                if(c == s2[i]){
                    if(i==0){
                        frequency++;
                        while(!charStack2.empty())
                        charStack1.push(charStack2.pop());
                    }
                    i--;
                }else{
                    charStack2.push(c);
                }

                if(charStack1.empty()){
                    return frequency;
                }
            }
        }
        return frequency;
    }

    @Test
    public void getFrequencyOfSubsequenceTest(){
        Assert.assertEquals(getFrequencyOfSubsequence("a","a"),1);
        Assert.assertEquals(getFrequencyOfSubsequence("aa","a"),2);
        Assert.assertEquals(getFrequencyOfSubsequence("abacbbc","abc"),2);
    }
}
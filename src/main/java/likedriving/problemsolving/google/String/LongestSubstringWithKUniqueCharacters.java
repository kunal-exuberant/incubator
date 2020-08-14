package likedriving.problemsolving.google.String;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LongestSubstringWithKUniqueCharacters {

    /*
    How to approach the problem?
        use examples - abaebdghed
     */
    public String getLongestSubstring(String str, int k) {
        String substring = "";

        char [] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            String newS = checkSubstring(chars, k, i);
            if(newS.length() > substring.length()){
                substring = newS;
            }
        }
        return substring;
    }

    private String checkSubstring(char [] chars, int k, int startIndex){

        String ss = "";
        HashSet<Character> hashSet = new HashSet<>();
        int i = startIndex;
        while(k >= 0 && i < chars.length) {
            if(!hashSet.contains(chars[i])) {
                hashSet.add(chars[i]);
                k--;
            }
                ss += chars[i];

            i++;
        }
        return ss;
    }

    @Test
    public void getLongestSubstringTest(){
        Assert.assertEquals(getLongestSubstring("abaebdghed", 3), "abaeb");
    }
}

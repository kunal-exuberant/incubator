package likedriving.problemsolving.google.String;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

public class FirstNonRepeatingCharacter {

    public char getNonRepeatingCharacters(String str){
        char [] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> backupStack = new Stack<>();
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i <chars.length; i++) {
            if(hashSet.contains(chars[i])){
                while (!stack.empty()) {
                    char value = stack.pop();
                    if (value == chars[i]) {
                        break;
                    } else {
                        backupStack.push(value);
                    }
                }
                while (!backupStack.empty()) {
                    stack.push(backupStack.pop());
                }
            }
            else {
                hashSet.add(chars[i]);
                stack.push(chars[i]);
            }
        }
        char firstNonRepeatingChar = Character.MIN_VALUE;
        while (!stack.empty()){
            firstNonRepeatingChar = stack.pop();
        }
        return firstNonRepeatingChar;
    }

    @Test
    public void getNonRepeatingCharactersTest(){
        Assert.assertEquals(getNonRepeatingCharacters("ABCAXYABU"), 'C');
        Assert.assertEquals(getNonRepeatingCharacters("ABC"), 'A');
        Assert.assertEquals(getNonRepeatingCharacters("AAA"), Character.MIN_VALUE);
    }
}

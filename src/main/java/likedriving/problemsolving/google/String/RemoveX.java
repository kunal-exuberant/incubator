package likedriving.problemsolving.google.String;

import org.junit.Assert;
import org.junit.Test;

public class RemoveX {

    // remove all occurances of x from a string with and without recursion

    public String removeX(final String string){

        char [] chars = string.toCharArray();

        int index = chars.length -1;
        int lastOccurance = -1;
        while (index >=0){

            if(lastOccurance == -1 && isX(chars[index])){
                lastOccurance = index;
            }
            else if(lastOccurance != -1
                    && (!isX(string.charAt(index)))){
                chars = shift(chars, index, lastOccurance);
                lastOccurance = -1;
            }
            index--;
        }
        if(lastOccurance != -1){
            chars = shift(chars, index, lastOccurance);
        }
        return String.valueOf(chars);
    }

    private char[] shift(char [] chars, int currentIndex, int lastOccurance) {
        int charsRemoved = 1;
        while (lastOccurance+charsRemoved < chars.length){
            chars[currentIndex+charsRemoved] = chars[lastOccurance+charsRemoved];
            charsRemoved++;
        }

        char [] newA = new char[chars.length - (lastOccurance-currentIndex)];
        System.arraycopy(chars, 0, newA, 0, chars.length - (lastOccurance-currentIndex));
        return newA;
    }

    private void printArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    private boolean isX(char c){
        return c == 'x' || c == 'X';
    }


    @Test
    public void removeXTest(){
        Assert.assertEquals(removeXUsingTwoPointers("abXXzXX4"), "abz4");
        Assert.assertEquals(removeXUsingTwoPointers("abcXXyzxxxxxxXXXXXXXX4444"), "abcyz4444");
        Assert.assertEquals(removeXUsingTwoPointers("abcXXyzxxxxxx97987897XXXXXXXX4444"), "abcyz979878974444");
        Assert.assertEquals(removeXUsingTwoPointers("abcXXyzXds"), "abcyzds");
        Assert.assertEquals(removeXUsingTwoPointers("abcXXyz"), "abcyz");
        Assert.assertEquals(removeXUsingTwoPointers("abcX"), "abc");
        Assert.assertEquals(removeXUsingTwoPointers("X").length(), 0);
        Assert.assertEquals(removeXUsingTwoPointers(""), "");
        Assert.assertEquals(removeXUsingTwoPointers("XXXXXX"), "");
        Assert.assertEquals(removeXUsingTwoPointers("abc"), "abc");
    }

    public String removeXUsingTwoPointers(String str){
        int trimLen = 0;
        int i=0,j;
        char [] chars = str.toCharArray();
        int m = 0;
        while(m < chars.length){
            if(isX(chars[m])) trimLen++;
            m++;
        }
        if(trimLen == chars.length){
            return "";
        }
        while(true) {
            printArray(chars);
            while (!isX(chars[i]) && i < chars.length-1) {
                i++;
            }
            j = i;
            while (isX(chars[j]) && j < chars.length-1) {
                j++;
            }
            for (int p = 0; p + j < chars.length; p++) {
                chars[i + p] = chars[j + p];
            }
            System.out.println(i+" "+j+" "+trimLen);
            if(i == chars.length -1 && j == chars.length-1) break;
        }
        System.out.println(trimLen);
        char [] newA = new char[chars.length - trimLen];
        System.arraycopy(chars, 0, newA, 0, chars.length - trimLen);
        return  String.valueOf(newA);
    }
}

package likedriving.problemsolving;

public class CompressString {

    private static char[] compressString(char[] str){

        if(isCompressingReducesLength(str)){

            int repeatingCount = 1;
            for(int i=0; i<str.length-1; i++){
                if(str[i+1] == str[i]){
                    repeatingCount++;
                }
                else {
                    int N = repeatingCount;
                    int numberOfCharInRepeatingCount = 0;
                    while (N > 0) {
                        numberOfCharInRepeatingCount++;
                        N = N / 10;
                    }
                    str[i-repeatingCount+2] =  (char)repeatingCount;
                    int positionToShift = repeatingCount - numberOfCharInRepeatingCount-1;
                    if(positionToShift > 0) {
                        shiftCharArray(str, i, positionToShift);
                    }
                    repeatingCount = 1;
                }
            }
        }
        return str;
    }



    public static void main(String[] args) {
        char[] str = new char[]{'a','a','a','b','b','b','c','c','c','a'};
        compressString(str);
        System.out.println(str);
    }

    private static char [] shiftCharArray(char [] str, int index, int p){
        for(int i=index; i<str.length-p; i++){
            str[index] = str[index+p];
        }
        return str;
    }

    private static boolean isCompressingReducesLength(char [] str){
        if(str.length < 3) return false;
        int uniqueCharCount = 1;
        for(int i=0; i< str.length-1; i++){
            if(str[i] != str[i+1]){
                uniqueCharCount++;
            }
        }
        return str.length > 2 * uniqueCharCount;
    }

}

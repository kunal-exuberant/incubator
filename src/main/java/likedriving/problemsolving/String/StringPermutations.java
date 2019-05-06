package likedriving.problemsolving.String;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    private static List<String> getAllPermutations(String str){

        List<String> stringList = new ArrayList<String>();
        if(str.length() == 0){
            return stringList;
        }
        if(str.length() == 1) {
            stringList.add(str);
            return stringList;
        }

        stringList = getAllPermutations(str.substring(0, str.length()-1));

        char lastChar = str.charAt(str.length()-1);

        List<String> stringListCopy = new ArrayList<String>();

        for(String s: stringList){

            stringListCopy.add(lastChar +""+s);
            for(int i=0; i<s.length()-1; i++){
                stringListCopy.add(""+s.substring(0,i+1) + lastChar + s.substring(i+1));
            }
            stringListCopy.add(""+s+lastChar);

        }

        return stringListCopy;
    }

    public static void main(String[] args) {
        String str = "";
        List<String> stringList = getAllPermutations(str);
        System.out.println("Total num of permutations :"+ stringList.size());
        for(String s: getAllPermutations(str)) {
            System.out.println(s);
        }
    }

}

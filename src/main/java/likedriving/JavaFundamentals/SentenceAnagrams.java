package likedriving.Java;

import java.util.*;



public class SentenceAnagrams {

    /*
     * Complete the 'countSentences' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY wordSet
     *  2. STRING_ARRAY sentences
     */

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        // Write your code here
        Map<String, Integer> anagrams = processWordset(wordSet);
        List<Long> counts = new ArrayList<>();
        for(String sentence: sentences){
            long sum =1;
            for(String word: sentence.split(" ")){
                if(anagrams.containsKey(word)){
                    System.out.println(anagrams.get(word));
                    if(anagrams.get(word) > 1){
                        sum *= anagrams.get(word);
                    }

                }else{
                    //sum += 1; 
                }
            }
            counts.add(sum);
            sum =1;
        }
        return counts;
    }

    private static Map<String, Integer> processWordset(List<String> words){
        Map<Integer, List<String>> map = new HashMap<>();
        for(String word: words){
            if(map.containsKey(word.length())){
                List<String> slWords =  new ArrayList<>();
                slWords.addAll(map.get(word.length()));
                slWords.add(word);
                map.put(word.length(), slWords);
            }else{
                map.put(word.length(), Arrays.asList(word));
            }
        }
        Map<String, Integer> anagrams = new HashMap<>();
        for(Map.Entry<Integer, List<String>> entry: map.entrySet()){
            for(int i=0; i<entry.getValue().size(); i++){
                for(int j=0; j<entry.getValue().size(); j++){
                    String word1 = entry.getValue().get(i);
                    String word2 = entry.getValue().get(j);
                    if(!word1.equals(word2)){
                        if(areAnagrams(word1, word2)){
                            if(anagrams.containsKey(word1) || anagrams.containsKey(word2)){
                                anagrams.put(word1, anagrams.get(word1)+1);
                                anagrams.put(word2, anagrams.get(word2)+1);
                            }
                            else{
                                anagrams.put(word1, 1);
                                anagrams.put(word2, 1);
                            }
                        }
                    }
                }
            }

        }
        return anagrams;
    }

    private static boolean areAnagrams(String word1, String word2){
        Map<Character, Integer> ana = new HashMap<>();
        for(char c: word1.toCharArray()){
            if(ana.containsKey(c)){
                ana.put(c, ana.get(c)+1);
            }
            else{
                ana.put(c, 1);
            }
        }
        for(char c: word2.toCharArray()){
            if(ana.containsKey(c)){
                ana.put(c, ana.get(c)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }

}
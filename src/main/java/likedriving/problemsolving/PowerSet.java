package likedriving.problemsolving;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    private List<ArrayList<Character>> getAllSubsets(List<Character> set, int index){
        List<ArrayList<Character>> allSubsets = null;
        if(index == 0){
            allSubsets = new ArrayList<ArrayList<Character>>();
            allSubsets.add(new ArrayList());
        }
        else{
            allSubsets = getAllSubsets(set, index -1);

            List<ArrayList<Character>> moreSubsets = null;
            //moreSubsets.addAll(allSubsets);
            char item = set.get(index-1);
            for(ArrayList<Character> subset: new ArrayList<>(allSubsets)){
                moreSubsets = new ArrayList<ArrayList<Character>>();
                subset.add(item);
                moreSubsets.add(subset);
            }

            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    @Test
    public void getAllSubsetsTest(){
        Assert.assertEquals(getAllSubsets(Arrays.asList('a','b'), 2), Arrays.asList(1,2));
    }

}

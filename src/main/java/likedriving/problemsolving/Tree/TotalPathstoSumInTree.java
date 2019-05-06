package likedriving.problemsolving.Tree;

import org.junit.Assert;
import org.junit.Test;

import static likedriving.problemsolving.Tree.SortedListFromBinaryTree.init;

public class TotalPathstoSumInTree {

    private static int totalPaths = 0;

    private static int countTotalPaths(TreeNode root, int sum){

        if(root == null) return 0;
        sum = sum - root.data;
        System.out.println(sum);
        if(sum == 0){
            totalPaths++;
        }

        countTotalPaths(root.left, sum);
        countTotalPaths(root.right, sum);
        return totalPaths;
    }

    @Test
    public void countTotalPathsTest(){
        TreeNode root = init();

        Assert.assertEquals(countTotalPaths(root, 8), 1);
        Assert.assertEquals(countTotalPaths(root, 10), 3);
    }
}

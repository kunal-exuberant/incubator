package likedriving.problemsolving;

import org.junit.Assert;
import org.junit.Test;


public class CommonAncestor {

    private static TreeNode getCommonAncesstor(TreeNode root, TreeNode a, TreeNode b){

        if(root == null || root == a || root == b) return root;

        boolean aIsPresent = checkIfPresent(root.left, a);
        boolean bIsPresent = checkIfPresent(root.left, b);

        if(aIsPresent && bIsPresent) return root.left;

        if(!aIsPresent && !bIsPresent) return root.right;

        return root;
    }

    private static boolean checkIfPresent(TreeNode root, TreeNode x){

        if(root == x) return true;

        boolean presentInLeft = false, presentInRight = false;

        if(root.left != null) presentInLeft = checkIfPresent(root.left, x);

        if(root.right != null) presentInRight = checkIfPresent(root.right, x);

        return presentInLeft || presentInRight;
    }

    @Test
    public void isOnLeftTest(){
        TreeNode root = SortedListFromBinaryTree.init();
        Assert.assertEquals(getCommonAncesstor(root, root.left.left, root.right.right).data, root.data);
    }
}
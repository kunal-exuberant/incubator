package likedriving.problemsolving.Tree;

import org.junit.Assert;
import org.junit.Test;

public class LCA {


    public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b){

        if(root == null) return root;
        if(a == null && b == null) return root;
        if(a == null) return b;
        if(b == null) return a;

        boolean left = checkIfExists(root, a);
        boolean right = checkIfExists(root, b);

        if(left && right) return root;
        if(left) return root.left;
        if(right) return  root.right;

        return root;
    }

    private boolean checkIfExists(TreeNode root, TreeNode a) {
        if(root == null) return false;
        if(root == a) return true;
        return checkIfExists(root.left, a) || checkIfExists(root.right, a);
    }

    @Test
    public void findLCATest(){
        TreeNode root = new TreeNode(1);


        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode a = root.left;
        TreeNode b = root.left.right;

        Assert.assertEquals("Not Equal", root.left, findLCA(root, a, b));
    }

}

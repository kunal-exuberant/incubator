package likedriving.problemsolving.Tree;

import org.junit.Assert;
import org.junit.Test;

public class BST {


    public boolean isBST(TreeNode root, int min, int max){

        if(root == null){
            return true;
        }

        boolean isLeftBST = true;
        boolean isRightBST = true;

        if(root.data < min || root.data > max){
            return false;
        }

        if(root.left != null){
            isLeftBST = isBST(root.left, min, root.data-1);
        }

        if (root.right != null){
            isRightBST = isBST(root.right, root.data+1, max);
        }

        return isLeftBST && isRightBST;
    }

    @Test
    public void isBSTTest(){

        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-1);

        int INT_MIN = -242342342;
        int INT_MAX = 242342342;

        Assert.assertEquals(true, isBST(treeNode, INT_MIN, INT_MAX));


        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);

        //Assert.assertEquals("It is not valid BST", true, isBST(treeNode, INT_MIN, INT_MAX));


        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);

        //Assert.assertEquals("It is not valid BST", true, isBST(treeNode, INT_MIN, INT_MAX));


        treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(30);

        treeNode.right.left = new TreeNode(10);

        treeNode.right.left.right = new TreeNode(15);

        treeNode.right.left.right.right = new TreeNode(45);


       // Assert.assertEquals("It is not valid BST", true, isBST(treeNode, INT_MIN, INT_MAX));

    }

}

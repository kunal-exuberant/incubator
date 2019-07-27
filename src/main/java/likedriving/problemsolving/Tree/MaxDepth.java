package likedriving.problemsolving.Tree;

import org.junit.Assert;
import org.junit.Test;

public class MaxDepth {


    static TreeNode init(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        root.left.left.left = new TreeNode(24);
        root.left.left.right = new TreeNode(56);
        root.left.right.left = new TreeNode(12);
        root.left.right.right = new TreeNode(56);

        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(74);

        return root;
    }

    static int maxDepth = 0;

    public int getMaxDepthBinaryTree(TreeNode node){
        return maxDepth(node, 0);
    }

    int maxDepth(TreeNode root, int depth){

        if(root == null) {
            return maxDepth;
        }

        depth++;

        if(root.left == null && root.right == null){
            maxDepth = depth > maxDepth ? depth : maxDepth;
        }

        maxDepth(root.left, depth);
        maxDepth(root.right, depth);

        return maxDepth;
    }

    @Test
    public void getMaxDepthBinaryTreeTest(){
        TreeNode root = init();
        Assert.assertEquals("Tree length is unexpected", getMaxDepthBinaryTree(root),4);
    }
}

package likedriving.problemsolving.Tree;

import org.junit.Assert;
import org.junit.Test;

public class ConstructTree {

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder.length < 1 || inorder.length < 1){
                throw new IllegalArgumentException("cannot build tree");
            }
            return buildTree(preorder, inorder, 0, inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){

            int rootIndex = start;
            TreeNode root = new TreeNode(preorder[rootIndex]);

            int inorderRootIndex = searchUtil(inorder, root.data);

            if(inorderRootIndex != -1){
                root.left = buildTree(preorder, inorder, start, inorderRootIndex-1);
                root.right = buildTree(preorder, inorder, inorderRootIndex+1, end);
            }

            return root;

        }

        private int searchUtil(int [] array, int element) {
            int index = 0;
            for(int x: array){
                if(x==element){
                    return index;
                }
                index++;
            }
            return -1;
        }

    @Test
    public void buildTreeTest(){
        int [] preorder = new int[] {3,9,20,15,7};
        int [] inorder = new int [] {9,3,15,20,7};
        Assert.assertEquals("Tree not constructed", buildTree(preorder, inorder).data, new TreeNode(3).data);
        Assert.assertEquals("Tree not constructed", buildTree(preorder, inorder).left.data, 4);
    }

}

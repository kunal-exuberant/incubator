package likedriving.problemsolving.Tree;
/*
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementInBST {
    private int kthSmallest = -1;
    private int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 0) return -1;
        kthSmallest(root.left, k);

        count++;
        if(k == count){
            if(kthSmallest == -1){
                kthSmallest = root.data;
            }
            return kthSmallest;
        }

        kthSmallest(root.right, k);
        return kthSmallest;
    }
}

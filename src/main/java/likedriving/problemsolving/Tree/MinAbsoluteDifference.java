/*
package likedriving.problemsolving.Tree;

public class MinAbsoluteDifference {

    public int getMinAbsDiff(TreeNode root, int diff){

        if(root == null) throw new IllegalArgumentException("Tree must have at least two nodes");

        if(root.left == null || root.right == null) {

            int minDiff = Integer.MAX_VALUE;
            int diff = minDiff;
            if (root.left != null) {

                diff = root.data - root.left.data;
                if (minDiff > diff) minDiff = diff;
            }

            if (root.right != null) {
                diff = root.right.data - root.data;
                if (minDiff > diff) minDiff = diff;
            }
            return minDiff;
        }

        int leftMin = getMinAbsDiff(root.left);

        int rightMin = getMinAbsDiff(root.right);

        return Math.min(leftMin, rightMin);


    }
}
*/

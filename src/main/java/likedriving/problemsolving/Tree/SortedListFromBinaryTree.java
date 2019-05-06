package likedriving.problemsolving.Tree;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}

public class SortedListFromBinaryTree {

     static TreeNode init(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

/*        root.left.left.left = new TreeNode(24);
        root.left.left.right = new TreeNode(56);
        root.left.right.left = new TreeNode(12);
        root.left.right.right = new TreeNode(56);

        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(74);*/

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = init();
        int [] mergedList = new int[7];
        int [] list = getSortedList(root, mergedList, 0);
        //System.out.println("checking what is being returned: " +head.data);

        for (int x: list){
           // System.out.print(x+" ");
        }
    }

    private static int [] getSortedList(TreeNode root, int [] mergedList, int index){

        if(root != null) {
            //System.out.print(root.data+" ");
            if(root.left == null && root.right == null){
                mergedList[index++] = root.data;
                //System.out.print(root.data+" ");
                return mergedList;
            }
            int[] leftSortedList = getSortedList(root.left, mergedList, index);
            for(int x: leftSortedList) System.out.print(x+" ");
            int[] rightSortedList = getSortedList(root.right, mergedList, index);
            return mergeSort(leftSortedList, rightSortedList);
        }
        return new int[0];
    }

    private static int [] mergeSort(int [] leftList, int [] rightList){
        //for(int x: leftList) System.out.print(x+" ");
        int [] mergedList = new int[leftList.length+rightList.length];

        int i=0, j=0,k = 0;
        for(i=0, j=0; i< leftList.length && j < rightList.length;){
            if(rightList[i] > leftList[i]){
                mergedList[k] = leftList[i];
                i++;
            }
            else{
                mergedList[k] = rightList[j];
                j++;
            }
            k++;
        }


        while (i< leftList.length){
            mergedList[k] = leftList[i];
            i++;
            k++;
        }

        while (j < rightList.length){
            mergedList[k] = rightList[j];
            j++;
            k++;
        }
        return mergedList;
    }
}
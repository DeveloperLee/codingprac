package binarytree;

/**
 * Created by EricLee on 10/21/16.
 *
 * Use an extra boolean value to let the child know whether it's a left child node or not.
 */
public class SumOfAllLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return getSumOfLeftLeaves(root.left, true) + getSumOfLeftLeaves(root.right, false);
    }

    public int getSumOfLeftLeaves(TreeNode root, boolean isLeftChild) {
        if (root == null) return 0;
        if (isLeftChild && root.left == null && root.right == null) return root.val;
        return getSumOfLeftLeaves(root.left, true) + getSumOfLeftLeaves(root.right, false);
    }
}

package binarytree;

/**
 * Created by EricLee on 10/19/16.
 *
 * Remember that only check whether the current node is less than it's right child and smaller than
 * it's left child is not enough. The correct solution is as we traverse from top to bottom, we need
 * to record a range that the current node should in. If the current node isn't in this range, then
 * this tree is not a valid BST. Each time we move left, we update the maximum value since the current
 * node's value should be bigger than any node's value in its left sub tree. Similarly, we update the
 * minimum value since the current node value should be smaller than any node's value in its right
 * sub tree.
 */
public class ValidateBST {

    // O(N) Time and O(H) Stack space O(1) extra space
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return checkIsValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean checkIsValidBST(TreeNode root, long maximum, long minimum) {
        if (root == null) return true;
        if (root.val >= maximum || root.val <= minimum) return false;
        return checkIsValidBST(root.left, root.val, minimum) && checkIsValidBST(root.right, maximum, root.val);
    }
}

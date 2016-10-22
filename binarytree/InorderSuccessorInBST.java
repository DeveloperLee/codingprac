package binarytree;

/**
 * Created by EricLee on 10/20/16.
 */
public class InorderSuccessorInBST {

    // O(logn) Time O(H) Stack space
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}

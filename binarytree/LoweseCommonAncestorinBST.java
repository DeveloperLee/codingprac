package binarytree;

/**
 * Created by EricLee on 10/19/16.
 */
public class LoweseCommonAncestorinBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        if ((root.val - p.val) * (root.val - q.val) < 0) return root;
        return root.val < Math.min(p.val, q.val) ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }
}

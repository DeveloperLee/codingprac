package binarytree;

/**
 * Created by EricLee on 10/18/16.
 */
public class ConstructFromPreInTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) return null;
        // The root of the current subtree is always the first element in pre-order array.
        TreeNode root = new TreeNode(preorder[ps]);
        // Find the index of the current subtree root in in-order array.
        // The left sub-tree values are on the left side of the index and the right sub-tree
        // values are on the right side of the index.
        int index = findIndexInInorderArray(inorder, is, ie, root.val);
        root.left = build(preorder, ps + 1, ps + index - is, inorder, is, index);
        root.right = build(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return root;
    }

    // The search range is based on the current start and end point in the
    // inorder array.
    public int findIndexInInorderArray(int[] inorder, int start, int end, int target) {
        int i = start;
        while (i++ <= end && inorder[i] != target) i++;
        return i;
    }
}

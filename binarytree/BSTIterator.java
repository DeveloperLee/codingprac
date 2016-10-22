package binarytree;

import java.util.Stack;

/**
 * Created by EricLee on 10/21/16.
 *
 * The idea is that.
 */

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushTillLeftMost(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushTillLeftMost(node.right);
        return node.val;
    }

    public void pushTillLeftMost(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
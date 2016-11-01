package binarytree;

import java.util.*;

/**
 * Created by EricLee on 10/22/16.
 */
public class LevelOrderTraversal {

    // O(N) Time O(maxNodes) Space
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            int size = level.size();
            List<Integer> levelVals = new ArrayList<>();
            while (size != 0) {
                TreeNode node = level.poll();
                levelVals.add(node.val);
                if (node.left != null) level.add(node.left);
                if (node.right != null) level.add(node.right);
                size--;
            }
            result.add(levelVals);
        }
        return result;
    }
}

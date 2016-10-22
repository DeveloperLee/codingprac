package search.breathfirstsearch;

import java.util.*;

/**
 * Created by EricLee on 10/20/16.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copiedNode = new UndirectedGraphNode(node.label);
        map.put(node.label, copiedNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                UndirectedGraphNode currentNode = queue.poll();
                UndirectedGraphNode newNode = map.get(currentNode.label);
                for (UndirectedGraphNode child : currentNode.neighbors) {
                    if (!map.containsKey(child.label)) {
                        map.put(child.label, new UndirectedGraphNode(child.label));
                        queue.offer(child);
                    }
                    newNode.neighbors.add(map.get(child.label));
                }
                map.put(currentNode.label, newNode);
                size--;
            }
        }
        return copiedNode;
    }
}

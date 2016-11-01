package search.depthfirstsearch;

import java.util.*;

/**
 * Created by EricLee on 10/22/16.
 */
public class GraphValidTree {

    // O(n) Time
    // Worst case O(n) Space
    // Average case O(logn) space
    // Best case O(logn) Space
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        if (!dfs(graph, visited, 0, -1)) return false;
        return visited.size() == n;
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int current, int parent) {
        if (!graph.containsKey(current)) return true;
        for (int neighbour : graph.get(current)) {
            if (neighbour == parent) continue;
            if (visited.add(neighbour)) {
                if (!dfs(graph, visited, neighbour, current)) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

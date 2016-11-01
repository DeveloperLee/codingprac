package unionfind;

/**
 * Created by EricLee on 10/22/16.
 */
public class ValidGraphTree {

    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return true;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int parentA = find(parent, edge[0]);
            int parentB = find(parent, edge[1]);
            if (parentA == parentB) return false;
            //union
            parent[parentA] = parentB;
        }
        int connectedComp = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                if (connectedComp++ == 1) return false;
            }
        }
        return true;
    }

    public int find(int[] parent, int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
}

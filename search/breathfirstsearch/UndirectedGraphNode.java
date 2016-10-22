package search.breathfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/20/16.
 */
public class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

package search.breathfirstsearch;

import java.util.*;

/**
 * Created by EricLee on 10/22/16.
 */
public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        if (isValid(s)) return Collections.singletonList(s);
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String newState = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(newState)) {
                    if (isValid(newState)) {
                        result.add(newState);
                    } else {
                        if (result.size() == 0) queue.offer(newState);
                    }
                    visited.add(newState);
                }
            }
        }
        return result;
    }

    public boolean isValid(String str) {
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') open++;
            else if (str.charAt(i) == ')') {
                if (open-- == 0) return false;
            }
        }
        return open == 0;
    }
}

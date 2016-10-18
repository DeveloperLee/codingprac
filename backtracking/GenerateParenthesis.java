package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/17/16.
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        generateAllCombinations(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void generateAllCombinations(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (close == n) {
            result.add(sb.toString());
        } else {
            // Keep track of how many '(' we can still insert and insert '(' as many as possible
            if (open < n) {
                sb.append('(');
                generateAllCombinations(result, sb, open + 1, close, n);
                sb.deleteCharAt(sb.length() - 1);
            }
            // Each ')' closes a open '(' so once we get enough '('s, we start to close them.
            if (close < open) {
                sb.append(')');
                generateAllCombinations(result, sb, open, close + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

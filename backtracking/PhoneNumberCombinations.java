package backtracking;

import java.util.*;

/**
 * Created by EricLee on 10/19/16.
 */
public class PhoneNumberCombinations {

    // O(n^m) Time O(n^m) Space
    public List<String> letterCombinationsBFS(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        String[] dictionary = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // First level
        result.add("");
        int currentLength = -1;
        while (++currentLength < digits.length()) {
            while (result.peek().length() == currentLength) {
                String str = result.poll();
                for (char c : dictionary[digits.charAt(currentLength) - '0'].toCharArray()) {
                    result.add(str + c);
                }
            }
        }
        return result;
    }


    // DFS(Backtracking) Solution O(n^m) Time O(len(digits)) stack space
    public List<String> letterCombinationsDFS(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        Map<Character, String> map = new HashMap<>();
        buildMap(map);
        getAllCombinations(result, digits, new StringBuilder(), 0, map);
        return result;
    }

    public void getAllCombinations(List<String> result, String digits, StringBuilder sb, int position, Map<Character, String> map) {
        // Termination condition
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
        } else {
            String letters = map.get(digits.charAt(position));
            for (int j = 0; j < letters.length(); j++) {
                sb.append(letters.charAt(j));
                getAllCombinations(result, digits, sb, position + 1, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void buildMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}

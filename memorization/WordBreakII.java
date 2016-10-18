package memorization;

import java.util.*;

/**
 * Created by EricLee on 10/17/16.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return result;
        result = getAllSentences(s, wordDict, new HashMap<String, List<String>>());
        return result;
    }

    public List<String> getAllSentences(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        // Put an empty "" to mark a valid sentence.
        if (s.length() == 0) {
            List<String> terminated = new ArrayList<>();
            terminated.add("");
            return terminated;
        }
        // If there's no match found we return an empty array.
        List<String> memo = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (wordDict.contains(substring)) {
                List<String> subSentences = getAllSentences(s.substring(i), wordDict, map);
                for (String subSentence : subSentences) {
                    String newSentence = substring + (subSentence.equals("") ? "" : " ") + subSentence;
                    memo.add(newSentence);
                }
            }
        }
        map.put(s, memo);
        return memo;
    }
}

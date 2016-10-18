package dynamicprogramming;

import java.util.Set;

/**
 * Created by EricLee on 10/17/16.
 */
public class WordBreak {

    // O(n2) Time O(n) Space
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        // Dp array stores whether the substring (ends at current index) can be broken into a combination of different
        // words from the dictionary
        boolean[] canBreak = new boolean[s.length() + 1];
        // Dummy value
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && wordDict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                }
            }
        }
        return canBreak[s.length()];
    }
}

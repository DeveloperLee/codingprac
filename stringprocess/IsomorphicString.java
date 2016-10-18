package stringprocess;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricLee on 10/17/16.
 *
 * Classic HashMap question, we need two maps to record the s-t mapping and also
 * t-s mapping.
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (!map1.containsKey(chs)) map1.put(chs, cht);
            if (!map2.containsKey(cht)) map2.put(cht, chs);
            if (map1.get(chs) != cht || map2.get(cht) != chs) return false;
        }
        return true;
    }
}

package arrayprocess.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricLee on 10/19/16.
 *
 * We pre-process the second array and construct a frequency map.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "BAC";
        System.out.print(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int minPos = 0;
        int tail = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int index = 0;
        // Counter for determining whether we need to expand or shrink the current window.
        int counter = freqMap.size();
        char[] chs = s.toCharArray();
        while (index < s.length()) {
            if (freqMap.containsKey(chs[index])) {
                int frequency = freqMap.get(chs[index]) - 1;
                if (frequency == 0) counter--;
                freqMap.put(chs[index], frequency);
            }
            index++;
            while (counter == 0) {
                if (minLength > index - tail) {
                    minPos = tail;
                    minLength = index - tail;
                }
                if (freqMap.containsKey(chs[tail])) {
                    int frequency = freqMap.get(chs[tail]) + 1;
                    if (frequency > 0) counter++;
                    freqMap.put(chs[tail], frequency);
                }
                tail++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minPos, minPos + minLength);
    }
}

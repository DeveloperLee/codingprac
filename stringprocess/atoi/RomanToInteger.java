package stringprocess.atoi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricLee on 10/20/16.
 *
 * The rule is that, for any letter, if the number is less than it's right bit, then minus it from the final
 * result, otherwise, add it to the final result.
 * For instance:
 * XI = 10 + 1 = 11
 * IX = -1 + 10 = 9
 * LIX = 50 - 1 + 10 = 59
 * LXVI = 50 + 10 + 5 + 1 = 66
 */
public class RomanToInteger {

    // O(n) Time O(1) Space
    public int romanToInt(String s) {
        if (s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] arr = s.toCharArray();
        int sum = map.get(arr[s.length() - 1]);
        for (int i = s.length() - 2; i >= 0; i--) {
            int currentNum = map.get(arr[i]);
            int prevNum = map.get(arr[i + 1]);
            sum += currentNum < prevNum ? -currentNum : currentNum;
        }
        return sum;
    }
}

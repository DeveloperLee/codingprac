package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by EricLee on 10/18/16.
 */
public class GenerateAllLetterCombinations {

    public static void main(String[] args) {
        List<String> result = getAllCombinations("abcd");
        for (String str : result) {
            System.out.print(str + " ");
        }
    }

    public static List<String> getAllCombinations(String word) {
        List<String> result = new ArrayList<>();
        if (word == null || word.length() == 0) return result;
        generate(result, word.toCharArray(), 0, new HashSet<>());
        return result;
    }

    public static void generate(List<String> result, char[] array, int position, Set<String> set) {
        if (set.add(String.valueOf(array))) {
            result.add(String.valueOf(array));
        }
        if (position != array.length) {
            for (int i = position; i < array.length; i++) {
                if (!Character.isAlphabetic(array[i])) {
                    generate(result, array, i + 1, set);
                } else {
                    array[i] -= 32;
                    generate(result, array, i + 1, set);
                    array[i] += 32;
                }
            }
        }
    }
}

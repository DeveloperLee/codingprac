package probability;

import java.util.Random;

/**
 * Created by EricLee on 10/19/16.
 *
 * Reservoir sampling solution
 */
public class RandomPickIndex {

    private int[] numbers;
    private Random random;

    public RandomPickIndex(int[] nums) {
        numbers = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target && random.nextInt(++count) == 0) {
                result = i;
            }
        }
        return result;
    }
}

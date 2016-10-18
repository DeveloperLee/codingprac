package divideandconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EricLee on 10/17/16.
 *
 * The divide point is whenever we encounter a symbol. Once we encounter a symbol we
 * divide the original string into two halves. Until the string only contains number.
 * Then we merge two halves together based on the dividing symbol.
 */
public class DifferentWaysToCalculate {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        boolean noSymbol = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftPart = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(input.substring(i + 1));
                for (int left : leftPart) {
                    for (int right : rightPart) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else {
                            result.add(left * right);
                        }
                    }
                }
                noSymbol = false;
            }
        }
        if (noSymbol) result.add(Integer.parseInt(input));
        Collections.sort(result);
        return result;
    }
}

package stringprocess;

/**
 * Created by EricLee on 10/17/16.
 */
public class StringMultiplication {

    // O(mn) Time + O(1) extra space (excluding the result array)
    public String multiply(String num1, String num2) {
        // Corner cases
        if (num1 == null && num2 == null) return "";
        if (num1 == null || num2 == null) return num1 == null ? num2 : num1;

        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        // Get rid of leading zeros
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < result.length && result[index] == 0) index++;
        for (int i = index; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

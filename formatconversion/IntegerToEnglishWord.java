package formatconversion;

/**
 * Created by EricLee on 10/16/16.
 */
public class IntegerToEnglishWord {

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] quantities = {"Billion", "Million", "Thousand"};
        String[] lessthan20 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int base = (int)Math.pow(10, 9);
        StringBuilder sb = new StringBuilder();
        int baseLevel = 0;
        while (num != 0) {
            if (num >= base) {
                sb.append(getQuantity(num / base, lessthan20, tens));
                if (baseLevel < 3) sb.append(quantities[baseLevel] + " ");
            }
            num %= base;
            base /= 1000;
            baseLevel++;

        }
        return sb.toString();
    }

    public String getQuantity(int number, String[] lessthan20, String[] tens) {
        if (number == 0) return "";
        if (number < 20) {
            return lessthan20[number - 1] + " ";
        } else {
            if (number >= 100) {
                int hundredBase = number / 100;
                return lessthan20[hundredBase - 1] + " Hundred " + getQuantity(number % 100, lessthan20, tens);
            } else {
                int tenBase = number / 10;
                return tens[tenBase - 2] + " " + getQuantity(number % 10, lessthan20, tens);
            }
        }
    }
}

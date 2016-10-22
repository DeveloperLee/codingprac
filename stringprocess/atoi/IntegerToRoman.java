package stringprocess.atoi;

/**
 * Created by EricLee on 10/20/16.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        if (num <= 0) return "";
        String[] strDic = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numDic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num != 0) {
            while (num >= numDic[index]) {
                sb.append(strDic[index]);
                num -= numDic[index];
            }
            index++;
        }
        return sb.toString();
    }
}

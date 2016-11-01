package stringprocess.atoi;

/**
 * Created by EricLee on 10/22/16.
 */
public class IntToColumn {

    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int digit = (n - 1) % 26;
            sb.append((char)(digit + 'A'));
            n -= digit;
            n /= 26;
        }
        return sb.reverse().toString();
    }
}

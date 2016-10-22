package stringprocess;

/**
 * Created by EricLee on 10/21/16.
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        while (n != 1) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < result.length()) {
                char num = result.charAt(index);
                int count = 0;
                while (index < result.length() && result.charAt(index) == num) {
                    count++;
                    // Make sure index is increased here.
                    index++;
                }
                sb.append(count).append(num);
            }
            result = sb.toString();
            n--;
        }
        return result;
    }
}

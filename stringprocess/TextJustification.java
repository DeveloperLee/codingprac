package stringprocess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EricLee on 10/22/16.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth == 0) return Collections.singletonList(words[0]);
        List<String> result = new ArrayList<>();
        int lineStart = 0;
        while (lineStart < words.length) {
            // The end word of the line
            int lineLast = lineStart + 1;
            int lineWordLength = words[lineStart].length();
            while (lineLast < words.length && lineWordLength + words[lineLast].length() + 1 <= maxWidth) {
                lineWordLength += words[lineLast++].length() + 1;
            }

            // Justify the current line
            StringBuilder sb = new StringBuilder();
            int spaceIntervals = lineLast - lineStart - 1;
            // If there's only one word in the current line, or the current line is the last line.
            // Left justify
            if (spaceIntervals == 0 || lineLast == words.length) {
                for (int i = lineStart; i < lineLast; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                // Otherwise, do the normal justify.
                int totalSpaces = maxWidth - lineWordLength;
                int spacePerInterval = totalSpaces / spaceIntervals;
                int extraSpaceCount = totalSpaces % spaceIntervals;
                for (int i = lineStart; i < lineLast; i++) {
                    sb.append(words[i]);
                    if (i < lineLast - 1) {
                        for (int j = 0; j <= (spacePerInterval + (i - lineStart < extraSpaceCount ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            lineStart = lineLast;
        }
        return result;
    }
}

package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by EricLee on 10/17/16.
 *
 * This problem uses a prefix tree to accelerate the dfs search. By constructing a prefix tree,
 * we can terminate the recursion once we found that current prefix doesn't exist in our prefix tree,
 * which means none of the word in the dictionary has such a prefix. We should also be able to know
 * that whether current string is a prefix or a word. For example, we have a word abcd in the dictionary
 * and we're looking at abc, its a prefix but not a actual dictionary word. In order to keep the search
 * continue, one solution is to return different values for prefixes and words. Last thing is to
 * use a set to detect duplicate results. For example, matrix : "aa" dictionary : "a".
 */
public class WordSearchII {
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cursor = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cursor.children[c - 'a'] == null) {
                    cursor.children[c - 'a'] = new TrieNode();
                }
                cursor = cursor.children[c - 'a'];
                cursor.isPrefix = true;
            }
            cursor.isWord = true;
        }

        public int search(String word) {
            TrieNode cursor = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cursor.children[c - 'a'] == null) return -1;
                cursor = cursor.children[c - 'a'];
            }
            if (cursor.isPrefix && !cursor.isWord) return 0;
            return 1;
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        boolean isPrefix;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || words == null) return result;
        // Construct a prefix tree based on given words
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> resultHolder = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.search(String.valueOf(board[i][j])) != -1) {
                    dfs(board, visited, resultHolder, new StringBuilder(), trie, i, j);
                }
            }
        }
        for (String str : resultHolder) {
            result.add(str);
        }
        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, Set<String> result, StringBuilder sb, Trie trie, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (visited[row][col]) return;
        sb.append(board[row][col]);
        // There's no such prefix / word in the trie so we don't need to go further.
        if (trie.search(sb.toString()) == -1) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        visited[row][col] = true;
        // If we found a matching word, add it to result
        if (trie.search(sb.toString()) == 1) result.add(sb.toString());
        // Then we continue to search surrounding cells
        dfs(board, visited, result, sb, trie, row + 1, col);
        dfs(board, visited, result, sb, trie, row - 1, col);
        dfs(board, visited, result, sb, trie, row, col + 1);
        dfs(board, visited, result, sb, trie, row, col - 1);
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}

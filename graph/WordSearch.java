package graph;

/**
 * Created by EricLee on 10/17/16.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findMatch(board, 0, i, j, word)) return true;
                }
            }
        }
        return false;
    }

    public boolean findMatch(char[][] board, int pos, int row, int col, String word) {
        if (pos == word.length()) return true;
        if (!isValidMove(board, word.charAt(pos), row, col)) return false;
        // Tricky part xor any character with 256 will result in inequality with any unicode character
        board[row][col] ^= 256;
        if (findMatch(board, pos + 1, row + 1, col, word)) return true;
        if (findMatch(board, pos + 1, row - 1, col, word)) return true;
        if (findMatch(board, pos + 1, row, col + 1, word)) return true;
        if (findMatch(board, pos + 1, row, col - 1, word)) return true;
        board[row][col] ^= 256;
        return false;
    }

    public boolean isValidMove(char[][] board, char c, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != c) return false;
        return true;
    }
}

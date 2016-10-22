package arrayprocess;

/**
 * Created by EricLee on 10/21/16.
 */
public class RotateMatrix {

    public void rotateInPlace(int[][] matrix) {
        if (matrix == null) return;
        for (int col = 0; col < matrix[0].length; col++) {
            int lo = 0;
            int hi = matrix.length - 1;
            while (lo < hi) swap(matrix, lo++, col, hi--, col);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix[0].length; col++) {
                swap(matrix, row, col, col, row);
            }
        }
    }

    public void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp =  matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                newMatrix[col][matrix.length - 1 - row] = matrix[row][col];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = newMatrix[row][col];
            }
        }
    }
}

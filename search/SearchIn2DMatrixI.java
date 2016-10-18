package search;

/**
 * Created by EricLee on 10/17/16.
 */
public class SearchIn2DMatrixI {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        System.out.print(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int rowLo = 0;
        int rowHi = matrix.length - 1;
        while (rowLo + 1 < rowHi) {
            int mid = rowLo + (rowHi - rowLo) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) rowHi = mid - 1;
            else rowLo = mid;
        }

        int colLo = 0;
        int colHi = matrix[0].length - 1;
        while (colLo <= colHi) {
            int mid = colLo + (colHi - colLo) / 2;
            if (matrix[rowLo][mid] == target) return true;
            if (matrix[rowLo][mid] > target) colHi = mid - 1;
            else colLo = mid + 1;
        }
        return false;
    }
}

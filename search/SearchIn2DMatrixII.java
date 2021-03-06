package search;

/**
 * Created by EricLee on 10/17/16.
 */
public class SearchIn2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}

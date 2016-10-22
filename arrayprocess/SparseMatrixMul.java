package arrayprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/21/16.
 */
public class SparseMatrixMul {

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}, {2, 0, 0}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        multiply(A, B);
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) return new int[0][0];
        List<Integer>[] compA = new List[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (compA[i] == null) {

                    List<Integer> list = new ArrayList<>();
                    compA[i] = list;
                }
                if (A[i][j] != 0) {
                    compA[i].add(j);
                    compA[i].add(A[i][j]);
                }
            }
        }
        List<Integer>[] compB = new List[B[0].length];
        for (int i = 0; i < B[0].length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (compB[i] == null) {
                    List<Integer> list = new ArrayList<>();
                    compB[i] = list;
                }
                if (B[j][i] != 0) {
                    compB[i].add(j);
                    compB[i].add(B[j][i]);
                }
            }
        }

        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            List<Integer> rowA = compA[i];
            for (int j = 0; j < B[0].length; j++) {
                List<Integer> colB = compB[j];
                for (int indexA = 0, indexB = 0; indexA < rowA.size() && indexB < colB.size();) {
                    if (rowA.get(indexA) == colB.get(indexB)) {
                        result[i][j] += rowA.get(indexA + 1) * colB.get(indexB + 1);
                        indexA += 2;
                        indexB += 2;
                    } else if (rowA.get(indexA) < colB.get(indexB)) {
                        indexA += 2;
                    }  else {
                        indexB += 2;
                    }
                }
            }
        }
        return result;
    }
}

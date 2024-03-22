package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode304 {

    class NumMatrix {


        int[][] preSumMatrix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            preSumMatrix = new int[m + 1][n + 1];
            for (int i = 1; i < preSumMatrix.length; i++) {
                for (int j = 1; j < preSumMatrix[0].length; j++) {
                    //[i - 1][j]和[i][j - 1]都是从[i - 1][j - 1]出发的重复加了所以要减去[i - 1][j - 1]
                    preSumMatrix[i][j] = preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] - preSumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSumMatrix[row2 + 1][col2 + 1] - preSumMatrix[row1][col2 + 1] - preSumMatrix[row2 + 1][col1] + preSumMatrix[row1][col1];
        }
    }

}

package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        //镜像对称
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //swap nums[i][j] nums[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //反转每一行
        for (int[] nums : matrix) {
            reverse(nums);
        }
    }

    public void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    //如果逆时针旋转90度呢？
    public void rotateV2(int[][] matrix) {
        //镜像对称
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //swap nums[i][j] nums[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }

        //反转每一行
        for (int[] nums : matrix) {
            reverse(nums);
        }
    }

}

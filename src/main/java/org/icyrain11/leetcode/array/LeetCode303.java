package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode303 {

    class NumArray {

        int[] preSumNums;

        public NumArray(int[] nums) {
            preSumNums = new int[nums.length + 1];
            for (int i = 1; i < preSumNums.length; i++) {
                preSumNums[i] = preSumNums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSumNums[right + 1] - preSumNums[left];
        }
    }

}

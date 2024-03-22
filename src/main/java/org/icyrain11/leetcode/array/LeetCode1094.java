package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1094 {

    class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }

    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            difference.increment(i, j, val);
        }

        int[] result = difference.result();
        for (int i : result) {
            if (capacity < i) {
                return false;
            }
        }

        return true;
    }

}

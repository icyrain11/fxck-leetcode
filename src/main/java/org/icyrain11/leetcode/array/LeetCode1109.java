package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1109 {

    class Difference {
        int[] diff;

        public Difference(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return;
            }
            diff = new int[n];
            diff[0] = nums[0];
            for (int i = 1; i < n; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

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

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }

        return difference.result();
    }

}

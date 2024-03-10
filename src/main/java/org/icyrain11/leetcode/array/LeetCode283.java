package org.icyrain11.leetcode.array;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode283 {


    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (; slow < n; slow++) {
            nums[slow] = 0;
        }
    }
}

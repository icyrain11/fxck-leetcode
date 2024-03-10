package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


}

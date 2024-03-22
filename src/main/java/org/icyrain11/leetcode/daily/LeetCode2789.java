package org.icyrain11.leetcode.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode2789 {

//
//    输入：nums = [2,3,7,9,3]
//    输出：21

    public static long maxArrayValue(int[] nums) {
        long max = 0;
        //base case
        if (nums.length == 0) {
            return max;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            stack.push(num);
        }

        max = stack.pop();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            // num[i] <= num[i+1],更新 num[i]
            if (max >= cur) {
                max += cur;
            } else {
                max = cur;
            }
        }

        return max;
    }


    public long maxArrayValueV2(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? sum + nums[i] : nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 9, 3};
        long maxVal = maxArrayValue(nums);
        System.out.println(maxVal);
    }

}

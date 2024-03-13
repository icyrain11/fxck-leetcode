package org.icyrain11.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    /**
     * 三树之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> twoSumList = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> twoSum : twoSumList) {
                List<Integer> threeSum = new ArrayList<>(twoSum);
                threeSum.add(nums[i]);
                res.add(threeSum);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        //base case
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (sum < target) {
                //去重
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                //去重
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> list = List.of(left, right);
                res.add(list);
                //去重
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }

        return res;
    }

    /**
     * n数之和
     *
     * @param nums
     * @param start
     * @param n
     * @param target
     * @return
     */
    public List<List<Integer>> nSumTarget(int[] nums, int start, int n, int target) {
        //base case
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (nums.length == 0 || n < 2 || length < n) {
            return res;
        }

        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    //去重
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    //去重
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> list = List.of(left, right);
                    res.add(list);
                    //去重
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < length; i++) {
                List<List<Integer>> subSumTargetTuple = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> subSumTarget : subSumTargetTuple) {
                    List<Integer> threeSum = new ArrayList<>(subSumTarget);
                    threeSum.add(nums[i]);
                    res.add(threeSum);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2, 3};
        List<List<Integer>> lists = twoSumTarget(nums, 0, 4);
        System.out.println("lists = " + lists);
    }

}

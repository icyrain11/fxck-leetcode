package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

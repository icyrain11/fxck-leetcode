package org.icyrain11.leetcode.array;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode5 {

    /**
     * 中心扩散法考虑奇数偶数情况
     */

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = validPalindrome(i, i, s);
            String s2 = validPalindrome(i, i + 1, s);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String validPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //先判断left >= 0 所以left + 1 s.subString [left , right)因为右开所以就不用 + 1了
        return s.substring(left + 1, right);
    }


    public static void main(String[] args) {
        String res = "123456";
        String substring = res.substring(5, 6);
        System.out.println("substring = " + substring);
    }


}

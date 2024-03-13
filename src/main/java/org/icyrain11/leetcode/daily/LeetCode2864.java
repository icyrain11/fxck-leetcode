package org.icyrain11.leetcode.daily;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode2864 {

    public static String maximumOddBinaryNumber(String s) {
        //base case
        if (s == null || s.isBlank()) {
            return s;
        }

        int count = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '1') {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (count - 1 != 0) {
                sb.append('1');
                count--;
            } else {
                sb.append('0');
            }
        }
        sb.append('1');
        return sb.toString();
    }


    public static String maximumOddBinaryNumberV2(String s) {
        int count = (int) s.chars().filter(c -> c == '1').count();
        return "1".repeat(count - 1) + "0".repeat(s.length() - count) + "1";
    }

}

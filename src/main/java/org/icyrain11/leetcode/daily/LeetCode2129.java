package org.icyrain11.leetcode.daily;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode2129 {
    public String capitalizeTitle(String title) {
        if (title == null || title.isBlank()) {
            return title;
        }
        StringBuilder ans = new StringBuilder();
        for (String s : title.split(" ")) {
            if (!ans.isEmpty()) {
                ans.append(' ');
            }
            if (s.length() > 2) {
                ans.append(s.substring(0, 1).toUpperCase()); // 首字母大写
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }
}

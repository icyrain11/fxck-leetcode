package org.icyrain11.leetcode.listnode;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode234 {

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return validPalindrome(head);
    }

    public boolean validPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = validPalindrome(head.next);
        res = res & left.val == head.val;
        left = left.next;
        return res;
    }

}

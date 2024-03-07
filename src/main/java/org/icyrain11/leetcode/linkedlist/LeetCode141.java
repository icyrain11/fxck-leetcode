package org.icyrain11.leetcode.linkedlist;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

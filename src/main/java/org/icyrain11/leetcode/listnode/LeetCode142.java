package org.icyrain11.leetcode.listnode;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast != null && fast.next != null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}

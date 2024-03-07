package org.icyrain11.leetcode.listnode;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            //not enough
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        ListNode newNode = reverseList(fast, head);
        head.next = reverseKGroup(fast, k);
        return newNode;
    }


    public ListNode reverseList(ListNode fast, ListNode slow) {
        ListNode pre = null;
        ListNode cur = slow;
        ListNode next;
        while (cur != fast) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

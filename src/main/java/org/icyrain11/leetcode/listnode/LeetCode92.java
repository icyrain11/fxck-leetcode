package org.icyrain11.leetcode.listnode;

import com.sun.jdi.connect.spi.TransportService;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseListNode(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor;

    public ListNode reverseListNode(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseListNode(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


}

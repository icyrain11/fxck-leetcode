package org.icyrain11.leetcode.listnode;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        //[1, 2, 3, 4, 5]
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public ListNode reverseListV2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}

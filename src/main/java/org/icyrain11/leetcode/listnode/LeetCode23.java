package org.icyrain11.leetcode.listnode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author icyrain11
 * @version 17
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            dummy.next = cur;
            dummy = dummy.next;
            //add into queue
            if (cur.next != null) {
                priorityQueue.add(cur.next);
            }
        }

        return res.next;

    }
}

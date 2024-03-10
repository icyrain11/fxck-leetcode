package org.icyrain11.leetcode;

import org.icyrain11.leetcode.listnode.ListNode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author icyrain11
 * @version 17
 */
public class Main {

    public ListNode mergeKLists(ListNode[] lists) {
        //base case
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            priorityQueue.offer(listNode);
        }

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) {
                node = node.next;
                priorityQueue.offer(node);
            }
        }

        return res.next;
    }
}

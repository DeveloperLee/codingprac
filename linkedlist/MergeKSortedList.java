package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by EricLee on 10/20/16.
 */
public class MergeKSortedList {


    // O(nlogk) Time O(k) Space
    // n is the total number of node and k is the list size
    public ListNode mergeKListsWithHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        for (ListNode head : lists) {
            if (head != null) queue.offer(head);
        }

        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            pre.next = next;
            pre = pre.next;
            if (next.next != null) queue.offer(next.next);
        }

        return dummy.next;
    }
}

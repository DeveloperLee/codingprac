package divideandconquer;

import linkedlist.ListNode;

/**
 * Created by EricLee on 10/20/16.
 */
public class MergeKSortedList {

    // O(nlogk) Time O(logk) Stack space
    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists == null) return null;
        return divideAndMerge(lists, 0, lists.length - 1);
    }

    public ListNode divideAndMerge(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        if (start + 1 == end) return mergeTwoLists(lists[start], lists[end]);
        int mid = start + (end - start) / 2;
        return mergeTwoLists(divideAndMerge(lists, start, mid), divideAndMerge(lists, mid + 1, end));
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        pre.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}

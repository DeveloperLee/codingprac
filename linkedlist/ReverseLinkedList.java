package linkedlist;

/**
 * Created by EricLee on 10/20/16.
 */
public class ReverseLinkedList {

    // O(N) Time O(1) Space
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

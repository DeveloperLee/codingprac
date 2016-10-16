package linkedlist;

/**
 * Created by EricLee on 10/15/16.
 */
public class CopyLinkedListWithRandomPtr {

    public RandomListNode copyRandomList(RandomListNode head) {
        // Invalid input, no need to copy, return null.
        if (head == null) return null;

        // For every original node, make a copy of it and inserts between
        // two original nodes. A -> A(copy) -> B -> B(copy) ->....
        RandomListNode cursor = head;
        while (cursor != null) {
            RandomListNode newNode = new RandomListNode(cursor.label);
            newNode.next = cursor.next;
            cursor.next = newNode;
            cursor = cursor.next.next;
        }

        // Copy the random pointer for each copied node.
        cursor = head;
        RandomListNode newCursor = cursor.next;
        while (cursor != null) {
            if (cursor.random != null) {
                newCursor.random = cursor.random.next;
            }
            if (newCursor.next != null) {
                newCursor = newCursor.next.next;
            }
            cursor = cursor.next.next;
        }

        // Detach the link between the original nodes and copied nodes.
        // Then link all original and copied nodes together respectively.
        cursor = head;
        RandomListNode newHead = cursor.next;
        newCursor = newHead;
        while (cursor != null) {
            cursor.next = newCursor.next;
            if (newCursor.next != null) {
                newCursor.next = newCursor.next.next;
            }
            cursor = cursor.next;
            newCursor = newCursor.next;
        }

        return newHead;
    }
}

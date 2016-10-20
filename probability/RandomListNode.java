package probability;

import linkedlist.ListNode;

import java.util.Random;

/**
 * Created by EricLee on 10/19/16.
 */
public class RandomListNode {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomListNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = -1;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            if (random.nextInt(++count) == 0) {
                result = cur.val;
            }
            cur = cur.next;
        }
        return result;
    }
}

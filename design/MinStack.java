package design;

import java.util.Stack;

/**
 * Created by EricLee on 10/17/16.
 *
 * Each time we're going to put a value that is smaller than min, we push both the previous min
 * and the current number (new min) into the stack and update the min value. This is because when
 * the new min value is popped out, we're always able to now the previous min since the previous
 * min is always behind the new min.
 */
public class MinStack {

    private int min;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x > min) {
            stack.push(x);
        } else {
            stack.push(min);
            stack.push(x);
            min = x;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (top() == min) {
                stack.pop();
                min = stack.pop();
            } else {
                stack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
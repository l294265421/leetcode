package leetcode232;

import java.util.Stack;

/**
 *
Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 * @author liyuncong
 *
 */
public class ImplementQueueUsingStacks {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> helper = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
    	stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack1ToStack2(stack, helper);
        helper.pop();
        stack1ToStack2(helper, stack);
    }

    // Get the front element.
    public int peek() {
        stack1ToStack2(stack, helper);
        int result = helper.peek();
        stack1ToStack2(helper, stack);
        return result;
    }
    
    /**
     * 把stack1中的元素放进stack2中,结果是stack1的栈顶元素成了stack2的栈底元素，结果是stack1的栈底元素成了stack2的栈顶元素
     * @param stack1
     * @param stack2
     */
    private void stack1ToStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
    	 while (!stack1.isEmpty()) {
    		 stack2.push(stack1.pop());
 		}
	}

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}

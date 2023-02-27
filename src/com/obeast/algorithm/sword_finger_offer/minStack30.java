package com.obeast.algorithm.sword_finger_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wxl
 * Date 2023/2/24 9:30
 * @version 1.0
 * Description:剑指 Offer 30. 包含min函数的栈
 */
public class minStack30 {
    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}

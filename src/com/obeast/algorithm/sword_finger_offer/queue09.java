package com.obeast.algorithm.sword_finger_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wxl
 * Date 2023/2/24 9:21
 * @version 1.0
 * Description:剑指 Offer 09. 用两个栈实现队列
 */
public class queue09 {

    class CQueue {

        Deque<Integer> inputStack;
        Deque<Integer> outputStack;
        public CQueue() {
            inputStack = new ArrayDeque<>();
            outputStack = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            inputStack.push(value);
        }

        public int deleteHead() {
//            加个缓存
            if(outputStack.isEmpty()){
                if (inputStack.isEmpty()){
                    return -1;
                }
                while (!inputStack.isEmpty()){
                    Integer tail = inputStack.pop();
                    outputStack.push(tail);
                }
            }
            return outputStack.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}

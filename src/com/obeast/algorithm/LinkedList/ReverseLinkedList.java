package com.obeast.algorithm.LinkedList;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wxl
 * Date 2023/2/25 11:24
 * @version 1.0
 * Description:linked
 */
public class ReverseLinkedList {


    static class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public static ListNode  setNums (int[] nums) {
            ListNode listNode = new ListNode(nums[0]);
            ListNode cur  = listNode;
            for (int i = 1; i < nums.length; i++){
                ListNode node = new ListNode(nums[i]);
                cur.setNext(node);
                cur = cur.next;
            }
            return listNode;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5};
        ListNode listNode = ListNode.setNums(num);
        reverseList(listNode);
    }

    /**
     * Description:  Offer 35. 复杂链表的复制
     * @author wxl
     * Date: 2023/2/26 18:47
     * @param head
     * @return Node
     */
    Map<RandomNode, RandomNode> cacheNode = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return head;
        }
        if (!cacheNode.containsKey(head)) {
            RandomNode newNode = new RandomNode(head.val);
            cacheNode.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }




    /**
     * Description: 剑指 Offer 24. 反转链表
     * @author wxl
     * Date: 2023/2/26 18:41
     * @param head head
     * @return com.obeast.algorithm.LinkedList.ReverseLinkedList.ListNode
     */

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode res = null;
        while (temp != null) {
            ListNode next = temp.next;
           temp.next = res;
            res = temp;
            temp = next;
        }
        return res;
    }

    /**
     * Description: 从尾到头打印链表
     * 剑指 Offer 06. 从尾到头打印链表
     * @author wxl
     * Date: 2023/2/26 17:40
     * @param head
     * @return int[]
     */

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode nextNode = head;
        while (nextNode.next != null) {
            stack.push(nextNode.val);
            nextNode = nextNode.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;

    }
}

package com.obeast.algorithm.LinkedList;

/**
 * @author wxl
 * Date 2022/8/9 18:13
 * @version 1.0
 * Description: 141. 环形链表
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode node = new ListNode(1, two);

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null ){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}




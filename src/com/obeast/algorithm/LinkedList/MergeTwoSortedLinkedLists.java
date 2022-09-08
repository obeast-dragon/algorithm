package com.obeast.algorithm.LinkedList;

/**
 * @author wxl
 * Date 2022/8/22 14:29
 * @version 1.0
 * Description: 21. 合并两个有序链表
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 *
 */
public class MergeTwoSortedLinkedLists {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists3(l1, l2));
    }




    /**
     * Description: 迭代
     * @author wxl
     * Date: 2022/8/22 16:32
     * @return com.obeast.algorithm.LinkedList.ListNode
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    /**
     * Description: 递归
     * @author wxl
     * Date: 2022/8/22 16:36
     * @return com.obeast.algorithm.LinkedList.ListNode
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    //    test
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2);
            return list2;
        }
    }


}

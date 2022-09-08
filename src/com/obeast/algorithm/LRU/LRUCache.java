package com.obeast.algorithm.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxl
 * Date 2022/8/10 22:16
 * @version 1.0
 * Description:146. LRU 缓存策略
 */
public class LRUCache {
    HashMap<Integer, Node> map;
    DoubleLinkedList cache;
    int cap;
    public LRUCache(int capacity){
        map   = new HashMap<>();
        cache = new DoubleLinkedList();
        cap   = capacity;
    }

    public void put(int key, int val){
        Node newNode = new Node(key, val);

        if(map.containsKey(key)){
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        }else{
            if(map.size() == cap){
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);

        }
    }

    public int get(int key){
        if(!map.containsKey(key))   return -1;

        int val = map.get(key).value;
        put(key, val);

        return val;
    }
}

/**
 * @author wxl
 * Date 2022/8/10 23:16
 * @version 1.0
 * Description: head: recently used;
 * tail: LRU
 */
class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        //初始化节点 相当于虚拟节点
        head = new Node(0, 0);
        tail = new Node(0, 0);

        //连接指针 相当于虚拟节点
        head.next = tail;
        tail.prev = head;
    }



    public void addFirst(Node node) {
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!必须先修改node的prev和next
        //修改node
        node.prev = head;
        node.next = head.next;

        //修改node和前后一个节点的指针 即node左右边节点
        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node node) {
        int key = node.key;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;
        return delete(tail.prev);
    }

}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

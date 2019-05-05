package interview.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zoujialei on 2018/7/6.
 * ref:
 https://yikun.github.io/2015/04/03/%E5%A6%82%E4%BD%95%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AALRU-Cache
 */
public class LRUCache<E> {


    public LRUCache(int cap){
        this.cap = cap;
    }

    class Node{
        Node pre;
        Node next;
        E value;
        String key;

        Node(String key, E e){
            this.key = key;
            this.value = e;
        }
    }


    public Node head; //oldest
    public Node tail; //youngest
    private int cap;
    private int size = 0;

    Map<String, Node> map = new HashMap<>();

    public E get(String key){
        Node node = map.get(key);
        if(node != null){
            refresh(node);
            return node.value;
        }else {
            return null;
        }
    }

    public void add(String key, E value){
        Node node = map.get(key);
        //不存在
        if(node == null){
            Node newNode = new Node(key, value);
            if(size < cap){  //-未超过cap
                if(size == 0){
                    head = newNode;
                    tail = newNode;
                }else {
                    addToTail(newNode);
                }
                size++;

            }else {//超过cap
                map.remove(head.key);
                head = head.next;
                head.pre = null;
                addToTail(newNode);
            }
            map.put(key, newNode);
        }else {//存在
            node.value = value;
            refresh(node);
        }

        return;

    }

    private void addToTail(Node node){
        node.next = null;
        node.pre = tail;
        tail.next = node;
        tail = node;
    }

    private void refresh(Node node){
        if(tail == node){ //最后一个结点
        }else if(head == node){ //第一个结点
            head = head.next;
            addToTail(node);
        }else {  //中间结点
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addToTail(node);
        }
    }

    public void print(Node node){
        while (node != null){
            System.out.println(node.value.toString());
            node = node.next;
        }
        System.out.println("end");
    }



}

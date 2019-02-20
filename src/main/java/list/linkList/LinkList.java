package list.linkList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zoujialei on 17/12/24.
 */
public class LinkList<E extends Comparable<E>> {

    int size;

    LinkListNode head = new LinkListNode();


    public LinkListNode add(LinkListNode node){
        if(head.next == null){ //first time insert
            head.next = node;
            size ++;
            return head;
        }

        //find the right place，the new node value is between pre and current value
        //if the node value is bigger than all of the exist values, then the new node will append at the end of the list
        LinkListNode pre = head;
        LinkListNode current = head.next;
        while (current != null){
            if(((E)node.value).compareTo((E)current.value)>0){
                pre = pre.next;
                current = current.next;
            }else{
                break;
            }
        }
        pre.next = node;
        node.next = current;
        size++;

        return head;
    }

    public boolean del(LinkListNode node){
        if(size<1){
            return false;
        }
        LinkListNode pre = head;
        LinkListNode current = head.next;
        while (current != null){
            LinkListNode next = current.next;
            if(((E)node.value).compareTo((E)current.value)<0){
                return false;
            }else if(((E)node.value).compareTo((E)current.value)==0){
                pre.next = next;
                current.value = null;
                current.next = null;
                size--;
                return true;
            }else {
                pre = current;
                current = next;
            }
        }
        return false;
    }

    public static LinkList invert(LinkList list){
        LinkListNode head = list.head;
        if (head == null){
            return list;
        }
        LinkListNode pre = head;
        LinkListNode current = head.next;

        while (current != null){
            LinkListNode next = current.next;
            if(next != null){
                if(pre == head){//fisrt element
                    current.next = null;
                }else {
                    current.next = pre;
                }
                pre = current;
                current = next;
            }else {
                //last element
                current.next = pre;
                head.next = current;
                break;
            }
        }
        return list;

    }

    /**
     * 1. 实际上pre、cur、next都要记录下来，之后才做指向变更，和人在做这件事的时候，将这三个记录在大脑里是一样的
     * 2. 初始的head节点要单独记录，其指针指向，要指向为空
     * @param head
     * @return
     */
    public static LinkListNode reverseHead(LinkListNode head){

        if(head == null){
            return head;
        }

        LinkListNode pre = head;
        LinkListNode cur = head.next;
        LinkListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        head.next = null;
        head = pre;
        return head;


    }



    public static String printAll(LinkList list){
        String nodes = "LinkListNode: size:"+list.size + " elements: ";
        LinkListNode current = list.head.next;
        while (current !=null){
            nodes = nodes + current.value.toString()+" ";
            current = current.next;
        }
        return nodes;
    }

    public static String printNode(LinkListNode head){
        String nodes =  " elements: ";
        LinkListNode current = head;
        while (current !=null){
            nodes = nodes + current.value.toString()+" ";
            current = current.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        LinkList<Integer> integerLinkList = new LinkList<Integer>();
        integerLinkList.add(new LinkListNode(5));
        integerLinkList.add(new LinkListNode(8));
        integerLinkList.add(new LinkListNode(23));
        integerLinkList.add(new LinkListNode(1));
        integerLinkList.add(new LinkListNode(50));

        System.out.println("result: " + printAll(integerLinkList));

//        System.out.println("invert result: " + printAll(invert(integerLinkList)));

        System.out.println("invert result: " + printNode(reverseHead(integerLinkList.head.next)));

//        integerLinkList.del(new LinkListNode(23));
//
//        System.out.println("result: " + printAll(integerLinkList));
//
//        integerLinkList.del(new LinkListNode(24));
//        System.out.println("result: " + printAll(integerLinkList));
//
//        List<String> stringList = new LinkedList<String>();

    }

}

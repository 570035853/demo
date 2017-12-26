package list.linkList;

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


    public static String printAll(LinkList list){
        String nodes = "LinkListNode: size:"+list.size + " elements: ";
        LinkListNode current = list.head.next;
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


        integerLinkList.del(new LinkListNode(23));

        System.out.println("result: " + printAll(integerLinkList));

        integerLinkList.del(new LinkListNode(24));
        System.out.println("result: " + printAll(integerLinkList));

        List<String> stringList = new LinkedList<String>();

    }

}

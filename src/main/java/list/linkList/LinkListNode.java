package list.linkList;

/**
 * Created by zoujialei on 17/12/24.
 */
public class LinkListNode<E> {

    E value;

    LinkListNode next;

    LinkListNode(E e){
        this.value = e;
        this.next = null;
    }

    LinkListNode(){

    }
}

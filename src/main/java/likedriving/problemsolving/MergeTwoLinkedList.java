package likedriving.problemsolving;

import java.util.Arrays;
import java.util.List;

public class MergeTwoLinkedList {

    private static List<LinkedListNode> init(){
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(3);
        head1.next.next = new LinkedListNode(5);

        LinkedListNode head2 = new LinkedListNode(2);
        head2.next = new LinkedListNode(4);
        head2.next.next = new LinkedListNode(6);
        //head2.next.next.next = new LinkedListNode(8);
        //head2.next.next.next.next = new LinkedListNode(10);
        return Arrays.asList(head1, head2);
    }

    private static LinkedListNode mergeLinkedList(LinkedListNode head1, LinkedListNode head2){
        if(head1 == null && head2 == null){
            return null;
        }

        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }
        //System.out.println(head1.data+" "+head2.data);
        LinkedListNode temp1 = head1.next;
        LinkedListNode temp2 = head2.next;

        head1.next = head2;
        if(temp1 != null) head2.next = temp1;
        return mergeLinkedList(temp1, temp2);
    }

    public static void main(String[] args) {
        List<LinkedListNode> list = init();
        LinkedListNode head = mergeLinkedList(list.get(0), list.get(1));
        //System.out.println("checking what is being returned: " +head.data);
        LinkedListNode head1 = list.get(0);
        while (head1 != null){
            System.out.print(head1.data+" ");
            head1 = head1.next;
        }
    }
}

class LinkedListNode{
    int data;
    LinkedListNode next;
    LinkedListNode(int data){
        this.data = data;
    }
}

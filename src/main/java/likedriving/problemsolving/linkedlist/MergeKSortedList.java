package likedriving.problemsolving.linkedlist;

public class MergeKSortedList {

    public static void main(String[] args) {
        //lists = [[1,4,5],[1,3,4],[2,6], [7]]

        ListNode [] lists = new ListNode[3];

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);

        lists[0] = head;

       // System.out.println(lists[0].next.next.val);

        head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);

        lists[1] = head;

        head = new ListNode(2);
        head.next = new ListNode(6);

        lists[2] = head;

        ListNode result = new MergeKSortedList().mergeKLists(lists);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    ListNode head = null;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1) return lists[0];

        for(int i=0; i< lists.length-1; i++) {
            if(i==0) twoWayMerge(lists[i], lists[i+1]);
            else twoWayMerge(head, lists[i+1]);
        }
        return head;
    }

    private void twoWayMerge(ListNode a, ListNode b) {
        ListNode temp = null;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                if (temp == null) {
                    temp = new ListNode(a.val);
                    head = temp;
                } else {
                    temp.next = new ListNode(a.val);
                    temp = temp.next;
                }
                a = a.next;
            } else {
                if (temp == null) {
                    temp = new ListNode(b.val);
                    head = temp;
                } else {
                    temp.next = new ListNode(b.val);
                    temp = temp.next;
                }
                b = b.next;
            }
        }

        while (a != null) {
            if (temp == null) {
                temp = new ListNode(a.val);
                head = temp;
            } else {
                temp.next = new ListNode(a.val);
                temp = temp.next;
            }
            a = a.next;
        }

        while (b != null) {
            if (temp == null) {
                temp = new ListNode(b.val);
                head = temp;
            } else {
                temp.next = new ListNode(b.val);
                temp = temp.next;
            }
            b = b.next;
        }
    }
}

import java.util.List;

public class MergeSortLinkedList {

    public ListNode merge_sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = split(head);
        ListNode nextofmiddle = middle.next;
        middle.next = null;

        ListNode left = merge_sort(head);

        ListNode right = merge_sort(nextofmiddle);

        ListNode sortedlist = merge(left, right);
        return sortedlist;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if(left==null)
            return right;
        if(right==null)
            return left;
        ListNode sortedList;
        if (left.val < right.val) {
            sortedList = left;
            sortedList.next = merge(left.next, right);
        } else {
            sortedList = right;
            sortedList.next = merge(left, right.next);
        }
        return sortedList;
    }

    public ListNode split(ListNode head) {
        //Why we set fast to next pointer is to avoid getting into infinite loop. Start fast from head and you wil notice that.
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }



}

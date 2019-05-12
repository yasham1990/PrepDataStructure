public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode mid=getMid(head);
        ListNode reverseHalf=reverse(mid.next);
        return compareList(head, reverseHalf);
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    private boolean compareList(ListNode head, ListNode reverseHalf) {
        while(head!=null && reverseHalf!=null){
            if(head.val!=reverseHalf.val)
                return false;
            head=head.next;
            reverseHalf=reverseHalf.next;
        }
        return true;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
}

//T(O): O(max(m,n))
//S(O): O(max(m,n))

public class AddTwoNumbers {
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode p=l1;
        ListNode q=l2;
        ListNode current=dummy;

        int carry=0;

        while(p!=null || q!=null){
            int valP=(p!=null)?p.val:0;
            int valQ=(q!=null)?q.val:0;
            int sum=carry+valP+valQ;
            carry=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;
            if(p!=null)
                p=p.next;
            if(q!=null)
                q=q.next;

        }
        if(carry>0){
            current.next=new ListNode(carry);
        }
        return dummy.next;

    }*/

    class SinglyLinkedListNode{
        int val;
        SinglyLinkedListNode next=null;
        SinglyLinkedListNode(int val){
            this.val=val;
        }

    }

    public SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l_a, SinglyLinkedListNode l_b) {
        if(l_a==null)
            return l_b;
        if(l_b==null)
            return l_a;
        SinglyLinkedListNode head=new SinglyLinkedListNode(0);
        SinglyLinkedListNode cur=head;
        int carry=-1;
        while(l_a!=null && l_b!=null){
            int val=(l_a.val+l_b.val)%10;
            carry=(l_a.val+l_b.val)/10;
            l_a=l_a.next;
            l_b=l_b.next;
            cur=new SinglyLinkedListNode(val);
            cur=cur.next;
        }
        while(l_a!=null){
            int val=(l_a.val+carry)%10;
            carry=(l_a.val+carry)/10;
            l_a=l_a.next;
            cur=new SinglyLinkedListNode(val);
            cur=cur.next;
        }
        while(l_b!=null){
            int val=(l_b.val+carry)%10;
            carry=(l_b.val+carry)/10;
            l_b=l_b.next;
            cur=new SinglyLinkedListNode(val);
            cur=cur.next;
        }
        if(carry!=-1 && carry!=0)
            cur=new SinglyLinkedListNode(carry);
        return head.next;

    }

}

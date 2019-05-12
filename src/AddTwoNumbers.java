//T(O): O(max(m,n))
//S(O): O(max(m,n))

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    }

    class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }

    }
}

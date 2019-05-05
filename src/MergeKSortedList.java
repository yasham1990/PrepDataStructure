//T(O)= O(N logk), S(0)=1

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        int interval=1;

        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i=i+interval*2){
                lists[i]=merge(lists[i],lists[i+interval]);
            }


            interval*=2;
        }
        return lists[0];

    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        ListNode l3 = new ListNode(0);
        ListNode curr=l3;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1==null && l2!=null)
            curr.next=l2;
        if(l2==null && l1!=null)
            curr.next=l1;
        return l3.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}

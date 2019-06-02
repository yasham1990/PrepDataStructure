public class DeepCopy {
    public static CopyLinkList cloneLinkedList(CopyLinkList list) {
        if(list==null)
            return list;

        CopyLinkList curr=list;
        CopyLinkList newHead=null;

        while(curr!=null){
            CopyLinkList next=curr.next;
            newHead=new CopyLinkList(curr.data);
            newHead.next=next;
            curr.next=newHead;
            curr=next;
        }

        curr=list;

        while(curr!=null){
            if(curr.randomPointer!=null)
                curr.next.randomPointer=curr.randomPointer.next;
            curr=curr.next.next;
        }

        curr=list;
        CopyLinkList clonedList = new CopyLinkList(0);
        CopyLinkList clonedListTail = clonedList;
        while(curr!=null){
            clonedListTail.next=curr.next;
            clonedListTail=clonedListTail.next;
            curr.next=curr.next.next;
            curr=curr.next;
        }

        return clonedList.next;
    }

}

class CopyLinkList{
    int data;
    CopyLinkList next;
    CopyLinkList randomPointer;

    CopyLinkList(int data){
        this.data=data;
    }
}

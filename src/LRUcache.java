import java.util.HashMap;
import java.util.Map;


//T(O): get O(1), put O(1)
public class LRUcache {

    int capacity;
    Map<Integer, Node> map=new HashMap();
    Node head=null;
    Node end=null;

    public LRUcache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            setHead(node);
        }
        else{
            Node node=new Node(key,value);
            if(map.size()>=capacity){
                Node n=map.get(end.key);
                map.remove(end.key);
                remove(n);
            }
            setHead(node);
            map.put(key,node);

        }

    }

    public void setHead(Node n){
        n.next=head;
        n.prev=null;
        if(head!=null)
            head.prev=n;
        head=n;
        if(end==null)
            end=head;
    }

    public void remove(Node n){
        if(n.prev!=null)
            n.prev.next=n.next;
        else
            head=n.next;

        if(n.next!=null)
            n.next.prev=n.prev;
        else
            end=n.prev;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
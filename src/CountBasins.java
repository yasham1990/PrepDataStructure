import java.util.*;

public class CountBasins {

    public List<Integer> find_basins(List<List<Integer>> matrix) {
        int[][] basins=new int[matrix.size()][matrix.get(0).size()];

        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                basins[i][j]=-1;
            }
        }

        int basinIndex=0;

        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                if(helper(matrix, basins, i,j,basinIndex)==basinIndex)
                    basinIndex++;
            }
        }

        List<Integer> list=new ArrayList<>(basinIndex);
        for(int i=0;i<basinIndex;i++){
            list.add(0);
        }
        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                int index=basins[i][j];
                list.set(index, list.get(index)+1);
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }

    int helper(List<List<Integer>> matrix, int[][] basins, int i, int j, int basinIndex){
        if(basins[i][j]==-1){
            int mRow=i;int mCol=j;
            if(j>0 && matrix.get(i).get(j-1) < matrix.get(mRow).get(mCol)){
                mCol=j-1;
                mRow=i;
            }
            if(i>0 && matrix.get(i-1).get(j) < matrix.get(mRow).get(mCol)){
                mRow=i-1;
                mCol=j;
            }
            if(i<matrix.size()-1 && matrix.get(i+1).get(j) < matrix.get(mRow).get(mCol)){
                mRow=i+1;
                mCol=j;
            }
            if(j<matrix.get(0).size()-1 && matrix.get(i).get(j+1) < matrix.get(mRow).get(mCol)){
                mRow=i;
                mCol=j+1;
            }
            if(mCol==j && mRow==i)
                basins[i][j]=basinIndex;
            else
            {
                basins[i][j]=helper(matrix, basins, mRow,mCol,basinIndex);
            }
        }
        return basins[i][j];
    }

}

class LRUCache {

    Node head=null;
    Node end=null;
    Map<Integer, Node> map=new HashMap();;
    int capacity=0;

    public LRUCache(int capacity) {
        capacity=this.capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println("end is "+end.key);
        System.out.println("map is "+map.size());
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            setHead(node);
        }else{
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

    void remove(Node node){
        if(node.prev==null)
            head=node.next;
        else
            node.prev.next=node.next;

        if(node.next==null)
            end=node.prev;
        else
            node.next.prev=node.prev;

    }

    void setHead(Node n){
        n.next=head;
        n.prev=null;
        if(head!=null)
            head.prev=n;
        head=n;
        if(end==null)
            end=head;


    }

    class Node{
        int val;
        int key;
        Node next=null;
        Node prev=null;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
}


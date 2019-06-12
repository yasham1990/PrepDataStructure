import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthLargestUniqueElementStream {

    private int[] topK(int[] arr, int k) {
        if(arr==null || arr.length==0)
            return arr;
        if(k<1)
            return null;

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Set<Integer> set=new HashSet<>();
        for(int a:arr){
            if(!set.contains(a)) {
                set.add(a);
                priorityQueue.offer(a);
                if(priorityQueue.size()>k){
                    priorityQueue.poll();
                }
            }
        }
        int[] result=new int[priorityQueue.size()];
        for(int i=0;i<result.length;i++){
            result[i]=priorityQueue.poll();
        }
        return result;

    }

    public static void main(String args[]){
        KthLargestUniqueElementStream kthLargestUniqueElementStream=new KthLargestUniqueElementStream();
        kthLargestUniqueElementStream.topK(new int[]{5,6,1,4,1,8,4,1,7,9,3,2,1},2);
    }


}

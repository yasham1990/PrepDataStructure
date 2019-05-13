import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementArrayakaQuickSelect {

    //Obvious solution will be sort.
    //second approach we will use is via heap
    //T(O)=O(nlogk)
    //S(O)=O(k)
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)->n1-n2);
        for(int n:nums){
            heap.add(n);
            if(heap.size()>k)
                heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args){
        KthLargestElementArrayakaQuickSelect ka=new KthLargestElementArrayakaQuickSelect();
        int abc[]={3,2,3,1,2,4,5,5,6};
        System.out.println("Element is "+ka.findKthLargest(abc,4));
    }

    int nums[];

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = this.nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }

    private void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    private int partition(int pivotIndex, int left, int right){
        int pivot=this.nums[pivotIndex];
        swap(pivotIndex, right);
        int j=left;
        for(int i=left;i<=right;i++){
            if(this.nums[i]<pivot){
                swap(j,i);
                j++;
            }
        }
        swap(j,right);
        return j;
    }

    private int quickselect(int left,int right,int target){
        if(left==right)
            return this.nums[left];
        Random random_num = new Random();
        int pivotIndex=left+random_num.nextInt(right-left);
        pivotIndex=partition(pivotIndex, left, right);
        if (target == pivotIndex)
            return this.nums[target];
        else if (target < pivotIndex)
            return quickselect(left, pivotIndex - 1, target);
        else
            return quickselect(pivotIndex + 1, right, target);
    }
}

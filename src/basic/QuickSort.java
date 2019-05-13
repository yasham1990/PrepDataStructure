package basic;

public class QuickSort {

    public static void main(String args[]){
        QuickSort ob = new QuickSort();
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        ob.sysOut(arr);
        ob.sort(arr, 0, arr.length-1);
        System.out.println("\nSorted array");
        ob.sysOut(arr);
    }

    private void sysOut(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private void sort(int arr[], int l, int r){
        if (l < r)
        {
            // Find the middle point
            int partitionInd = part(arr,l,r);
            // Sort recursively before and after partition
            sort(arr, l, partitionInd-1);
            sort(arr , partitionInd+1, r);
        }
    }

    private int part(int arr[], int l, int h){
        int pivotal=arr[h];
        int i=l-1;
        for(int j=l; j<h;j++) {
            if (arr[j] <= pivotal) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;
        return i+1;
    }

}

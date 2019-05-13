package basic;

public class MergeSort {

    // Main function that sorts arr[l..r] using
    // merge()
    public static void main(String args[]){
        MergeSort ob = new MergeSort();
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
            int m = (l+r)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int l, int m,int r){
        int[] left=new int[m-l+1];
        int[] right=new int[r-m];
        for(int i=0;i<left.length;i++)
            left[i]=arr[l+i];
        for(int i=0;i<right.length;i++)
            right[i]=arr[m+i+1];
        int i=0,j=0;
        int k=l;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k]=right[j];
            j++;
            k++;
        }
    }


}

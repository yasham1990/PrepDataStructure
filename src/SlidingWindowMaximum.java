public class SlidingWindowMaximum {


    //T(O):T(Nk)
    //S(O):S(N-k+1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        if(n*k==0)
            return new int[0];

        int[] output=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            output[i]=max;
        }
        return output;

    }

    //T(O):T(N)
    //S(O):S(N)
    public int[] maxSlidingWindowOptimized(int[] nums, int k) {
        int n =nums.length;
        if(n*k==0)
            return new int[0];
        if(k==1)
            return nums;

        int[] left=new int[n];
        left[0]=nums[0];
        int[] right=new int[n];
        right[0]=nums[n-1];
        for(int i=1;i<n;i++){

            if(i%k==0)
                left[i]=nums[i];
            else
                left[i]=Math.max(left[i-1], nums[i]);

            int j=n-i-1;
            if((j+1)%k==0)
                right[j]=nums[j];
            else
                right[j]=Math.max(right[j+1],nums[j]);

        }
        int[] output=new int[n-k+1];
        for(int i=0;i<n-k+1;i++)
            output[i]=Math.max(right[i],left[i+k-1]);

        return output;

    }

}

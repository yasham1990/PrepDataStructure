public class CoinChange {



    int winMaximum(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        helper(arr, dp, 0, n - 1);
        return dp[0][n - 1];
    }

    int helper(int arr[], int dp[][],int start, int end){
        if(dp[start][end]!=0)
            return dp[start][end];
        if(start==end)
            return dp[start][end]=arr[start];
        if(start+1==end)
            return dp[start][end]=Math.max(arr[start], arr[end]);

        dp[start][end]=Math.max(arr[start]+Math.min(helper(arr,dp,start+2,end),helper(arr,dp,start+1,end-1))
                ,arr[end]+Math.min(helper(arr,dp,start+1,end-1),helper(arr,dp,start,end-2)));
        return dp[start][end];
    }


}

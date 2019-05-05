public class LongestPalindromeSubseq {

    //T(O)=exponential of n
    //S(O)=O(1)
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0)
            return 0;
        return LPS(s,0,s.length()-1);
    }

    private int LPS(String s, int left, int right){
        if(left==right)
            return 1;
        if(s.charAt(left)==s.charAt(right) && left+1==right){
            return 2;
        }

        if(s.charAt(left)==s.charAt(right))
            return LPS(s, left+1,right-1)+2;

        return Math.max(LPS(s,left,right-1),LPS(s,left+1,right));
    }


    //T(O)=O(n^2)
    //S(O)=O(n^2)
    public int longestPalindromeSubseqDP(String s) {
        if(s.length()==0)
            return 0;
        int n=s.length();
        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        int j=0;
        for(int k=2;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && k==2)
                    dp[i][j]=2;
                else if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }


}

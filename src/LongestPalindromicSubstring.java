public class LongestPalindromicSubstring {


    //There are many approaches vailable for this question

    //Fisrt and obvious one would be O(n^3), brute force
    //Second would be Dynamic Programming that will tone down the Time Complexity to O(n^2)
    //Third would be 2n-1 centered approach as we can consider cases for both and even loop.


    public String longestPalindromeDP(String s) {
        if(s.length()==0)
            return "";
        int n=s.length();
        boolean[][] dp =new boolean[n][n];


        for(int i=0;i<n;i++)
            dp[i][i]=true;
        int maxlength = 1;
        int start = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxlength=2;
            }

        }
        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    if(k>maxlength){
                        start=i;
                        maxlength=k;
                    }
                }
            }
        }

        return s.substring(start,start+maxlength);

    }

    public String longestPalindromeCornerApproach(String s) {
        if(s.length()==0)
            return "";
        int n=s.length();

        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            int len1=checkPalSubstring(s,i,i);
            int len2=checkPalSubstring(s,i,i+1);
            int max=Math.max(len1,len2);
            if(max>end-start){
                start=i-(max-1)/2;
                end=i+max/2;
            }

        }


        return s.substring(start,end+1);

    }

    private int checkPalSubstring(String s, int left, int right){
        while(right<s.length() && left>=0 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

}


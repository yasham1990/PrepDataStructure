public class LongestPalindrome {


    public int longestPalindrome(String s) {

        int res=0;
        if(s.length()<1)
            return res;

        int[] count=new int[128];
        for(char c:s.toCharArray()){
            count[c]++;
        }

        for(int v:count){
            res+=v/2*2;
            if(res%2==0 && v%2==1)
                res++;
        }
        return res;
    }


}

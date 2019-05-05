import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {


    //Through recursion
    boolean finalResult=false;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordBreakHelper(s,s.length(),"",wordDict);
        return finalResult;
    }

    private void wordBreakHelper(String s,int n,String result,List<String> wordDict){
        if(!finalResult){
            for(int i=1;i<=n;i++){
                String prefix=s.substring(0,i);
                if(wordDict.contains(prefix)){
                    if(i==n){
                        finalResult=true;
                    }
                    wordBreakHelper(s.substring(i,n),n-i,result+prefix+" ", wordDict);
                }
            }
        }
    }

    //Without Printing
    //boolean finalResult=false;
    public boolean wordBreak1(String s, List<String> wordDict) {
        wordBreakHelper(s,s.length(),wordDict);
        return finalResult;
    }

    private void wordBreakHelper(String s,int n,List<String> wordDict){
        if(!finalResult){

            for(int i=1;i<=n;i++){
                String prefix=s.substring(0,i);
                if(wordDict.contains(prefix)){
                    if(i==n){
                        finalResult=true;
                    }
                    wordBreakHelper(s.substring(i,n),n-i, wordDict);

                }

            }

        }
    }

    //via DP
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}

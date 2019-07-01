import java.util.ArrayList;
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

    static int m =  (int) 1E9 + 7;

    public static int wordBreakCount(List<String> dictionary, String txt) {
        Set<String> set = new HashSet<>(dictionary);
        int[] DP = new int[txt.length()+1];
        wordBrkCountDP(set, txt, DP);
        return DP[0];
    }

    private static void wordBrkCountDP(Set<String> set, String txt, int[] DP){
        DP[txt.length()] = 1;

        for(int s=txt.length()-1; s >= 0; s--){
            for (int e=s; e<txt.length(); e++) {
                if(set.contains(txt.substring(s, e+1)))
                    DP[s] = (DP[s] + DP[e+1]) % m;
            }
        }
    }

    public static void main(String[] args){
        WordBreak wordBreak=new WordBreak();
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world1");
        int result=wordBreak.wordBreakCount(list,"helloworld");
        System.out.println(result);
    }


}

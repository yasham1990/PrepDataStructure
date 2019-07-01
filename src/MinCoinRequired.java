import java.util.Arrays;
import java.util.List;

public class MinCoinRequired {

    public static int minCoin(List<Integer> coins, int value) {
        int[] dp=new int[value+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=value;i++){
            for(int coin:coins){
                if(i>=coin){
                    dp[i]= Math.min(dp[i],1+dp[i-coin]);
                }

            }
        }
        return dp[value]>value?-1:dp[value];
    }

}

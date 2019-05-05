import java.util.HashSet;
import java.util.Set;

//T(O)=O(n);
//S(O)=O(n);
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set=new HashSet<Integer>();
        for(int num:nums){
            num_set.add(num);
        }

        int long_streak=0;
        for(int num:num_set){
            if(!num_set.contains(num-1)){
                int current=num;
                int curStreak=1;

                while(num_set.contains(current+1)){
                    current+=1;
                    curStreak+=1;
                }

                long_streak=Math.max(curStreak,long_streak);
            }
        }

        return long_streak;
    }
}

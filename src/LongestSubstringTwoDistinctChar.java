import java.util.HashMap;

public class LongestSubstringTwoDistinctChar {

    static int getLongestSubstringLengthExactly2DistinctChars(String s) {
        int max_len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0, right=0;

        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right))+1);
            }
            else
                map.put(s.charAt(right), 1);

            while(map.size()>2){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }

            if(map.size()==2){
                max_len=Math.max(max_len, right-left+1);
            }
            right++;
        }
        return max_len;
    }

}

//Space Complexity: O(n^3)
//Time Complexity: O(n^2 + nlog(n))

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null)
            return new ArrayList();
        Map<String,List<Integer>> map=new HashMap();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            int target=-current;
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    String key=current+","+nums[left]+","+nums[right];
                    if(!map.containsKey(key)){
                        List<Integer> list=new ArrayList();
                        list.add(current);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        map.put(key,list);
                    }
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else
                    left++;
            }


        }
        return new ArrayList(map.values());

    }
}

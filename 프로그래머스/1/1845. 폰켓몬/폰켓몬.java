import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int len = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int i =0 ; i<nums.length;i++){
            if(set.size()==len) break;
            if(!set.contains(nums[i])) set.add(nums[i]);
        }
        return set.size();
    }
}
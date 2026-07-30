import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int l = 0;
        int r = 0;
        int sum = sequence[0];
        int minDist = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(r<sequence.length){
            if(sum<k){
                r++;
                if(r<sequence.length){
                    sum+=sequence[r];
                }
            }else if(sum>k){
                sum-=sequence[l];
                l++;
            }else{
                int dist = r-l;
                if(dist<minDist){
                    minDist = dist;
                    answer = new int[]{l,r};
                }
                r++;
                if(r<sequence.length){
                    sum+=sequence[r];
                }
            }
        }
        
        
        return answer;
    }
}
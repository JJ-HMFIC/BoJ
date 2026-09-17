import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        
        
        Arrays.sort(d);
        int sum = 0;
        int idx = 0;
        
        for(int i = 0 ;i<d.length;i++){
            if(sum+d[i]<=budget){
                sum+=d[i];
                idx++;
            }
        }
        return idx;
    }
}
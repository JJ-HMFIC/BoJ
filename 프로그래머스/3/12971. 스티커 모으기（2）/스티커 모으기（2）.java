import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n==1) return sticker[0];
        int answer = Math.max(getMax(sticker,0,n-2),getMax(sticker,1,n-1));

        return answer;
    }
    public int getMax(int[] sticker, int start, int end){
        int prev1 = 0; //현재 값 선택 x
        int prev2 = 0; // 현재 값 선택 
        
        for(int i = start ; i<=end ; i++){
            int cur = Math.max(prev1, prev2 + sticker[i]);
            
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    
}
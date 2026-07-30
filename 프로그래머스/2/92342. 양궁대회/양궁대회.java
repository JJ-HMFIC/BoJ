import java.util.*;

class Solution {
    static int cnt;
    static int[] apeach;
    static int[] ryan;
    static int[] result;
    static int max;
    public int[] solution(int n, int[] info) {
        apeach = info.clone();
        ryan = new int[info.length];
        result = new int[]{-1};
        
        cnt = n;
        max = 0;
        
        dfs(0,0);
        
        return result;
    }
    public void dfs(int idx, int arrow){
        if(idx == 11){
            if(arrow<cnt){
                ryan[10]+= cnt-arrow;
            }
            
            int asum = 0;
            int rsum = 0;
            for(int i=0 ;i<11;i++){
                if(apeach[i]==0 && ryan[i]==0) continue;
                
                if(apeach[i]<ryan[i]) rsum+= 10-i;
                else asum+=10-i;
                
            }
            int diff = rsum - asum;
            
            if(diff>max){
                max = diff;
                result = ryan.clone();
            }
            
            else if(diff ==max && max>0){
                for(int i=10;i>=0;i--){
                    if(ryan[i]>result[i]){
                        result = ryan.clone();
                        break;
                    }else if(ryan[i]<result[i]){
                        break;
                    }
                }
            }
            if(arrow<cnt){
                ryan[10]-= cnt-arrow;
            }
            return;
        }
        
        int need = apeach[idx] + 1;
        if(cnt - arrow >= need){
            ryan[idx] = need;
            dfs(idx+1, arrow+ need);
            ryan[idx] = 0;
        }
        dfs(idx+1, arrow);
        
    }
}
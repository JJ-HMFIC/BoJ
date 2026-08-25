import java.util.*;
class Solution {
    Set<Integer>[] dp;
    public int solution(int N, int number) {
        dp = new HashSet[9];
        
        for(int i = 1 ; i<9;i++){
            dp[i] = new HashSet<>();
            
            String num = String.valueOf(N);
            String add = num;
            for(int j = 1; j<i;j++){
                add+= num;
            }
            dp[i].add(Integer.parseInt(add));
            
            for(int j = 1; j<i;j++){
                for(int a : dp[j]){
                    for(int b : dp[i-j]){
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(b!=0) dp[i].add(a/b);
                    }
                }
            }
            if(dp[i].contains(number)) return i;
        }
        
        
        return -1;
    }
}
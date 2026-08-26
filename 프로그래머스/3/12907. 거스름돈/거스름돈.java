import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int coin : money){
            for(int i = coin ;i <=n;i++){
                dp[i] += dp[i-coin];
                // 금액 i의 경우의 수는 i-coin 경우의 수에서 coin 하나 얹으면 되니까
            }
        }
        
        int answer = dp[n];
        return answer;
    }
}
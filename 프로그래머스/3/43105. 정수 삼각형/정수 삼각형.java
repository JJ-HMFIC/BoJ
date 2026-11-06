import java.util.*;
class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int h = triangle.length;
        dp = new int[h][h];
        for(int[]d : dp) Arrays.fill(d,-1);
        
        int answer = dfs(triangle,0,0);
        return answer;
    }
    public int dfs(int[][] triangle, int x, int y){
        if(x==triangle.length-1){
            return triangle[x][y];
        }
        if(dp[x][y]!=-1) return dp[x][y];
        
        int left = dfs(triangle,x+1,y);
        int right = dfs(triangle,x+1,y+1);
        dp[x][y] = triangle[x][y] + Math.max(left,right);
        
        return dp[x][y];
    }
}
import java.util.*;
class Solution {
    static int height;
    static int[][] memo;
    public int solution(int[][] triangle) {
        
        height = triangle.length;
        memo = new int[height][height];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dfs(triangle, 0,0);
        
    }
    static public int dfs(int[][] triangle, int x, int y){
        if(x == height -1){
            return triangle[x][y];
        }
        
        if(memo[x][y]!=-1){
            return memo[x][y];
        }
        
        int left = dfs(triangle,x+1,y);
        int right = dfs(triangle,x+1,y+1);
        
        memo[x][y] = triangle[x][y]+ Math.max(left,right);
        return memo[x][y];
    }
}
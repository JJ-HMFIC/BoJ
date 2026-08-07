import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        int INF = 100000*200;
        for(int i = 1 ; i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        
        for(int i = 0 ; i<fares.length;i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            
            map[start][end] = cost;
            map[end][start] = cost;
        }
        for(int k = 1; k<=n;k++){
            for(int i = 1 ; i<=n;i++){
                for(int j = 1 ; j<=n;j++){
                    if(map[i][k]!=INF && map[k][j]!=INF){
                        map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                    }
                }
            }
        }
        int answer = INF;
        for(int i = 1 ; i<=n ;i++){
            int cost = map[s][i] + map[i][a] + map[i][b];
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
}
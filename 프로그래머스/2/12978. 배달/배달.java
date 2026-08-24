import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        for(int i =1 ; i<=N;i++){
            Arrays.fill(map[i],10000000);
            map[i][i] = 0;
        }
        for(int[] info : road){
            int a = info[0];
            int b = info[1];
            int w = info[2];
            map[a][b] = Math.min(map[a][b],w);
            map[b][a] = Math.min(map[b][a],w);
        }
        for(int k = 1; k<=N;k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N;j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        for(int i = 1; i<=N;i++){
            if(map[1][i]<=K) answer++;
        }
        return answer;
        
    }
}
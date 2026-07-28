import java.util.*;
import java.io.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Deque<Grid> deque = new ArrayDeque<>();
        deque.add(new Grid(0,0,0));
        visited[0][0] = true;
        
        while(!deque.isEmpty()){
            Grid top = deque.poll();
            if(top.x == n-1 && top.y == m-1) return top.dist+1;
            
            for(int i =0 ;i<4;i++){
                int nx = top.x+dx[i];
                int ny = top.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;
                if(maps[nx][ny]==0) continue;
                
                visited[nx][ny] = true;
                deque.add(new Grid(nx,ny,top.dist+1));
                
            }
        }
        return -1;
        
    }
    public class Grid{
        int x;
        int y;
        int dist;
        public Grid(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
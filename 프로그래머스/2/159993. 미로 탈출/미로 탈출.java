import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m, sx, sy, lx, ly, ex, ey;
    public char[][] map;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ; j<m ; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S'){
                    sx = i;
                    sy = j;
                }
                if(map[i][j]=='L'){
                    lx = i;
                    ly = j;
                }
                if(map[i][j]=='E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        int a = bfs(sx,sy,lx,ly);
        int b = bfs(lx,ly,ex,ey);
        if(a==-1 || b == -1) return -1;
        return a+b ;
    }
    public int bfs(int sx, int sy,int ex,int ey){
        boolean[][] visited = new boolean[n][m];
        Deque<Grid> deque = new ArrayDeque<>();
        visited[sx][sy] = true;
        deque.add(new Grid(sx,sy,0));
        
        while(!deque.isEmpty()){
            Grid top = deque.poll();
            if(top.x == ex && top.y == ey) return top.dist;
            
            for(int i= 0 ; i<4 ;i++){
                int nx = dx[i] + top.x;
                int ny = dy[i] + top.y;
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visited[nx][ny]||map[nx][ny]=='X')continue;
                
                deque.add(new Grid(nx,ny,top.dist+1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
    static class Grid{
        int x,y, dist;
        public Grid(int x, int y , int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0 ; i< 5 ;i++){
           answer[i] = createMap(places[i]);
        }
        return answer;
    }
    public int createMap(String[] place){
        char[][] map = new char[5][5];
        
        for(int i =0 ; i<5 ; i++){
            for(int j = 0 ; j<5 ;j++){
                map[i][j] = place[i].charAt(j);
            }
        }
        
        for(int i =0 ; i<5 ; i++){
            for(int j = 0 ; j<5 ;j++){
                if(map[i][j]=='P'){
                    boolean result = bfs(i,j,map);
                    if(!result) return 0;
                }
            }
        }
        
        return 1;
    }
    public boolean bfs(int x, int y, char[][] map){
        boolean[][] visited = new boolean[5][5];
        Deque<Grid> deque = new ArrayDeque<>();
        visited[x][y] = true;
        deque.add(new Grid(x,y,0));
        
        while(!deque.isEmpty()){
            Grid top = deque.poll();
            if(top.dist >0 && map[top.x][top.y] == 'P') return false;
            
            for(int i=0;i<4;i++){
                int nx = top.x+dx[i];
                int ny = top.y+dy[i];
                
                if(nx<0||ny<0||nx>=5||ny>=5) continue;
                if(visited[nx][ny]|| map[nx][ny]=='X') continue;
                
                if(top.dist+1 <=2){
                    visited[nx][ny] = true;
                    deque.add(new Grid(nx,ny,top.dist+1));
                }
            }
        }
        return true;
    }
    static class Grid{
        int x,y,dist;
        public Grid(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
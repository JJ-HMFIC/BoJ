package kb_algorithm.week5;

import java.util.*;
class pro_map_min {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        if(maps[0][0] == 0) return -1; // 시작부터 벽이면 작동 못함
        int result = BFS(n,m,maps);
        return result;

    }
    public int BFS(int n, int m,int[][]maps){
        boolean[][] visited = new boolean[n][m];
        Deque<Map> queue = new ArrayDeque<>();
        queue.offer(new Map(0,0,1)); // 큐에 넣고
        visited[0][0] = true; // 방문처리

        while(!queue.isEmpty()){
            Map top = queue.poll();
            int xNow = top.getX();
            int yNow = top.getY();
            int count = top.getCount();

            if(xNow == n-1 && yNow == m-1) return count; // 도착하면 거리 반환

            for(int i=0;i<4;i++){
                int nx = xNow + dx[i];
                int ny = yNow + dy[i]; // 다음 상하좌우 좌표

                if(nx>=n||nx<0||ny>=m||ny<0
                        ||maps[nx][ny]== 0||visited[nx][ny]) continue;
                // 좌표를 벗어나거나 이미 방문했다면 예외 처리

                visited[nx][ny] = true; // 방문처리하고
                queue.offer(new Map(nx,ny,count+1)); // 거리를 늘려 방문처리
            }
        }
        return -1; // 큐를 다돌았는데 리턴 안했다면 도착할 수 없다
    }
    public class Map{ // x,y,거리 클래스
        int x;
        int y;
        int count;
        public Map(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
        public int getX() {return this.x;}
        public int getY() {return this.y;}
        public int getCount() {return this.count;}

    }
}
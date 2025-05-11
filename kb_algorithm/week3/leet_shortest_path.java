package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class leet_shortest_path {
    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1}; // 좌표 설정 잘하자

    static int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;


        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        // 첫 지점, 마지막 지점이 막혀있으면 어차피 안된다 , 얼리리턴
        if (n == 1 && grid[0][0] == 0) return 1;
        // 0 하나만 있는 경우 답은 1 , 얼리 리턴

        int answer = BFS(grid, 0, 0); // 나머지 케이스 bfs 돌리기
        return answer;

    }

    public int BFS(int[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();

        queue.offer(new Entry(i, j, 1)); // 첫 좌표 , 거리 1 넣기
        grid[i][j] = 1; // 그리고 1로 색칠하기 -> 다시 탐색 안함

        while (!queue.isEmpty()) {

            Entry top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (x == n - 1 && y == n - 1) return dist; // 도착지면 목적지 리턴

            for (int k = 0; k < 8; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx][ny] != 0) continue;
                // 예외 처리 + 이미 방문했으면 패스

                queue.offer(new Entry(nx, ny, dist + 1));
                // 큐에 넣고
                grid[nx][ny] = 1;
                // 방문 처리
            }
        }
        return -1; // 큐에 돌았는데 리턴이 안되면 도착 못하는 경우이다
    }

    class Entry { // 좌표, 거리 클래스
        int x;
        int y;
        int distance;
        public Entry(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }
    }

}



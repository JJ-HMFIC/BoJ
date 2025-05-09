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
        if (n == 1 && grid[0][0] == 0) return 1;


        int answer = BFS(grid, 0, 0);
        return answer;

    }

    public int BFS(int[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();

        queue.offer(new Entry(i, j, 1));
        grid[i][j] = 1;

        while (!queue.isEmpty()) {

            Entry top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (x == n - 1 && y == n - 1) return dist;

            for (int k = 0; k < 8; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx][ny] != 0) continue;

                queue.offer(new Entry(nx, ny, dist + 1));
                grid[nx][ny] = 1;
            }
        }
        return -1;
    }

    class Entry {
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



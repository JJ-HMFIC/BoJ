package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class leet_num_of_islands {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    BFS(grid, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void BFS(char[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();
        if (grid[i][j] == '1') {
            queue.offer(new Entry(i, j));
            grid[i][j] = '0';// 방문

            while (!queue.isEmpty()) {
                Entry top = queue.poll();
                int x = top.getX();
                int y = top.getY();

                for (int k = 0; k < 4; k++) {

                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;

                    if (grid[nx][ny] == '1') {
                        queue.offer(new Entry(nx, ny));
                        grid[nx][ny] = '0';
                    }
                }
            }
        }
    }
    private class Entry {
        int x;
        int y;

        public Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


